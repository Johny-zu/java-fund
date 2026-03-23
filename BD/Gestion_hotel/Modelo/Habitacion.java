package BD.Gestion_hotel.Modelo;

public class Habitacion {
    private int id_habitacion;
    private String numero;
    private TipoHabitacion tipo;
    private double precio_noche;
    private int capacidad;
    private EstadoHabitacion estado;

    public Habitacion(String numero, TipoHabitacion tipo, double precio_noche, int capacidad, EstadoHabitacion estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio_noche = precio_noche;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Habitacion(int id_habitacion, String numero, TipoHabitacion tipo, double precio_noche, int capacidad, EstadoHabitacion estado) {
        this.id_habitacion = id_habitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.precio_noche = precio_noche;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    public int getId_habitacion() {
        return id_habitacion;
    }
    
    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public TipoHabitacion getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
    
    public double getprecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche){
        if (precio_noche >= 0) {
            this.precio_noche = precio_noche;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }
    }
    
    public EstadoHabitacion getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    public String toString(){
        String s = "";
        s += "El id de la habitacion es: " + getId_habitacion();
        s += "\nEl numero de la habitación es: " + getNumero();
        s += "\nEl tipo de habitacion es: " + tipo.getValor();
        s += "\nEL precio por noche es: " + getprecio_noche();
        s += "\nLa capacidad de la habitacion es: " + getCapacidad();
        s += "\nLa habitacion actualmente se encuentra: " + estado.getValor();
        return s;
    }
}
