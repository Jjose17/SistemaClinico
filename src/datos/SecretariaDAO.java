
package datos;


import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Secretaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SecretariaDAO implements CrudSimpleInterface<Secretaria> {
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public SecretariaDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Secretaria> listar(String texto) {
        List<Secretaria> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement(
                    "SELECT p.id, p.nombre, p.apellido, p.documento, p.telefono, p.correo, p.activo, s.turno "
                    + "FROM persona p INNER JOIN secretaria s ON p.id = s.id "
                    + "WHERE p.nombre LIKE ? OR p.apellido LIKE ? OR p.documento LIKE ? OR s.turno LIKE ?");
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ps.setString(3, "%" + texto + "%");
            ps.setString(4, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Secretaria(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("documento"), rs.getString("telefono"), rs.getString("correo"),
                        rs.getBoolean("activo"), rs.getString("turno")));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Secretaria obj) {
resp = false;
        Connection cn = CON.conectar();
        try {
            cn.setAutoCommit(false);
            ps = cn.prepareStatement("INSERT INTO persona (nombre, apellido, documento, telefono, correo, activo) VALUES (?, ?, ?, ?, ?, 1)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getCorreo());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            rs.close();
            ps.close();

            ps = cn.prepareStatement("INSERT INTO secretaria (id, turno) VALUES (?, ?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getTurno());
            resp = ps.executeUpdate() > 0;
            cn.commit();
            ps.close();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
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
    public boolean actualizar(Secretaria obj) {
         resp = false;
        Connection cn = CON.conectar();
        try {
            cn.setAutoCommit(false);
            ps = cn.prepareStatement("UPDATE persona SET nombre = ?, apellido = ?, documento = ?, telefono = ?, correo = ? WHERE id = ?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getCorreo());
            ps.setInt(6, obj.getId());
            ps.executeUpdate();
            ps.close();

            ps = cn.prepareStatement("UPDATE secretaria SET turno = ? WHERE id = ?");
            ps.setString(1, obj.getTurno());
            ps.setInt(2, obj.getId());
            resp = ps.executeUpdate() > 0;
            cn.commit();
            ps.close();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            try {
                cn.setAutoCommit(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM secretaria");
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRegistros = rs.getInt("total");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
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
            ps = CON.conectar().prepareStatement("SELECT p.id FROM persona p INNER JOIN secretaria s "
                    + "ON p.id = s.id WHERE p.documento = ?");
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
    
}
