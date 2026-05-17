package Negocio; 

import datos.RolDAO;
import entidades.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RolControl {

    private final RolDAO DATOS;
    private Rol obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado;

    public RolControl() {
        this.DATOS = new RolDAO();
        this.obj = new Rol();
        this.registroMostrado = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Rol> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Nombre", "Descripcion"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[3]; 
        this.registroMostrado = 0;

        for (Rol item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1;
        }
        return this.modeloTabla;
    }

    public List<Rol> seleccionar() {
        return DATOS.seleccionar();
    }

    public String insertar(String nombre, String descripcion) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe";
        } else {
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, String nombre, String nombreAnt, String descripcion) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualizacion";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setDescripcion(descripcion);
                
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualizacion";
                }
            }
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrado() {
        return this.registroMostrado;
    }
}
