
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Cita;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CitaDAO implements CrudSimpleInterface<Cita>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public CitaDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Cita> listar(String texto) {
        List<Cita> registros = new ArrayList<>();
        try{
            ps=CON.conectar().prepareStatement("SELECT id, fecha, hora, estado, motivo, paciente_id, "
                    + "medico_id "
                    + "FROM cita WHERE estado LIKE ? OR motivo LIKE ? OR CAST(id AS CHAR) LIKE ?");
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ps.setString(3, "%" + texto + "%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                registros.add(new Cita(rs.getInt("id"), rs.getDate("fecha"), rs.getTime("hora"),
                        rs.getString("estado"), rs.getString("motivo"), rs.getInt("paciente_id"),
                        rs.getInt("medico_id")));
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
    public boolean insertar(Cita obj) {
        resp = false;
        try{
            ps=CON.conectar().prepareStatement("INSERT INTO cita (fecha, hora, estado, motivo, "
                    + "paciente_id, medico_id) VALUES ( ?, ?, ?, ?, ?, ?)");
            ps.setDate(1, obj.getFecha());
            ps.setTime(2, obj.getHora());
            ps.setString(3, obj.getEstado());
            ps.setString(4, obj.getMotivo());
            ps.setInt(5, obj.getPacienteID());
            ps.setInt(6, obj.getMedicoID());
            resp=ps.executeUpdate() > 0;
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Cita obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE cita SET fecha = ?, hora = ?, estado = ?, motivo = ?, paciente_id = ?, medico_id = ? WHERE id = ?");
            ps.setDate(1, obj.getFecha());
            ps.setTime(2, obj.getHora());
            ps.setString(3, obj.getEstado());
            ps.setString(4, obj.getMotivo());
            ps.setInt(5, obj.getPacienteID());
            ps.setInt(6, obj.getMedicoID());
            ps.setInt(7, obj.getId());
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


 private boolean cambiarEstado(int id, String estado) {
        resp = false;
        try {
            ps =CON.conectar().prepareStatement("UPDATE cita SET estado = ? WHERE id = ?");
            ps.setString(1, estado);
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
        return cambiarEstado(id, "Cancelada");
        
    }

    @Override
    public boolean activar(int id) {
        return cambiarEstado(id, "Programada");
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps =CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM cita");
            rs= ps.executeQuery();
            if(rs.next()) {
                totalRegistros = rs.getInt("total");
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistros;
    }    

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("SELECT id FROM cita WHERE id = ?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            resp = rs.next();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return resp;    
    }
    
    
    public boolean existeHorario(int pacienteID, int medicoID, Date fecha, Time hora) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("SELECT id FROM cita WHERE fecha = ? AND hora = ? "
                    + "AND (paciente_id = ? OR medico_id = ?)");
            ps.setDate(1, fecha);
            ps.setTime(2, hora);
            ps.setInt(3, pacienteID);
            ps.setInt(4, medicoID);
            rs = ps.executeQuery();
            resp = rs.next();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return resp;
    }
    
    
    
}
