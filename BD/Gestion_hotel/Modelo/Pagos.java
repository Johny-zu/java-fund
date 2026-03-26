package BD.Gestion_hotel.Modelo;
import java.time.LocalDateTime;

public class Pagos {
    private int id_pago;
    private Reservas reservas;
    private double monto;
    private LocalDateTime fecha_pago;
    private Metodo metodo;
    private String referencia;

    public Pagos(Reservas reservas, double monto, LocalDateTime fecha_pago, Metodo metodo, String referencia){
        this.reservas = reservas;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
        this.metodo = metodo;
        this.referencia = referencia;
    }

    public Pagos(int id_pago, double monto, LocalDateTime fecha_pago, Metodo metodo, String referencia){
        this.id_pago = id_pago;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
        this.metodo = metodo;
        this.referencia = referencia;
    }

    public int getId_pago(){
        return id_pago;
    }

    public void setId_pago(int id_pago){
        if (id_pago > 0) {
                this.id_pago = id_pago;
        } else{
            throw new IllegalArgumentException("El id no puede ser negativo");
        }
    }

    public Reservas getReservas(){
        return reservas;
    }

    public void setReservas(Reservas reservas){
        if (reservas == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula");
        } else{
            this.reservas = reservas;
        }
    }

    public double getMonto(){
        return monto;
    }

    public void setMonto(double monto){
        if (monto > 0) {
            this.monto = monto;
        } else{
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
    }

    public LocalDateTime getFecha_pago(){
        return fecha_pago;
    }

    public void setFecha_pago(LocalDateTime fecha_pago){
        if (fecha_pago == null) {
            throw new IllegalArgumentException("La fecha de pago no puede ser nula");
        } else if (fecha_pago.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha no se puede ser futura");
        } else {
            this.fecha_pago = fecha_pago;
        }
    }

    public Metodo getMetodo(){
        return metodo;
    }

    public void setMetodo(Metodo metodo){
        if (metodo == null) {
            throw new IllegalArgumentException("El metodo no puede ser nulo");
        }
        this.metodo = metodo;
    }

    public String getReferencia(){
        return referencia;
    }

    public void setReferencia(String refrencia){
        this.referencia = refrencia;
    }
    
    @Override
    public String toString() {
        Reservas reserva = null;
        String s = "";
        s += "El ID del pago es: " + getId_pago();
        s += "\nLa reserva asociada es: " + (reserva != null ? reserva.getId_reserva() : "No asignada");
        s += "\nEl monto es: $" + getMonto();
        s += "\nLa fecha de pago es: " + getFecha_pago();
        s += "\nEl método de pago es: " + metodo.getValor();
        s += "\nLa referencia es: " + getReferencia();
        return s;
    }
}