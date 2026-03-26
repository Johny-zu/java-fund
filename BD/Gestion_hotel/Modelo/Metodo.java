package BD.Gestion_hotel.Modelo;

public enum Metodo {
    EFECTIVO("efectivo"),
    TARJETA("tarjeta"),
    TRANSFERENCIA("transferencia");

    private final String valor;

    Metodo(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    public static Metodo fromString(String texto){
        for(Metodo valorMetodo : Metodo.values()){
            if (valorMetodo.valor.equalsIgnoreCase(texto)) {
                return valorMetodo;
            }
        }
        throw new IllegalArgumentException("Metodo de pago no reconocido");
    }

    @Override
    public String toString(){
        return valor;
    }
}
