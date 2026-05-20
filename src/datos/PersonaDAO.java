
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
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    // Consulta limpia que selecciona los datos biográficos de la tabla persona
    String sql = "SELECT id, nombre, apellido, documento, telefono, correo, activo, rol FROM persona WHERE nombre LIKE ? OR documento LIKE ?";
    
    try {
        // CON es tu objeto de conexión a la base de datos (asegúrate de usar la variable correcta de tu clase)
        ps = CON.conectar().prepareStatement(sql);
        ps.setString(1, "%" + texto + "%");
        ps.setString(2, "%" + texto + "%");
        rs = ps.executeQuery();
        
        while (rs.next()) {
            Persona p = new Persona();
            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setDocumento(rs.getString("documento"));
            p.setTelefono(rs.getString("telefono"));
            p.setCorreo(rs.getString("correo"));
            // Mapeo del bit activo
            p.setActivo(rs.getBoolean("activo"));
            
            // Creamos el objeto Rol sobre la marcha con el String que viene de la BD
            String nombreRol = rs.getString("rol");
            if (nombreRol == null || nombreRol.isEmpty()) {
                nombreRol = "Paciente"; // Respaldo por defecto
            }
            
            // Instanciamos la entidad Rol y se la asignamos a la persona
            entidades.Rol objetoRol = new entidades.Rol();
            objetoRol.setNombre(nombreRol);
            p.setRol(objetoRol);
            
            registros.add(p);
        }
    } catch (Exception e) {
        System.out.println("Error en PersonaDAO.listar: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            CON.desconectar();
        } catch (Exception ex) {
            System.out.println("Error al cerrar conexiones: " + ex.getMessage());
        }
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
            ps=CON.conectar().prepareStatement("UPDATE persona SET activo=1 WHERE id=?");
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
            resp = rs.next();
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
    
    // ESTOS METODOS NOS VAN A AYUDAR PARA PODER TENER LA INFORMACION EN LOS COMBOS
    
    public List<String> obtenerTiposDocumento(){
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre_tipo FROM tipo_documento ORDER BY nombre_tipo ASC"; 
        try{
            ps = CON.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nombre_tipo"));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar tipos de documento: " + e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return lista;
    }

    public List<String> obtenerEntidades(){
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre_entidad FROM entidad ORDER BY nombre_entidad ASC"; 
        try{
            ps = CON.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(rs.getString("nombre_entidad"));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar entidades: " + e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return lista;
    }
}

