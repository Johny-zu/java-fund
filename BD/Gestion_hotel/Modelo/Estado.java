package BD.Gestion_hotel.Modelo;

public enum Estado {
    CONFIRMADA("confirmada"),
    CHEK_IN("check_in"),
    CHEK_OUT("check_out"),
    CANCELADA("cancelada");

    private final String valor;

    Estado(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    public static Estado fromString(String texto){
        for(Estado ValorEstado : Estado.values()){
            if (ValorEstado.valor.equalsIgnoreCase(texto)) {
                return ValorEstado;
            }
        }
        throw new IllegalArgumentException("Estado de reservacion invalido" + texto);
    }

    @Override
    public String toString(){
        return valor;
    }
}