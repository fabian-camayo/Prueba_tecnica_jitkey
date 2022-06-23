
/**
 * Estudiante
 */
public class Estudiante {

    private String nombre;
    private String sede;
    private String correo;
    private String asignatura;

    public Estudiante() {
    }

    public Estudiante(String nombre, String sede, String correo, String asignatura) {
        this.nombre = nombre;
        this.sede = sede;
        this.correo = correo;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    
}
