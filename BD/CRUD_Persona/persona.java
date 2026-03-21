package BD.CRUD_Persona;

public class persona {
    private int id, edad;
    private String nombre, email;

    // Constructor para codigo
    public Persona(String nombre, int edad, String email){
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // Constructor para recuperar el ID para la BD
    public Persona(int id, String nombre, int edad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
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
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    } 

    public String toString(){
        String s = "";
        s += "El ID de la persona es: " + getId();
        s += "\nEl Nombre de la persona es: " + getNombre();
        s += "\nLa edad de la persona es: " + getEdad();
        s += "\nEl email de la persona es: " + getEmail();
        return s;
    }
}
