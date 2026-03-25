package BD.Gestion_hotel.Modelo;
import java.time.LocalDate;

public class Reservas {
    private int id_reserva;
    private LocalDate fecha_inicio, fecha_fin, fecha_reserva;
    private Estado estado;
    private double total;

    public Reservas(LocalDate fecha_inicio, LocalDate fecha_fin, LocalDate fecha_reserva, Estado estado, double total){
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_reserva = fecha_reserva;
        this.estado = estado;
        this.total = total;
    }

    public Reservas(int id_reserva, LocalDate fecha_inicio, LocalDate fecha_fin, LocalDate fecha_reserva, Estado estado, double total){
        this.id_reserva = id_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.fecha_reserva = fecha_reserva;
        this.estado = estado;
        this.total = total;
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

    public LocalDate getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDate fecha_reserva) {
        if (fecha_reserva == null) {
            throw new IllegalArgumentException("La fecha de reserva no puede ser nula");
        }
        if (fecha_reserva.isAfter(LocalDate.now())) {
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
