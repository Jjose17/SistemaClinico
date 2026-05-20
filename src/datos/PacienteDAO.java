
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
public List<Paciente> listar(String texto) {
    List<Paciente> registros = new ArrayList<>();
    try {
        ps = CON.conectar().prepareStatement(
            "SELECT p.id, p.nombre, p.apellido, p.documento, p.telefono, p.correo, p.activo, "
            + "pa.edad, pa.direccion, pa.historial_medico, pa.prepagada_id "
            + "FROM persona p "
            + "INNER JOIN paciente pa ON p.id = pa.id "
            + "WHERE p.nombre LIKE ? OR p.apellido LIKE ? OR p.documento LIKE ?"
        );
        ps.setString(1, "%" + texto + "%");
        ps.setString(2, "%" + texto + "%");
        ps.setString(3, "%" + texto + "%");
        
        rs = ps.executeQuery();
        while (rs.next()) {
            registros.add(new Paciente(
                rs.getInt("id"),
                rs.getString("nombre"), 
                rs.getString("apellido"),
                rs.getString("documento"),
                rs.getString("telefono"),
                rs.getString("correo"),
                rs.getBoolean("activo"),
                rs.getInt("edad"),
                rs.getString("direccion"),
                rs.getString("historial_medico"),
                (Integer) rs.getObject("prepagada_id")
            ));
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

 // Este insertar va a ser diferente, primero necesito que se "conecte" con la tabla "PACIENTE" porque persona va a heredar atributos a esta tabla
 // Asi que necesito que mantengan el mismo ID con el que se registra una persona y este ID se observe en la tabla PACIENTE
 // Cuando el PACIENTE tenga el mismo ID que la persona, entonces ya tendra que permitirle dejar insertar los datos del paciente y seguir manteniendo ese mismo ID cuando se registre el paciente, osea seria un tipo de return del ID
 // Tambien toca que cuando se inserte los datos completos del paciente, se guarden bien, pero que tal si un dato por ej, prepagada no existe? 
 // Lo que se haria es que no se guarden los "cambios" y vuelva a pedir todos los datos para que asi no queden pacientes con datos vacios y generen errores
 
    @Override
public boolean insertar(Paciente obj) {
        resp = false;
        Connection cn = CON.conectar();
        try {
            cn.setAutoCommit(false);
            ps = cn.prepareStatement("INSERT INTO persona (nombre, apellido, documento, telefono, "
                    + "correo, activo) VALUES (?, ?, ?, ?, ?, 1)", Statement.RETURN_GENERATED_KEYS);
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

            ps = cn.prepareStatement("INSERT INTO paciente (id, edad, direccion, historial_medico, "
                    + "prepagada_id) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, obj.getId());
            ps.setInt(2, obj.getEdad());
            ps.setString(3, obj.getDireccion());
            ps.setString(4, obj.getHistorialMedico());
            if (obj.getPrepagadaID() == null) {
                ps.setNull(5, java.sql.Types.INTEGER);
            } else {
                ps.setInt(5, obj.getPrepagadaID());
            }
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
public boolean actualizar(Paciente obj) {
    resp = false;
    Connection cn = CON.conectar();
    try {
        // Iniciamos la transacción desactivando el autocommit
        cn.setAutoCommit(false);
        
        //  Actualizar los datos en la tabla persona
        ps = cn.prepareStatement(
            "UPDATE persona SET nombre = ?, apellido = ?, documento = ?, telefono = ?, correo = ? "
                    + "WHERE id = ?"
        );
        ps.setString(1, obj.getNombre());
        ps.setString(2, obj.getApellido());
        ps.setString(3, obj.getDocumento());
        ps.setString(4, obj.getTelefono());
        ps.setString(5, obj.getCorreo());
        ps.setInt(6, obj.getId());
        
        ps.executeUpdate();
        ps.close();

        // Actualizar los datos específicos en la tabla dependiente paciente
        ps = cn.prepareStatement(
            "UPDATE paciente SET edad = ?, direccion = ?, historial_medico = ?, prepagada_id = ? "
                    + "WHERE id = ?"
        );
        ps.setInt(1, obj.getEdad());
        ps.setString(2, obj.getDireccion());
        ps.setString(3, obj.getHistorialMedico());
        
        if (obj.getPrepagadaID() == null) {
            ps.setNull(4, java.sql.Types.INTEGER);
        } else {
            ps.setInt(4, obj.getPrepagadaID());
        }
        ps.setInt(5, obj.getId());
        
        ps.executeUpdate();
        
        // Si ambas actualizaciones se ejecutaron sin excepciones, confirmamos la transacción
        cn.commit();
        resp = true; 
        ps.close();
        
    } catch (SQLException e) {
        // Si ocurre un error, revertimos los cambios de ambas tablas de manera segura
        if (cn != null) {
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en rollback: " + ex.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
    } finally {
        ps = null;
        // Restauramos el comportamiento por defecto de la conexión antes de liberar el recurso
        if (cn != null) {
            try {
                cn.setAutoCommit(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        CON.desconectar();
    }
    return resp;
}


// Voy a crear un metodo para cambiar el estado mas facil en los otros metodos.
//Va a recibir el id del pacieente y el nuievo estado, asi ejecuta un UPDATE en persona para modificar la tabla exitosamente

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
//reutilizamos/reescribimos el codigo de arrba, pasando el estado (arriba mencionado) y solo le ponemos el ID en false
 @Override
    public boolean desactivar(int id) {
        return cambiarEstado(id, false);
    }

    //Reutilizamos el codigo de estado y le ponemos el ID en true para que se active
    @Override
    public boolean activar(int id) {
        return cambiarEstado(id, true);
    }

    //Este nos ayuda a calcular los pacientes que hay en el sistema, primero los declaramos en 0(Numero inicial)
    // Conectamos la base de dato y enviamos la consulta, asi la BD devuelve una tabla con el total
    //Finalmente con la condicion, podemos guardar la variable en totalRegistros y al final retornar ese resultado
    @Override
    public int total() {
        int totalRegistros =0;
        
       try{
           ps = CON.conectar().prepareStatement("SELECT COUNT(id) AS total FROM paciente");
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

    
    //Este metodo nos va a ayudar a verificar elementos duplicados gracias al documentos
    //primero vamos a usar un INNER JOIN (Conexion entre tablas con alias) para buscar una coincidencia con el documento
    // Si devuelve true, existe un documento registrado, si devuelve false, ese documento no esta registrado y se puede usar
    @Override
    public boolean existe(String texto) {
        
        resp=false;
        try{
            ps=CON.conectar().prepareStatement("SELECT p.id FROM persona p INNER JOIN paciente pa"
                    + " ON p.id = pa.id WHERE p.documento= ?");
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
    
    //METODO AÑADIDO PARA LA PARTE DE HISTORIALMEDICO E HISTORIAL CITAS
    
    
public Paciente obtenerPacientePorId(int id) {
    Paciente obj = null;
    String sql = "SELECT p.id, p.nombre, p.apellido, p.documento, pa.edad, pa.historial_medico " +
                 "FROM persona p " +
                 "INNER JOIN paciente pa ON p.id = pa.id " +
                 "WHERE p.id = ?";
    try {
        ps = CON.conectar().prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            obj = new Paciente();
            obj.setId(rs.getInt("id"));
            obj.setNombre(rs.getString("nombre"));
            obj.setApellido(rs.getString("apellido"));
            obj.setDocumento(rs.getString("documento"));
            obj.setEdad(rs.getInt("edad"));
            obj.setHistorialMedico(rs.getString("historial_medico"));
        }
        ps.close(); rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error por ID: " + e.getMessage());
    } finally {
        CON.desconectar();
    }
    return obj;
}
   
public Paciente obtenerPacientePorDocumento(String documento) { 

    Paciente obj = null;
    
    
    String pac = "SELECT p.id, p.nombre, p.apellido, p.documento, pa.edad, pa.historial_medico "
               + "FROM persona p "
               + "INNER JOIN paciente pa ON p.id = pa.id "
               + "WHERE p.documento = ?"; 

    try {
        ps = CON.conectar().prepareStatement(pac);
        ps.setString(1, documento); 
        rs = ps.executeQuery();
        if (rs.next()) {
            obj = new Paciente();
            obj.setId(rs.getInt("id"));
            obj.setNombre(rs.getString("nombre"));
            obj.setApellido(rs.getString("apellido"));
            obj.setDocumento(rs.getString("documento"));
            obj.setEdad(rs.getInt("edad"));
            obj.setHistorialMedico(rs.getString("historial_medico"));
        }
        ps.close();
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en DAO Expediente: " + e.getMessage());
    } finally {
        ps = null;
        rs = null;
        CON.desconectar();
    }
    return obj;
}
    
}