
package entidades;


public class Medico extends Persona{
    
    private String especialidad;
    private String numLicencia;
    private String horario;
    
    public Medico(){
        
    }
    public Medico(int id, String nombre, String apellido, String documento, String telefono, String correo,
            boolean activo, String especialidad, String numLicencia, String horario){
        super(id, nombre, apellido,documento, telefono, correo, activo);
        this.especialidad = especialidad;
        this.horario = horario;
        this.numLicencia=numLicencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Medico{" + "especialidad=" + especialidad + ", numLicencia=" + numLicencia + ", horario=" + horario + '}';
    }
    
    
    
}
