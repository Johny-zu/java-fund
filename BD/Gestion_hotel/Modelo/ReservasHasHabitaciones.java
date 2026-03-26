package BD.Gestion_hotel.Modelo;

public class ReservasHasHabitaciones {
    private int id;
    private Reservas reserva;        // Objeto Reservas completo
    private Habitacion habitacion;   // Objeto Habitacion completo
    private double precioNocheAplicado;
    
    public ReservasHasHabitaciones(Reservas reserva, Habitacion habitacion, double precioNocheAplicado) {
        setReserva(reserva);
        setHabitacion(habitacion);
        setPrecioNocheAplicado(precioNocheAplicado);
    }
    
    public ReservasHasHabitaciones(int id, Reservas reserva, Habitacion habitacion, double precioNocheAplicado) {
        this.id = id;
        setReserva(reserva);
        setHabitacion(habitacion);
        setPrecioNocheAplicado(precioNocheAplicado);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El ID debe ser mayor que 0");
        }
    }
    
    public Reservas getReserva() {
        return reserva;
    }
    
    public void setReserva(Reservas reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula");
        }
        this.reserva = reserva;
    }
    
    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    public void setHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            throw new IllegalArgumentException("La habitación no puede ser nula");
        }
        this.habitacion = habitacion;
    }
    
    public double getPrecioNocheAplicado() {
        return precioNocheAplicado;
    }
    
    public void setPrecioNocheAplicado(double precioNocheAplicado) {
        if (precioNocheAplicado >= 0) {
            this.precioNocheAplicado = precioNocheAplicado;
        } else {
            throw new IllegalArgumentException("El precio por noche no puede ser negativo");
        }
    }
    
    // Métodos útiles
    public double calcularSubtotal() {
        if (reserva != null && reserva.getFecha_inicio() != null && reserva.getFecha_fin() != null) {
            int dias = reserva.getDiasEstancia();
            return precioNocheAplicado * dias;
        }
        return 0;
    }
}