package personas.dto;

/**
 * clase PersonaDTO crea POJO para ser manipulados entre capas de informacion
 * Los DTO son objetos simples que no deben contener lógica de negocio que requiera pruebas generales.
 * DTO = data transfer object .
 * @param id_persona(int), nombre y apellido (String)
 * @version 1.0.0
 *
 * @author Figueras, Galarza, Gutierrez
 */
public class PersonaDTO {
    private int id_persona;
    private String nombre, apellido;
    private String curso;
    private int id_aula;
    private String id_escuela;
    private int id_curso;
    private int escuela;
    private String nombreAula;
    
    /**
     * Constructores de la clase
     * @param: primer constructor vacio
     * @param: segundo constructor con argumento : Id del tipo INT
     * 
     */
    public PersonaDTO(){}
    
    public PersonaDTO(int id_persona){
        this.id_persona = id_persona;
    }

    public PersonaDTO(int id_aula, int id_curso, int escuela) {
        this.id_aula = id_aula;
        this.id_curso = id_curso;
        this.escuela = escuela;
    }

    
    public String getNombreAula() {
        return nombreAula;
    }

    /**
     * Getters / Setters
     */
    public void setNombreAula(String nombreAula) {    
        this.nombreAula = nombreAula;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public String getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(String id_escuela) {
        this.id_escuela = id_escuela;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getEscuela() {
        return escuela;
    }

    public void setEscuela(int escuela) {
        this.escuela = escuela;
    }
    
    

    @Override
    /**
     * toString() imprimiendo contenido del objeto de ser necesario...
     */
    public String toString() {
        return "Nombre= " + nombre + " Apellido= " + apellido + " Curso=" + curso + " Aula= " + nombreAula+ " Escuela= " + id_escuela;
    }
        
    
}
