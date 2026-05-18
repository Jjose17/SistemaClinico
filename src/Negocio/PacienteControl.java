package Negocio; 

import datos.PacienteDAO;
import entidades.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PacienteControl {
    
    private final PacienteDAO DATOS;
    private Paciente obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; 

    public PacienteControl() {
        this.DATOS = new PacienteDAO();
        this.obj = new Paciente();
        this.registroMostrado = 0;
    }
    
    public DefaultTableModel listar(String texto) {
        List<Paciente> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Nombre", "Apellido", "Documento", "Telefono", "Correo", "Edad", "Direccion", "Historial", "Prepagada", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String estado;
        String prepagada;
        String[] registro = new String[11]; 
        this.registroMostrado = 0;

        for (Paciente item : lista) {
            
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            if (item.getPrepagadaID() == null) {
                prepagada = "";
            } else {
                prepagada = item.getPrepagadaID().toString();
            }
            
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getApellido();
            registro[3] = item.getDocumento();
            registro[4] = item.getTelefono();
            registro[5] = item.getCorreo();
            registro[6] = Integer.toString(item.getEdad());
            registro[7] = item.getDireccion();
            registro[8] = item.getHistorialMedico();
            registro[9] = prepagada;
            registro[10] = estado;
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1; // Mismo formato de incremento manual
        }
        return this.modeloTabla;
    }
    
    public String insertar(String nombre, String apellido, String documento, String telefono, String correo, int edad, String direccion, String historialMedico, Integer prepagadaID) {
        if (DATOS.existe(documento)) {
            return "El registro ya existe";
        } else {
            
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setEdad(edad);
            obj.setDireccion(direccion);
            obj.setHistorialMedico(historialMedico);
            obj.setPrepagadaID(prepagadaID);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, String nombre, String apellido, String documento, 
            String documentoAnt, String telefono, String correo, int edad, String direccion, 
            String historialMedico, Integer prepagadaID) {
        if (documento.equals(documentoAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setEdad(edad);
            obj.setDireccion(direccion);
            obj.setHistorialMedico(historialMedico);
            obj.setPrepagadaID(prepagadaID);
            
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            if (DATOS.existe(documento)) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setApellido(apellido);
                obj.setDocumento(documento);
                obj.setTelefono(telefono);
                obj.setCorreo(correo);
                obj.setEdad(edad);
                obj.setDireccion(direccion);
                obj.setHistorialMedico(historialMedico);
                obj.setPrepagadaID(prepagadaID);
                
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualizacion";
                }
            }
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrado() {
        return this.registroMostrado;
    }

    public Paciente obtenerPacientePorId(int idPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
