
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

public class PacienteDAO implements CrudSimpleInterface<Paciente>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public PacienteDAO() {
        CON = Conexion.getInstancia();
    }
    
 @Override
 public List<Paciente> listar(String texto){
     List<Paciente> registros = new ArrayList<>();
     try{
         ps = CON.conectar().prepareStatement("SELECT p.id, p.apellido, p.documento, p.telefono, p.correo,"
                 +"p.activo, pa.edad, pa.direccion, pa.historial_medico,pa.prepagada_id FROM persona p INNER JOIN paciente pa ON p.id = pa.id"
                 + "WHERE p.nombre LIKE ?, p.apellido LIKE ?, p.documento LIKE ?"); //Con esto buscamos los pacientes que tengan nombre, apellido o documento, que esta en la tabla persona
         ps.setString(1, "%" + texto + "%");
         ps.setString(2, "%" + texto + "%");
         ps.setString(3, "%" + texto + "%");
         rs = ps.executeQuery();
         while(rs.next()){
             registros.add(new Paciente(rs.getInt("id"),rs.getString("nombre"), rs.getString("apellido"),
             rs.getString("documento"), rs.getString("telefono"), rs.getString("correo"), rs.getBoolean("activo"), rs.getInt("edad"),
             rs.getString("direccion"), rs.getString("historial_medico"), (Integer) rs.getObject("prepagada_id")));
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

 // Este insertar va a ser diferente, primero necesito que se "conecte" con la tabla "PACIENTE" porque persona va a heredar atributos a esta tabla
 // Asi que necesito que mantengan el mismo ID con el que se registra una persona y este ID se observe en la tabla PACIENTE
 // Cuando el PACIENTE tenga el mismo ID que la persona, entonces ya tendra que permitirle dejar insertar los datos del paciente y seguir manteniendo ese mismo ID cuando se registre el paciente, osea seria un tipo de return del ID
 // Tambien toca que cuando se inserte los datos completos del paciente, se guarden bien, pero que tal si un dato por ej, prepagada no existe? 
 // Lo que se haria es que no se guarden los "cambios" y vuelva a pedir todos los datos para que asi no queden pacientes con datos vacios y generen errores
 
    @Override
    public boolean insertar(Paciente obj) {
        resp=false;
        Connection cn = CON.conectar(); //con esto podemos abrir la conexion a la BD y lo guardamos en la variable
        try{
            cn.setAutoCommit(false); //con esto evitamos el guardado automatico que hace la BD y solo se guardaran unos cambios que nosotros completemos
            
// Hacemos el primer insert que va a guardar los datos de la persona y con ese ID que genera, se lo tenemos que pedir a MySQL
            ps=cn.prepareStatement("INSERT INTO persona (nombre, apellido, documento, telefono, correo, activo) VALUES (?,?,?,?,?,1)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getApellido());
            ps.setString(3, obj.getDocumento());
            ps.setString(4, obj.getTelefono());
            ps.setString(5, obj.getCorreo());
            ps.executeUpdate();
            rs=ps.getGeneratedKeys(); //con esto podemos obtener los datos generados junto con el ID (que por cierto, se crea como activo)
        if(rs.next()){
            obj.setId(rs.getInt(1));
        }
        rs.close();
        ps.close();
        
        
        
        ps=cn.prepareStatement("INSER INTO paciente (id, edad, direccion, historial_medico, prepagada_id) VALUES (?,?,?,?)");
        ps.setInt(1, obj.getId());
        ps.setInt(2, obj.getEdad());
        ps.setString(3, obj.getDireccion());
        ps.setString(4, obj.getHistorialMedico());
        
        //Necesitamos revisar que el paciente tenga o NO tenga una prepagada (No es obligatorio), entonces primero preguntamos si el paciente tiene una prepagada
        // Si no llega a tener una prepagada, manda un NULL a esa columna, pero si llega a tener una prepagada, entonces manda el ID de la prepagada a la columna 
       if(obj.getPrepagadaID() == null){
           ps.setNull(5, java.sql.Types.INTEGER);
       }else{
            ps.setInt(5, obj.getPrepagadaID());
        }
       resp=ps.executeUpdate() > 0; //Mira el INSERT de paciente y si inserto una columna almenos, resp queda en true
       cn.commit(); //Mira y nos confirma que si hayan insertado en las dos tablas, persona y paciente
       ps.close();
       
//Aca tenemos que hacer un error en caso de que no inserten en la tabla paciente, pues que borre todos los datos que se registraron 
        
        }catch(SQLException e){
            try{
                cn.rollback(); //deshace todos los cambios y no los guarda, con esto podemos hacer que si fallo una insercion y la finalizamos, no se guarde en la BD y queden campos vacios que generen erroes
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            
            //Con estos volvemos a dejar el Autocomit en automatico, osea se activa, como estaba antes que la cambiaramos arriba
            try{
                cn.setAutoCommit(true);
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Paciente obj) {
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
