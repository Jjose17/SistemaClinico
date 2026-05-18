
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Medico;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class MedicoDAO implements CrudSimpleInterface<Medico> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public MedicoDAO() {
       CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Medico> listar(String texto) {
        List<Medico> registros = new ArrayList<>();
        try{
            ps = CON.conectar().prepareStatement("SELECT p.id, p.nombre, p.apellido, p.documento, p.telefono"
                    + " p.correo, p.activo, m.especialidad, m.num_licencia, m.horario FROM persona p"
                    + " INNER JOIN medico m ON p.id = m.id WHERE p.nombre, LIKE ? OR p.apellido LIKE ? OR p.documento LIKE ?"
                    + " OR m.especialidad LIKE ?");
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ps.setString(3, "%" + texto + "%");
            ps.setString(4, "%" + texto + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                registros.add(new Medico(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                rs.getString("documento"), rs.getString("telefono"), rs.getString("correo"), rs.getBoolean("activo"),
                rs.getString("especialidad"), rs.getString("num_licencia"), rs.getString("horario")));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Medico obj) {
        resp = false;
        Connection cn = CON.conectar();
        try{
            cn.setAutoCommit(false);
            ps=cn.prepareStatement("INSERT INTO persona (nombre, apellido, documento, telefono, correo, activo)"
                    + " VALUES (?, ?, ?, ?, ?, 1)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getCorreo());
            ps.executeUpdate();
            rs=ps.getGeneratedKeys();
            if(rs.next()){
                obj.setId(rs.getInt(1));
            }
            rs.close();
            ps.close();
            
            
            //Ahora el insertar del medico, igual que en la parte de paciente
            
            ps=cn.prepareStatement("INSERT INTO medico (id, especialidad, num_licencia, horario) VALUES"
                    + " (?,?,?,?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getEspecialidad());
            ps.setString(3, obj.getNumLicencia());
            ps.setString(4, obj.getHorario());
           resp = ps.executeUpdate() > 0;
           cn.commit();
           ps.close();
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
           ps = null;
            rs = null;
            try {
                cn.setAutoCommit(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Medico obj) {
        resp = false;
        Connection cn = CON.conectar();
     try {
        cn.setAutoCommit(false);
        
        //Actualizar tabla persona
        ps = cn.prepareStatement("UPDATE persona SET nombre = ?, apellido = ?, "
                + "documento = ?, telefono = ?, correo = ? WHERE id = ?");
        ps.setString(1, obj.getNombre());
        ps.setString(2, obj.getApellido());
        ps.setString(3, obj.getDocumento()); 
        ps.setString(4, obj.getTelefono());  
        ps.setString(5, obj.getCorreo());    
        ps.setInt(6, obj.getId());          
        ps.executeUpdate();
        ps.close();
        
        // Actualizamos la tabla medico especificamente
        ps = cn.prepareStatement("UPDATE medico SET especialidad = ?, num_licencia = ?, horario = ? "
                + "WHERE id = ?"); 
        ps.setString(1, obj.getEspecialidad());
        ps.setString(2, obj.getNumLicencia());
        ps.setString(3, obj.getHorario());
        ps.setInt(4, obj.getId());
        ps.executeUpdate();
        cn.commit();
        resp = true; // Solo es verdadero si el commit se completó
        ps.close();
        
    } catch (SQLException e) {
        if (cn != null) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en rollback: " + ex.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Error al actualizar médico: " + e.getMessage());
    } finally {
        ps = null;
        if (cn != null) {
            try {
                cn.setAutoCommit(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        CON.desconectar();
    }
    return resp;
}
 private boolean cambiarEstado(int id, boolean activo) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE persona SET activo = ? WHERE id = ?");
            ps.setBoolean(1, activo);
            ps.setInt(2, id);
            resp = ps.executeUpdate() > 0;
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }
    @Override
    public boolean desactivar(int id) {
        return cambiarEstado(id, false);
    }

    @Override
    public boolean activar(int id) {
        return cambiarEstado(id, true);
    }

    @Override
    public int total() {
        int totalRegistros =0;
        try{
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM medico");
            rs=ps.executeQuery();
            if(rs.next()){
            totalRegistros = rs.getInt("total");
        }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("SELECT p.id FROM persona "
                    + "p INNER JOIN medico m ON pd.id=m.id WHERE p.documento = ? OR m.num_licencia = ?");
            ps.setString(1, texto);
            ps.setString(2, texto);
            rs=ps.executeQuery();
            resp=rs.next();
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
        
    }
    
    // METODO PARA PODER SELECCIONAR A MEDICOS EN LA PARTE DE NUEVA CITA, NECESITAMOS LLAMAR A LOS MEDICOS QUE TENGAMOS
    
    public DefaultComboBoxModel seleccionaMedicos(){
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        combo.addElement("Selecciona un medico ");
        String med= "SELECT p.id, p.nombre, p.apellido " 
           + "FROM persona p " 
           + "INNER JOIN medico m ON p.id = m.id " 
           + "WHERE p.activo = b'1'";
        
        try{
            ps=CON.conectar().prepareStatement(med);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona p= new Persona();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                combo.addElement(p);
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
         ps=null;
        rs=null;
        CON.desconectar();
        }
        return combo;
    }
    
    
    
}
