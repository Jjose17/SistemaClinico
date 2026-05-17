package entidades;

public class Paciente extends Persona{
    
    private int edad;
    private String direccion;
    private String historialMedico;
    private Integer prepagadaID; //Con esto podremos conectar la prepagada con el paciente que la tenga 

    public Paciente() {
    }
    
    
    
    public Paciente(int aInt, String string, String string1, String string2, String string3, String string4, boolean aBoolean, int aInt1, String string5, String string6, Integer par){
        
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public Integer getPrepagadaID() {
        return prepagadaID;
    }

    public void setPrepagadaID(Integer prepagadaID) {
        this.prepagadaID = prepagadaID;
    }

    @Override
    public String toString() {
        return "Paciente: " + getNombre() + "edad=" + getEdad() + ", direccion=" + direccion + ", historialMedico=" + historialMedico + ", prepagadaID=" + prepagadaID + '}';
    }


 
    
    
    
}