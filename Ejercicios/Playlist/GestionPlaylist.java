package Ejercicios.Playlist;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu ="1.- Agregar canción" +
                     "\n2.- Eliminar canción por posición" +
                     "\n3.- Mostrar toda la playlist" +
                     "\n4.- Marcar canción como favorita" +
                     "\n5.- Mostrar solo favoritas" +
                     "\n6.- Buscar canciones por artista" +
                     "\n7.- Duración total de la playlist" +
                     "\n8.- ¿Cuántas canciones tengo?" +
                     "\n9.- Salir";
        int opcion;

        ArrayList<Cancion> playlist = new ArrayList<>();
        PlaylistService service = new PlaylistService();

        do{
            System.out.println(menu + "\n Escoje una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9: System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }
        } while(opcion != 9);
        sc.close();
    }
}
