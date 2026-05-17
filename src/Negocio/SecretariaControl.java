package negocio; // Unificado a minúsculas como en CategoriaControl

import datos.SecretariaDAO;
import entidades.Secretaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SecretariaControl {

    private final SecretariaDAO DATOS;
    private Secretaria obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; // Cambiado de registrosMostrados a registroMostrado

    public SecretariaControl() {
        this.DATOS = new SecretariaDAO();
        this.obj = new Secretaria();
        this.registroMostrado = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Secretaria> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Nombre", "Apellido", "Documento", "Telefono", "Correo", "Turno", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String estado;
        String[] registro = new String[8];
        this.registroMostrado = 0;

        for (Secretaria item : lista) {
            
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
            registro[6] = item.getTurno();
            registro[7] = estado;
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1; 
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre, String apellido, String documento, String telefono, String correo, String turno) {
        if (DATOS.existe(documento)) {
            return "El registro ya existe";
        } else {
            
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setTurno(turno);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, String nombre, String apellido, String documento, String documentoAnt, String telefono, String correo, String turno) {
        if (documento.equals(documentoAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setApellido(apellido);
            obj.setDocumento(documento);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setTurno(turno);
            
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
                obj.setTurno(turno);
                
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
