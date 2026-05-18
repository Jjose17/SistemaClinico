package Negocio; 

import datos.MedicoDAO;
import entidades.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MedicoControl {

    private final MedicoDAO DATOS;
    private Medico obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; 

    public MedicoControl() {
        this.DATOS = new MedicoDAO();
        this.obj = new Medico();
        this.registroMostrado = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Medico> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Nombre", "Apellido", "Documento", "Telefono", "Correo", 
            "Especialidad", "Licencia", "Horario", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String estado;
        String[] registro = new String[10]; 
        this.registroMostrado = 0;

        for (Medico item : lista) {
            
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getApellido();
            registro[3] = item.getDocumento();
            registro[4] = item.getTelefono();
            registro[5] = item.getCorreo();
            registro[6] = item.getEspecialidad();
            registro[7] = item.getNumLicencia();
            registro[8] = item.getHorario();
            registro[9] = estado;
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1; 
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre, String apellido, String documento, String telefono, String correo, String especialidad, String numLicencia, String horario) {
        if (DATOS.existe(documento) || DATOS.existe(numLicencia)) {
            return "El registro ya existe";
        } else {
            
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setEspecialidad(especialidad);
            obj.setNumLicencia(numLicencia);
            obj.setHorario(horario);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, String nombre, String apellido, String documento, String documentoAnt, String telefono, String correo, String especialidad, String numLicencia, String numLicenciaAnt, String horario) {
        
        if (documento.equals(documentoAnt) && numLicencia.equals(numLicenciaAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setEspecialidad(especialidad);
            obj.setNumLicencia(numLicencia);
            obj.setHorario(horario);
            
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            // Evaluamos si alguno de los campos modificados ya le pertenece a otro médico
            boolean duplicado = false;
            if (!documento.equals(documentoAnt) && DATOS.existe(documento)) {
                duplicado = true;
            }
            if (!numLicencia.equals(numLicenciaAnt) && DATOS.existe(numLicencia)) {
                duplicado = true;
            }

            if (duplicado) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setApellido(apellido);
                obj.setDocumento(documento);
                obj.setTelefono(telefono);
                obj.setCorreo(correo);
                obj.setEspecialidad(especialidad);
                obj.setNumLicencia(numLicencia);
                obj.setHorario(horario);
                
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
}