package Ejercicios.Playlist;
import java.util.ArrayList;

public class PlaylistService {
    public void agregarCancion(ArrayList<Cancion> playlist, Cancion nuevaCancion){
        playlist.add(nuevaCancion);
        System.out.println("Nueva cancion agregada: " + nuevaCancion.getTitulo());
    }
}
