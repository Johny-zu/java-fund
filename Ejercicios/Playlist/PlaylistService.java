package Ejercicios.Playlist;
import java.util.ArrayList;

public class PlaylistService {
    public boolean estaVacia(ArrayList<Cancion> playlist){
        return playlist.isEmpty();
    }

    public void agregarCancion(ArrayList<Cancion> playlist, Cancion nuevaCancion){
        playlist.add(nuevaCancion);
        System.out.println("Nueva cancion agregada: " + nuevaCancion.getTitulo());
    }
    
    public boolean eliminarCancion(ArrayList<Cancion> playlist, int indice){
        if(indice >= 0 && indice <playlist.size()){
            Cancion eliminada = playlist.remove(indice);
            System.out.println("La canción: " + eliminada.getTitulo() + " fue eliminada con exito");
            return true;
        } else {
            System.out.println("Indice no hallado");
            return false;
        }
    }

    public ArrayList<Cancion> buscarArtista(ArrayList<Cancion> playlist, String artista){
        ArrayList<Cancion> resultado = new ArrayList<>();
        for (Cancion cancion : playlist) {
            if(cancion.getArtista().equalsIgnoreCase(artista)){
                resultado.add(cancion);
            }
        }
        return resultado;
    }

    public boolean marcarFavorita(ArrayList<Cancion> playlist, String titulo, String artista){
        for (Cancion cancion : playlist) {
            if (cancion.esMismaCancion(titulo, artista)) {
                cancion.setFavoritos(true);
                System.out.println("Ahora esta en favoritos la cancion: " + titulo);
                return true;
            }
        }
        System.out.println("Cancion no encontrada");
        return false;
    }

    public int duracionTotal(ArrayList<Cancion> playlist){
        int total = 0;
        for (Cancion cancion : playlist) {
            total += cancion.getDuracion();
        }
        return total;
    }

    public ArrayList<Cancion> obtenerFavoritas(ArrayList<Cancion> playlist){
        ArrayList<Cancion> favoritas = new ArrayList<>();
        for (Cancion cancion : playlist) {
            if(cancion.isFavoritos()){
                favoritas.add(cancion);
            }
        }
        return favoritas;
    }
}
