package Ejercicios.Videojuegos;

public class FuncionesVid {
    public static boolean coleccionVacia(Juego[] coleccionJuego){
        for(Juego juego : coleccionJuego) { 
            if(juego != null) return false;
        }
        return true;
    }

    public static boolean coleccionLlena(Juego[] coleccionJuego){
        for(Juego juego : coleccionJuego) {
            if(juego == null) return false;
        }
        return true;
    }

    public static boolean enColeccion(Juego[] coleccionJuegos, String buscarTitulo){
        for(int i = 0; i < coleccionJuegos.length; i++){
            if(coleccionJuegos[i] != null && coleccionJuegos[i].getTitulo().equalsIgnoreCase(buscarTitulo)){
                System.out.println("El titulo: " + buscarTitulo + " existe");
                return true;
            }
        }
        System.out.println("El titulo: " + buscarTitulo + " no existe");
        return false;
    }

    public static int contadorHoras(Juego[] coleccionJuegos){
        int contador = 0;
        for(int i = 0; i < coleccionJuegos.length; i++){
            if (coleccionJuegos[i] != null) 
                contador += coleccionJuegos[i].gethorasJugadas();
        } 
        return contador;
    }
}
