package Ejercicios.Videojuegos;

public class Juego {
    private String titulo;
    private int horasJugadas;
    private boolean completado;
    
    public Juego(String titulo, int horasJugadas, boolean completado){
        this.titulo = titulo;
        this.horasJugadas = horasJugadas;
        this.completado = completado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int gethorasJugadas() {
        return horasJugadas;
    }

    public void setHorasJugadas(int horasJugadas) {
        if (horasJugadas <= 0) 
            this.horasJugadas = 1;
        else 
            this.horasJugadas = horasJugadas;
    }
    public boolean getCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public String toString(){
        String s = "";
        s += "El nombre del juego es: " + getTitulo();
        s += "\nLa cantidad de tiempo jugado es: " + gethorasJugadas();
        if (getCompletado())
            s += "\nEl Juego fue finalizado";
        else
            s += "\nEl Juego no se ha completado";
        return s;
    }

    public String recomendarJuego(){
        if (gethorasJugadas() > 50) 
            return "Juego completo, vale la pena";
        else if (gethorasJugadas() >= 20 && gethorasJugadas() <= 50)
            return "Juego de duracion media";
        else if(gethorasJugadas() > 0 && gethorasJugadas() < 20)
            return "Juego corto, ideal para un fin de semana";
        else 
            return "El juego no cumple con los criterios";
    }

    public void cambiarEstadoCompletado(){
    setCompletado(!getCompletado()); 
        if (getCompletado()) {
            System.out.println("Juego marcado como completado");
        } else {
            System.out.println("Juego marcado como pendiente");
        }
    }
}
