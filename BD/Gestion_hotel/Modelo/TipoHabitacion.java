package BD.Gestion_hotel.Modelo;

public enum TipoHabitacion {
    INDIVIDUAL("individual"),
    DOBLE("doble"),
    SUITE("suite");
    
    private final String valor;
    
    TipoHabitacion(String valor) {
        this.valor = valor;
    }
    
    public String getValor() {
        return valor;
    }
    
    // Método para convertir String a Enum
    public static TipoHabitacion fromString(String texto) {
        for (TipoHabitacion tipo : TipoHabitacion.values()) {
            if (tipo.valor.equalsIgnoreCase(texto)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de habitación inválido: " + texto);
    }
    
    @Override
    public String toString() {
        return valor;
    }
}