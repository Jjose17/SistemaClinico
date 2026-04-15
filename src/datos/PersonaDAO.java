
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
        CON= Conexion.getInstancia();
    }
    
    @Override
    public List<Persona> listar(String texto) {
        List<Persona> registros = new ArrayList();
        try{
            ps=CON.conectar().prepareStatement("SELECT * FROM Persona WHERE nombre LIKE?");
        ps.setString(1, "%"+ texto + "%");
        rs=ps.executeQuery();
        while(rs.next()){
            registros.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return registros;
    }

    @Override
    public boolean insertar(Persona obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Persona obj) {
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
