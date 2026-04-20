
package entidades;


public class Prepagada {
    
    private int id;
    private String nombre;
    private String tipoPlan;
    private String cobertura;
    private String telefono;
    private boolean activo;
    
    public Prepagada(){
        
    }
    
    public Prepagada(int id, String nombre, String tipoPlan, String cobertura, String telefono,
            boolean activo){
        
        this.activo=activo;
        this.cobertura=cobertura;
        this.id= id;
        this.nombre =nombre;
        this.telefono=telefono;
        this.tipoPlan=tipoPlan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
}
