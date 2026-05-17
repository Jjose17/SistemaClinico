
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Prepagada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PrepagadaDAO implements CrudSimpleInterface<Prepagada> {
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public PrepagadaDAO() {
        CON = Conexion.getInstancia();
    }
    
    

    @Override
    public List<Prepagada> listar(String texto) {
        List<Prepagada> registros = new ArrayList<>();
        try{
            ps=CON.conectar().prepareStatement("SELECT id, nombre, tipo_plana, cobertura, telefono, activo "
                    + "FROM prepagada WHERE nombre LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Prepagada(rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo_plan"),
                        rs.getString("cobertura"), rs.getString("telefono"), rs.getBoolean("activo")));
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
    public boolean insertar(Prepagada obj) {
        resp=false;
        try{
            CON.conectar().prepareStatement("INSERT INTO prepagada (nombre, tipo_plan, cobertura, telefono, activo) "
                    + "VALUES (?, ?, ?, ?, 1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipoPlan());
            ps.setString(3, obj.getCobertura());
            ps.setString(4, obj.getTelefono());
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
    public boolean actualizar(Prepagada obj) {
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE prepagada SET nombre = ?, tipo_plan = ?, cobertura = ?, "
                    + "telefono = ? WHERE id = ?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipoPlan());
            ps.setString(3, obj.getCobertura());
            ps.setString(4, obj.getTelefono());
            ps.setInt(5, obj.getId());
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

    private boolean cambiarEstado(int id, boolean activo){
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE prepagada SET activo = ? WHERE id = ?");
            ps.setBoolean(1, activo);
            ps.setInt(2, id);
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
            ps=CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM prepagada");
            rs=ps.executeQuery();
            if(rs.next()){
                totalRegistros=rs.getInt("total");
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
            ps=CON.conectar().prepareStatement("SELECT id FROM prepgada WHERE nombre = ?");
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
