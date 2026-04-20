
package entidades;

import java.util.Date;

public class Cita {
    
    private int id;
    //private ¿? fecha;
    //private ¿? hora;
    private String estado;
    private String motivo;
    private int pacienteID;
    private int medicoID;
    
    public Cita(){
        
    }
    
    public Cita(int id, String estado, String motivo, int pacienteID, int medicoID){
        
        this.estado=estado;
        this.id=id;
        this.medicoID = medicoID;
        this.motivo= motivo;
        this.pacienteID =pacienteID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public int getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(int medicoID) {
        this.medicoID = medicoID;
    }
    
    
}
