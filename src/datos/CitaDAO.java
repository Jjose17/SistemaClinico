
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
import javax.swing.table.DefaultTableModel;

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


 public boolean cambiarEstado(int id, String estado) {
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
    
   
    public DefaultTableModel buscarCitasPorPaciente(String documento) {
    DefaultTableModel modelo;
    String[] titulos = {"ID CITA", "MÉDICO", "FECHA", "HORA", "MOTIVO", "ESTADO"};
    modelo = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Evita que editen directamente sobre las celdas
        }
    };

    String estado = "SELECT c.id, CONCAT(p_med.nombre, ' ', p_med.apellido) AS medico, c.fecha, c.hora, c.motivo, c.estado " +
                 "FROM cita c " +
                 "INNER JOIN persona p_pac ON c.paciente_id = p_pac.id " +
                 "INNER JOIN persona p_med ON c.medico_id = p_med.id " +
                 "WHERE p_pac.documento = ? " +
                 "ORDER BY c.fecha DESC, c.hora DESC";

    try {
        ps = CON.conectar().prepareStatement(estado);
        ps.setString(1, documento);
        rs = ps.executeQuery();
        
        String[] registro = new String[6];
        while (rs.next()) {
            registro[0] = String.valueOf(rs.getInt("id"));
            registro[1] = rs.getString("medico");
            registro[2] = String.valueOf(rs.getDate("fecha"));
            registro[3] = rs.getString("hora");
            registro[4] = rs.getString("motivo");
            registro[5] = rs.getString("estado");
            modelo.addRow(registro);
        }
        ps.close(); rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar citas: " + e.getMessage());
    } finally {
        CON.desconectar();
    }
    return modelo;
    
}
    //CON ESTE METODO VOY A PODER VER TODAS LAS CITAS QUE HAYAN EN UNA SEMANA, CLARO, CON SU FILTRO
    public DefaultTableModel listarCitasSemanalesConFiltro(Date fechaInicio, Date fechaFin, String texto) {
        DefaultTableModel modelo;
        String[] titulos = {"ID CITA", "PACIENTE", "MÉDICO", "FECHA", "HORA", "MOTIVO", "ESTADO"};
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String sql = "SELECT c.id, CONCAT(p_pac.nombre, ' ', p_pac.apellido) AS paciente, "
                   + "CONCAT(p_med.nombre, ' ', p_med.apellido) AS medico, c.fecha, c.hora, c.motivo, c.estado "
                   + "FROM cita c "
                   + "INNER JOIN persona p_pac ON c.paciente_id = p_pac.id "
                   + "INNER JOIN persona p_med ON c.medico_id = p_med.id "
                   + "WHERE (c.fecha BETWEEN ? AND ?) "
                   + "AND (p_pac.nombre LIKE ? OR p_pac.apellido LIKE ? OR p_pac.documento LIKE ? OR c.estado LIKE ?)"
                   + "ORDER BY c.fecha ASC, c.hora ASC";

        try {
            ps = CON.conectar().prepareStatement(sql);
            ps.setDate(1, fechaInicio);
            ps.setDate(2, fechaFin);
            String filtro = "%" + texto + "%";
            ps.setString(3, filtro);
            ps.setString(4, filtro);
            ps.setString(5, filtro);
            ps.setString(6, filtro);
            
            rs = ps.executeQuery();
            String[] registro = new String[7];
            
            while (rs.next()) {
                registro[0] = String.valueOf(rs.getInt("id"));
                registro[1] = rs.getString("paciente");
                registro[2] = rs.getString("medico");
                registro[3] = String.valueOf(rs.getDate("fecha"));
                registro[4] = rs.getString("hora");
                registro[5] = rs.getString("motivo");
                registro[6] = rs.getString("estado");
                modelo.addRow(registro);
            }
            ps.close(); 
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en vista semanal/filtro: " + e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return modelo;
    }
    
    public javax.swing.table.DefaultTableModel listarHistorialCitasPorPaciente(int idPaciente) {
    javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Evita que editen las celdas desde la interfaz
        }
    };
    
    // Definimos las columnas del historial para el expediente
    modelo.addColumn("FECHA");
    modelo.addColumn("HORA");
    modelo.addColumn("MÉDICO");
    modelo.addColumn("MOTIVO");
    modelo.addColumn("ESTADO");
    
    // Consulta SQL con INNER JOIN para traer el nombre completo del médico asignado
    String sql = "SELECT c.fecha, c.hora, CONCAT(p.nombre, ' ', p.apellido) AS medico, c.motivo, c.estado " +
                 "FROM cita c " +
                 "INNER JOIN persona p ON c.medico_id = p.id " +
                 "WHERE c.paciente_id = ? " +
                 "ORDER BY c.fecha DESC, c.hora DESC";
                 
    database.Conexion con = new database.Conexion(); // Ajusta según tu clase de conexión
    
    try (java.sql.Connection conn = con.conectar();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, idPaciente);
        try (java.sql.ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getDate("fecha");
                fila[1] = rs.getTime("hora");
                fila[2] = rs.getString("medico");
                fila[3] = rs.getString("motivo");
                fila[4] = rs.getString("estado");
                modelo.addRow(fila);
            }
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Error al obtener historial de citas: " + e.getMessage());
    }
    return modelo;
}
    
    
    }
