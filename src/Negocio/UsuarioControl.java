package Negocio;

import datos.UsuarioDAO;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private Usuario obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; 

    public UsuarioControl() {
        this.DATOS = new UsuarioDAO();
        this.obj = new Usuario();
        this.registroMostrado = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Usuario> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Rol", "Nombre", "Tipo documento", "Documento", "Direccion", "Telefono", "Correo", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String estado;
        String[] registro = new String[9]; 
        this.registroMostrado = 0;

        for (Usuario item : lista) {
            
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getRolNombre();
            registro[2] = item.getNombre();
            registro[3] = item.getTipoDocumento();
            registro[4] = item.getNumDocumento();
            registro[5] = item.getDireccion();
            registro[6] = item.getTelefono();
            registro[7] = item.getCorreo();
            registro[8] = estado;
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1; 
        }
        return this.modeloTabla;
    }

    public String insertar(int rolId, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String correo, String clave) {
        if (DATOS.existe(correo) || DATOS.existe(numDocumento)) {
            return "El registro ya existe";
        } else {
            
            obj.setRolId(rolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setClave(clave);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, int rolId, String nombre, String tipoDocumento, 
            String numDocumento, String numDocumentoAnt, String direccion, String telefono, String correo, String correoAnt, String clave) {
        
        if (numDocumento.equals(numDocumentoAnt) && correo.equals(correoAnt)) {
            obj.setId(id);
            obj.setRolId(rolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setClave(clave);
            
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            boolean duplicado = false;
            if (!numDocumento.equals(numDocumentoAnt) && DATOS.existe(numDocumento)) {
                duplicado = true;
            }
            if (!correo.equals(correoAnt) && DATOS.existe(correo)) {
                duplicado = true;
            }

            if (duplicado) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setRolId(rolId);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setDireccion(direccion);
                obj.setTelefono(telefono);
                obj.setCorreo(correo);
                obj.setClave(clave);
                
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

