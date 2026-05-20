package Negocio;

import datos.UsuarioDAO;
import entidades.Usuario;
import datos.PersonaDAO;
import java.util.ArrayList;
import entidades.Persona;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private final PersonaDAO DATOS_PERSONA; // 3. Añadimos el DAO de personas para las consultas generales
    private Usuario obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; 

    public UsuarioControl() {
        this.DATOS = new UsuarioDAO();
        this.DATOS_PERSONA = new PersonaDAO(); // 4. Inicializamos el DAO de personas
        this.obj = new Usuario();
        this.registroMostrado = 0;
    }

    // Adaptamos el método para recibir el filtro de rol desde la interfaz y consultar la tabla correcta
    public DefaultTableModel listar(String texto, String rolFiltrado) {
    
    String[] titulos = {"ID", "Rol", "Nombre", "Tipo documento", "Documento", "Direccion", "Telefono", "Correo", "Estado"};
    
    this.modeloTabla = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };
    
    String estado;
    String[] registro = new String[9]; 
    this.registroMostrado = 0;

    // 1. SI SELECCIONA "TODOS", "MEDICO" O "PACIENTE": Agregamos lo que viene de la tabla Persona
    if (rolFiltrado.equalsIgnoreCase("Todos") || rolFiltrado.equalsIgnoreCase("Medico") || rolFiltrado.equalsIgnoreCase("Paciente")) {
        List<Persona> listaPersonas = DATOS_PERSONA.listar(texto);
        
        for (Persona item : listaPersonas) {
            String rolPersona = (item.getRol() != null) ? item.getRol().getNombre().trim() : "Paciente";
            
            // Si es "Todos", dejamos pasar a Médicos y Pacientes (las secretarias se añaden en el siguiente bloque para no duplicar)
            if (rolFiltrado.equalsIgnoreCase("Todos") && (rolPersona.equalsIgnoreCase("Secretaria") || rolPersona.equalsIgnoreCase("Administrador"))) {
                continue; 
            }
            
            if (rolFiltrado.equalsIgnoreCase("Todos") || rolPersona.equalsIgnoreCase(rolFiltrado)) {
                estado = item.isActivo() ? "Activo" : "Inactivo";
                
                registro[0] = Integer.toString(item.getId());
                registro[1] = rolPersona; 
                registro[2] = item.getNombre() + " " + item.getApellido(); 
                registro[3] = "CC"; 
                registro[4] = item.getDocumento();
                registro[5] = "N/A"; 
                registro[6] = item.getTelefono();
                registro[7] = item.getCorreo();
                registro[8] = estado;
                
                this.modeloTabla.addRow(registro);
                this.registroMostrado++;
            }
        }
    }
    
    // 2. SI SELECCIONA "TODOS" o "SECRETARIA": Agregamos lo que viene de la tabla Usuario
    if (rolFiltrado.equalsIgnoreCase("Todos") || rolFiltrado.equalsIgnoreCase("Secretaria")) {
        List<Usuario> listaUsuarios = DATOS.listar(texto);
        
        for (Usuario item : listaUsuarios) {
            String rolUsuario = (item.getRolNombre() != null) ? item.getRolNombre().trim() : "Secretaria";
            
            if (rolFiltrado.equalsIgnoreCase("Todos") || rolUsuario.equalsIgnoreCase(rolFiltrado)) {
                estado = item.isActivo() ? "Activo" : "Inactivo";
                
                registro[0] = Integer.toString(item.getId());
                registro[1] = rolUsuario;
                registro[2] = item.getNombre();
                registro[3] = item.getTipoDocumento() != null ? item.getTipoDocumento() : "CC";
                registro[4] = item.getNumDocumento();
                registro[5] = item.getDireccion() != null ? item.getDireccion() : "N/A";
                registro[6] = item.getTelefono();
                registro[7] = item.getCorreo();
                registro[8] = estado;
                
                this.modeloTabla.addRow(registro);
                this.registroMostrado++;
            }
        }
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
