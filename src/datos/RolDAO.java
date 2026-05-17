
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RolDAO implements CrudSimpleInterface<Rol>  {
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public RolDAO(){
            CON=Conexion.getInstancia();
    }

    @Override
    public List<Rol> listar(String texto) {
        List<Rol> registros = new ArrayList<>();
        try{
            CON.conectar().prepareStatement("SELECT id, nombre, descripcion FROM rol WHERE nombre LIKE = ?");
            ps.setString(1, "%" + texto + "%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Rol(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion")));
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
    
    //Ahora vamos a crear un metodo para traer los roles que tengamos disponibles para asi porder organizarlos alfabeticamente
    // Vammos a solicitar dos columnas (ID, nombre) de la tabla rol y los ordenamos de la A la Z gracias al ORDER BY  nombre ASC
    // 
    
    public List<Rol> seleccionar() {
        List<Rol> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT id, nombre FROM rol ORDER BY nombre ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Rol(rs.getInt("id"), rs.getString("nombre")));
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
    public boolean insertar(Rol obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("INSERT INTO rol (nombre, descripcion) VALUES (?, ?)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
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
    public boolean actualizar(Rol obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE rol SET nombre = ?, descripcion = ? WHERE id = ?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getId());
            resp = ps.executeUpdate() > 0;
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
    public boolean desactivar(int id) {
        return false;
    }

    @Override
    public boolean activar(int id) {
        return false;
    }

    @Override
    public int total() {
        int totalRegistros =0;
        try{
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM rol");
            rs=ps.executeQuery();
            if(rs.next()){
                totalRegistros =rs.getInt("total");
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
            ps=CON.conectar().prepareStatement("SELEC id FROM WHERE nombre = ?");
            ps.setString(1, texto);
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
    
    
    
}
