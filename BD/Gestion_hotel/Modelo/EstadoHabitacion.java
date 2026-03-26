package BD.Gestion_hotel.Modelo;

public enum EstadoHabitacion {
    DISPONIBLE("disponible"),
    MANTENIMIENTO("mantenimiento");
    
    private final String valor;
    
    EstadoHabitacion(String valor) {
        this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
    
    public static EstadoHabitacion fromString(String texto) {
        for (EstadoHabitacion estado : EstadoHabitacion.values()) {
            if (estado.valor.equalsIgnoreCase(texto)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Estado de habitación inválido: " + texto);
    }
    
    @Override
    public String toString() {
        return valor;
    }
}