
package entidades;


import java.sql.Date; //Es para poder tener la fecha de la cita medica
import java.sql.Time; // Es para tener la hora de la cita medica

public class Cita {
    
    private int id;
    private Date fecha; 
    private Time hora;
    private String estado;
    private String motivo;
    private int pacienteID;
    private int medicoID;
    
    public Cita(){
        
    }
    
    public Cita(int id, Date fecha, Time hora, String estado, String motivo, int pacienteID, int medicoID){
        
        this.estado=estado;
        this.id=id;
        this.medicoID = medicoID;
        this.motivo= motivo;
        this.pacienteID =pacienteID;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
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

    @Override
    public String toString() {
        return "Cita{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", motivo=" + motivo + ", pacienteID=" + pacienteID + ", medicoID=" + medicoID + '}';
    }
    
    
}

   
