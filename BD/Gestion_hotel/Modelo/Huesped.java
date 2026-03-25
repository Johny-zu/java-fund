package BD.Gestion_hotel.Modelo;
import java.time.LocalDate;

public class Huesped {
    private int id_huesped;
    private String nombre, email, telefono, documento;
    private LocalDate fecha_registro;

    public Huesped(String nombre, String email, String telefono, String documento, LocalDate fecha_registro){
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.documento = documento;
        this.fecha_registro = fecha_registro;
    }

    public Huesped(int id_huesped, String nombre, String email, String telefono, String documento, LocalDate fecha_registro){
        this.id_huesped = id_huesped;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.documento = documento;
        this.fecha_registro = fecha_registro;
    }

        public int getId_huesped() {
        return id_huesped;
    }
    
    public void setId_huesped(int id_huesped) {
        if (id_huesped > 0) {
            this.id_huesped = id_huesped;
        } else {
            throw new IllegalArgumentException("El ID del huésped debe ser mayor que 0");
        }
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty() && email.contains("@")) {
            this.email = email.trim().toLowerCase();
        } else {
            throw new IllegalArgumentException("El email debe ser válido y contener '@'");
        }
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono.trim();
        } else {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        if (documento != null && !documento.trim().isEmpty()) {
            this.documento = documento.trim().toUpperCase();
        } else {
            throw new IllegalArgumentException("El documento no puede estar vacío");
        }
    }
    
    public LocalDate getFecha_registro() {
        return fecha_registro;
    }
    
    public void setFecha_registro(LocalDate fecha_registro) {
        if (fecha_registro != null) {
            this.fecha_registro = fecha_registro;
        } else {
            throw new IllegalArgumentException("La fecha de registro no puede ser nula");
        }
    }
    
    @Override
    public String toString() {
        String s = "";
        s += "El ID del huesped es: " + getId_huesped();
        s += "\nEl nombre del huesped es: " + getNombre();
        s += "\nEl email del cliente es: " + getEmail();
        s += "\nEl telefono del cliente es: " + getTelefono();
        s += "\nEl documento del huesped es: " + getDocumento();
        s += "\nLa fecha de registro del huesped es: " + getFecha_registro();
        return s;
    }

    //Funciones de validacion con expresiones regulares
    public boolean isEmailValido() {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public boolean isTelefonoValido() {
        return telefono != null && telefono.matches("^[0-9]{8,15}$");
    }
    
    public boolean isDocumentoValido() {
        return documento != null && documento.matches("^[A-Z0-9]{6,20}$");
    }
}
