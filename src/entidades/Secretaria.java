
package entidades;

public class Secretaria extends Persona{
    
    private String turno;
    
    public Secretaria(){
        
    }
    
    public Secretaria(int id, String nombre, String apellido, String documento, String telefono,
            String correo, boolean activo, String turno){
        super(id, nombre, apellido, telefono, documento, correo, activo);
        
        this.turno=turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Secretaria{" + "turno=" + turno + '}';
    }
    
}
