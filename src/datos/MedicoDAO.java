
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean activar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int total() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
