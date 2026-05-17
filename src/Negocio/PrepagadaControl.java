package Negocio; 

import datos.PrepagadaDAO;
import entidades.Prepagada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PrepagadaControl {

    private final PrepagadaDAO DATOS;
    private Prepagada obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; 

    public PrepagadaControl() {
        this.DATOS = new PrepagadaDAO();
        this.obj = new Prepagada();
        this.registroMostrado = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Prepagada> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Nombre", "Tipo plan", "Cobertura", "Telefono", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String estado;
        String[] registro = new String[6]; 
        this.registroMostrado = 0;

        for (Prepagada item : lista) {
            
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getTipoPlan();
            registro[3] = item.getCobertura();
            registro[4] = item.getTelefono();
            registro[5] = estado;
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1; 
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre, String tipoPlan, String cobertura, String telefono) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe";
        } else {
            obj.setNombre(nombre);
            obj.setTipoPlan(tipoPlan);
            obj.setCobertura(cobertura);
            obj.setTelefono(telefono);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, String nombre, String nombreAnt, String tipoPlan, 
            String cobertura, String telefono) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setTipoPlan(tipoPlan);
            obj.setCobertura(cobertura);
            obj.setTelefono(telefono);
            
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
                obj.setTipoPlan(tipoPlan);
                obj.setCobertura(cobertura);
                obj.setTelefono(telefono);
                
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
