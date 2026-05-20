
package datos;


import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO implements CrudSimpleInterface<Usuario> {
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public UsuarioDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Usuario> listar(String texto) {
         List<Usuario> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement(
       "SELECT u.id, u.rol_id, r.nombre AS rol_nombre, u.nombre, u.tipo_documento, u.num_documento, "
        + "u.direccion, u.telefono, u.correo, u.clave, u.activo "
         + "FROM usuario u INNER JOIN rol r ON u.rol_id = r.id "
           + "WHERE u.nombre LIKE ? OR u.num_documento LIKE ? OR u.correo LIKE ? OR r.nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ps.setString(3, "%" + texto + "%");
            ps.setString(4, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Usuario(rs.getInt("id"), rs.getInt("rol_id"), rs.getString("rol_nombre"),
                        rs.getString("nombre"), rs.getString("tipo_documento"), rs.getString("num_documento"),
                        rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"),
                        rs.getString("clave"), rs.getBoolean("activo")));
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
    public boolean insertar(Usuario obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO usuario (rol_id, nombre, "
                    + "tipo_documento, num_documento, direccion, telefono, correo, clave, activo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)");
            ps.setInt(1, obj.getRolId());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getTipoDocumento());
            ps.setString(4, obj.getNumDocumento());
            ps.setString(5, obj.getDireccion());
            ps.setString(6, obj.getTelefono());
            ps.setString(7, obj.getCorreo());
            ps.setString(8, obj.getClave());
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
    public boolean actualizar(Usuario obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE usuario SET rol_id = ?, nombre = ?, "
                    + "tipo_documento = ?, num_documento = ?, direccion = ?, telefono = ?, correo = ?, clave = ? WHERE id = ?");
            ps.setInt(1, obj.getRolId());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getTipoDocumento());
            ps.setString(4, obj.getNumDocumento());
            ps.setString(5, obj.getDireccion());
            ps.setString(6, obj.getTelefono());
            ps.setString(7, obj.getCorreo());
            ps.setString(8, obj.getClave());
            ps.setInt(9, obj.getId());
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
    
    private boolean cambiarEstado(int id, boolean activo) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE usuario SET activo = ? WHERE id = ?");
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
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM usuario");
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
            ps = CON.conectar().prepareStatement("SELECT id FROM usuario WHERE correo = ? OR num_documento = ?");
            ps.setString(1, texto);
            ps.setString(2, texto);
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
    
  public boolean login(String documento, String clave) {
        resp = false;
        String sql = "SELECT * FROM usuario WHERE num_documento = ? AND clave = ?";
        try {
            // Usamos la variable de conexión global de tu clase (CON)
            ps = CON.conectar().prepareStatement(sql);
            ps.setString(1, documento);
            ps.setString(2, clave);
            
            rs = ps.executeQuery();
            resp = rs.next(); // true si encuentra coincidencia
            
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en el login del DAO: " + e.getMessage(), "Error Base de Datos", JOptionPane.ERROR_MESSAGE);
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return resp;
    }
    
    // 🚀 Corregido: Agregamos 'String correo' a los parámetros para eliminar el error visual
    public boolean registrar(String nombre, String documento, String clave, String correo) {
        resp = false;
    // 🚀 Dejamos el '2' fijo porque corresponde al rol 'Secretaria' que insertamos arriba
    String sql = "INSERT INTO usuario (nombre, num_documento, clave, rol_id, correo, activo) VALUES (?, ?, ?, 2, ?, 1)";
    try {
        ps = CON.conectar().prepareStatement(sql);
        
        ps.setString(1, nombre);
        ps.setString(2, documento);
        ps.setString(3, clave);
        ps.setString(4, correo);
        
        resp = ps.executeUpdate() > 0;
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en el registro del DAO: " + e.getMessage(), "Error Base de Datos", JOptionPane.ERROR_MESSAGE);
    } finally {
        ps = null;
        CON.desconectar();
    }
    return resp;
}
    }
