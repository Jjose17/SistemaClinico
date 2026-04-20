
package entidades;

public class Persona {
    
    private int id;
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String correo;
    private boolean activo;
    
    public Persona(){
        
    }

    public Persona(int id, String nombre, String apellido, String documento, String telefono, String correo, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("ID invalido");
        }
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Ingrese un Nombre");
        } 
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
       if(apellido == null || apellido.trim().isEmpty()){
           throw new IllegalArgumentException("Ingrese un apellido");
       }
       this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
       if(documento == null || documento.trim().isEmpty()){
           throw new IllegalArgumentException("Numero de documento invalido");
       }
       this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono != null || telefono.length()>20){ //usamos el != para validar datos que puedan haber. Otra manera es que es para validar campos opcionales que puedan contener datos
            throw new IllegalArgumentException("El numero del telefono es muy largo");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo != null){ //Si el correo no es null eso significa que el usuario ingreso un valor y asi se puede asignar y hacer la validacion
            throw new IllegalArgumentException("Correo invalido");
            
            //Toca poner lo del @ con el constrains 
        }
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", telefono=" + telefono + ", correo=" + correo + ", activo=" + activo + '}';
    }
    
   //Lo paso a la rama de entidades en git
    
}
