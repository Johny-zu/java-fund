package BD.Gestion_hotel.Modelo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservas {
    private Huesped huesped;
    private int id_reserva;
    private LocalDate fecha_inicio, fecha_fin;
    private LocalDateTime fecha_reserva;
    private Estado estado;
    private double total;
    private List<ReservasHasHabitaciones> habitaciones; 

    public Reservas(LocalDate fecha_inicio, LocalDate fecha_fin, LocalDateTime fecha_reserva, Estado estado, double total){
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_reserva = fecha_reserva;
        this.estado = estado;
        this.total = total;
        this.habitaciones = new ArrayList<>();
    }

    public Reservas(int id_reserva, LocalDate fecha_inicio, LocalDate fecha_fin, LocalDateTime fecha_reserva, Estado estado, double total){
        this.id_reserva = id_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_reserva = fecha_reserva;
        this.estado = estado;
        this.total = total;
        this.habitaciones = new ArrayList<>();
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        if (id_reserva > 0) {
            this.id_reserva = id_reserva;
        } else {
            throw new IllegalArgumentException("El ID de reserva debe ser mayor que 0");
        }
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        if (huesped == null) {
            throw new IllegalArgumentException("El huésped no puede ser nulo");
        }
        this.huesped = huesped;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        if (fecha_inicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula");
        }
        if (fecha_fin != null && fecha_inicio.isAfter(fecha_fin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        if (fecha_fin == null) {
            throw new IllegalArgumentException("La fecha de fin no puede ser nula");
        }
        if (fecha_inicio != null && fecha_fin.isBefore(fecha_inicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }
        this.fecha_fin = fecha_fin;
    }

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        if (fecha_reserva == null) {
            throw new IllegalArgumentException("La fecha de reserva no puede ser nula");
        }
        if (fecha_reserva.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de reserva no puede ser futura");
        }
        this.fecha_reserva = fecha_reserva;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo");
        }
        this.total = total;
    }

    public List<ReservasHasHabitaciones> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<ReservasHasHabitaciones> habitaciones) {
        this.habitaciones = habitaciones != null ? habitaciones : new ArrayList<>();
    }

    public void agregarHabitacion(ReservasHasHabitaciones habitacion) {
        if (habitacion != null) {
            this.habitaciones.add(habitacion);
        }
    }

    public String toString(){
        String s = "";
        s += "El ID de la reserva es: " + getId_reserva();
        s += "\nEl huesped es: " + (huesped != null ? huesped.getNombre() : "No asignado");
        s += "\nLa fecha de inicio es: " + getFecha_inicio();
        s += "\nLa fecha de fin es: " + getFecha_fin();
        s += "\nLa fecha de reserva es: " + getFecha_reserva();
        s += "\nEl estado de la reserva es: " + estado.getValor();
        s += "\nEl total de la reserva es: " + getTotal();
        s += "\nNumero de habitaciones reservadas: " + (habitaciones != null ? habitaciones.size() : 0);
        return s;
    }

    // Validaciones posibles a usar
    public int getDiasEstancia() {
        if (fecha_inicio != null && fecha_fin != null) {
            return (int) (fecha_fin.toEpochDay() - fecha_inicio.toEpochDay());
        }
        return 0;
    }

    public boolean isReservaActiva() {
        return estado == Estado.CONFIRMADA && 
               fecha_inicio != null && 
               fecha_fin != null && 
               !fecha_fin.isBefore(LocalDate.now());
    }

    public boolean isReservaVencida() {
        return fecha_fin != null && fecha_fin.isBefore(LocalDate.now());
    }
}
