package Negocio;

import datos.CitaDAO;
import entidades.Cita;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CitaControl {

    private final CitaDAO DATOS;
    private Cita obj;
    private DefaultTableModel modeloTabla;
    public int registroMostrado; 

    public CitaControl() {
        this.DATOS = new CitaDAO();
        this.obj = new Cita();
        this.registroMostrado = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Cita> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "Fecha", "Hora", "Estado", "Motivo", "Paciente", "Medico"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[7]; 
        this.registroMostrado = 0;

        for (Cita item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getFecha().toString();
            registro[2] = item.getHora().toString();
            registro[3] = item.getEstado();
            registro[4] = item.getMotivo();
            registro[5] = Integer.toString(item.getPacienteID());
            registro[6] = Integer.toString(item.getMedicoID());
            
            this.modeloTabla.addRow(registro);
            this.registroMostrado = this.registroMostrado + 1; 
        }
        return this.modeloTabla;
    }

    public String insertar(Date fecha, Time hora, String estado, String motivo, int pacienteID, int medicoID) {
        if (DATOS.existeHorario(pacienteID, medicoID, fecha, hora)) {
            return "Ya existe una cita en ese horario";
        } else {
            
            obj.setFecha(fecha);
            obj.setHora(hora);
            obj.setEstado(estado);
            obj.setMotivo(motivo);
            obj.setPacienteID(pacienteID);
            obj.setMedicoID(medicoID);
            
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }

    public String actualizar(int id, Date fecha, Time hora, String estado, String motivo, int pacienteID, int medicoID) {
      
        obj.setId(id);
        obj.setFecha(fecha);
        obj.setHora(hora);
        obj.setEstado(estado);
        obj.setMotivo(motivo);
        obj.setPacienteID(pacienteID);
        obj.setMedicoID(medicoID);
        
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualizacion";
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "Cita cancelada";
        } else {
            return "No se puede cancelar la cita";
        }
    }

    public String activar(int id) {
         if (DATOS.activar(id)) {
            return "Cita Programada";
        } else {
            return "No se pudo progamar la cita";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrado() {
        return this.registroMostrado;
    }
}

