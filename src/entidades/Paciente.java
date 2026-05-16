package entidades;

public class Paciente extends Persona {

    private int edad;
    private String direccion;
    private String historialMedico;
    private Integer prepagadaID;

    public Paciente() {
    }

    public Paciente(int id, String nombre, String apellido, String documento, String telefono, String correo,
            boolean activo, int edad, String direccion, String historialMedico, Integer prepagadaID) {
        
        super(id, nombre, apellido, documento, telefono, correo, activo);
        this.edad = edad;
        this.direccion = direccion;
        this.historialMedico = historialMedico;
        this.prepagadaID = prepagadaID;
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
        return "Paciente{" + "id=" + getId() + 
                ", nombre=" + getNombre() + 
                ", apellido=" + getApellido()
                + ", documento=" + getDocumento() + 
                ", telefono=" + getTelefono() + 
                ", correo=" + getCorreo()
                + ", activo=" + isActivo() + 
                ", edad=" + edad + 
                ", direccion=" + direccion
                + ", historialMedico=" + historialMedico + 
                ", prepagadaID=" + prepagadaID + '}';
    }
}

