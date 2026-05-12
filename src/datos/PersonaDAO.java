
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Persona;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class PersonaDAO implements CrudSimpleInterface<Persona>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public PersonaDAO(){
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Persona> listar(String texto){
        List<Persona> registros = new ArrayList<>();
        try{
            ps = CON.conectar().prepareStatement("SELECT id, nombre, apellido, documento, telefono, correo, activo FROM persona WHERE nombre LIKE ?, apellido LIKE ?, documento LIKE ?");
            ps.setString(1, "%" + texto + "%"); 
            ps.setString(2, "%" + texto + "%");
            ps.setString(3, "%" + texto + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                registros.add(new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
                rs.getString("documento"), rs.getString("telefono"), rs.getString("correo"), rs.getBoolean("activo")));
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
        return registros;
    }
    
    
    
    @Override
    public boolean insertar(Persona obj){
        resp = false;
        try{
            ps = CON.conectar().prepareStatement("INSERT INTO persona (nombre, apellido, documento, telefono, correo, activo) "
                    + "VALUES (?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getCorreo());
            if (ps.executeUpdate() > 0){
                resp = true;
            };
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Persona obj) {
        resp = false;
        try{
            ps = CON.conectar().prepareStatement("UPDATE persona SET nombre =?, apellido =?, documento =?, telefono =?, correo =?  "
                    + "WHERE id =?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getCorreo());
            ps.setInt(6, obj.getId());
            if (ps.executeUpdate() > 0){
                resp = true;
                ps.close();
                }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
    resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE persona SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()> 0){
                resp = true;
                }
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
    public boolean activar(int id) {
          resp=false;
        try{
            ps=CON.conectar().prepareStatement("UPDATE categoria SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()> 0){
                resp = true;
                }
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
    public int total() {
        int totalRegistros =0;
        try{
            ps= CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM persona"); //El AS es el alias que pongo,osea una columna de total
            rs=ps.executeQuery();
            if(rs.next()){ //Si existe la fila de ese total, pasa al IF
                totalRegistros = rs.getInt("total");
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps = null;
            rs=null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try{
            ps=CON.conectar().prepareStatement("SELECT id FROM persona WHERE documento =?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
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
   //a
    }

