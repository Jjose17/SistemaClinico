
package Negocio;

import datos.PersonaDAO;
import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;


public class PersonaControl {
    
    private final PersonaDAO DATOS;
    private Persona obj;
    private DefaultTableModel modeloTabla;
    public int registrosrMostrados;

    public PersonaControl(PersonaDAO DATOS, Persona obj, int registrosrMostrados) {
        this.DATOS = DATOS;
        this.obj = new Persona();
        this.registrosrMostrados = registrosrMostrados;
    }

    
    public DefaultTableModel listar(String texto){
        List<Persona> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        String [] titulos = {"id", "Nombre", "Apellido", "Documento", "telefono", "Correo", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        this.registrosrMostrados = 0;
        
        String estado;
        
        for(Persona item: lista){
            estado = item.isActivo() ? "Activo":"Inactivo";
            String[] registro = new String [7];
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getApellido();
            registro[3] = item.getDocumento();
            registro[4] = item.getTelefono();
            registro[5] = item.getCorreo();
            registro[6] = estado;
            
            this.modeloTabla.addRow(registro);
            this.registrosrMostrados++;
        }
        return this.modeloTabla;
        
    }
    
    public String insertar(String nombre, String apellido, String documento, String telefono, String correo){
        
        if(DATOS.existe(documento)){
            return "❌ El registro de esta persona ya existe.";
        }else{
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            if(DATOS.insertar(obj)){
                return "Registro completado";
            }else{
                return "Error en el registro. Intente de nuevo";
            }
            
        }
    }
    
    public String actualizar(int id, String nombre, String apellido, String documento, String documentoAnt, String telefono, String correo){
        if(documento.equals(documentoAnt)){
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            
            if(DATOS.actualizar(obj)){
                return "Actualizacion completada";
            }else{
                return "Error en la actualizacion de registro";
            }
        }else{
            if(DATOS.existe(documento)){
            return "La cedula ya esta registrada";
        }else{
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualizacion";
            }
            }
        }
        
    }
    
    public String desactivar(int id){
        if(DATOS.desactivar(id)){
            return "Desactivado";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if(DATOS.activar(id)){
            return "Activado";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrado(){
        return this.registrosrMostrados;
    }
}
