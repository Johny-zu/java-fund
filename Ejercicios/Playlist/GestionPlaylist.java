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
            System.out.printf(menu + "\n Escoje una opcion: ");
            //Validacon de ingreso de numeros como opcion
            if (sc.hasNext()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.printf("Favor de ingresar un numero");
                sc.nextLine();
                opcion = 0;
                continue;
            }
            switch (opcion) {
                case 1: 
                System.out.print("Ingresa el título de la canción: ");
                String titulo = sc.nextLine();
                
                System.out.print("Ingresa al Artista: ");
                String artista = sc.nextLine();
                
                System.out.print("Ingresa la duración (en segundos): ");
                int duracion = sc.nextInt();
                sc.nextLine();
                
                System.out.print("¿Esta en favoritos? (s/n): ");
                String fav = sc.nextLine();
                boolean favorita = fav.equalsIgnoreCase("s");
                
                Cancion nueva = new Cancion(titulo, artista, duracion, favorita);
                service.agregarCancion(playlist, nueva);
                    break;
                case 2: if (service.estaVacia(playlist)) {
                    System.out.println("No hay canciones para mostrar");
                } else{
                    System.out.printf("lista de canciones: \n");
                    int contador = 1;
                    for (Cancion cancion : playlist) {
                        System.out.println(contador + ": " + cancion.getTitulo());
                        contador++;
                    }
                    System.out.printf("Ingrese la canciona a eliminar: ");
                    int pos = sc.nextInt() - 1;
                    service.eliminarCancion(playlist, pos);
                }
                    break;
                case 3: if (service.estaVacia(playlist)) {
                    System.out.println("No hay canciones por mostrar");
                } else{
                    for(int i = 0; i < playlist.size(); i++){
                        System.out.println((i+1) + ".- " + playlist.get(i));
                    }
                }
                    break;
                case 4: if (service.estaVacia(playlist)) {
                    System.out.println("No hay canciones por mostrar");
                } else {
                    System.out.println("Ingresa la nueva favorita: ");
                    String tituloFav = sc.nextLine();
                    System.out.println("Artista de la cancion: ");
                    String artistaFavorito = sc.nextLine();
                    service.marcarFavorita(playlist, tituloFav, artistaFavorito);
                }
                    break;
                case 5: if (service.estaVacia(playlist)) {
                    System.out.println("No hay canciones para mostrar");
                } else{
                    ArrayList<Cancion> favoritas = service.obtenerFavoritas(playlist);
                    if (favoritas.isEmpty()) {
                        System.out.println("Aun no hay canciones en favoritas");
                    } else {
                        System.out.println("Las favoritas son: \n");
                        for(int i = 0; i < favoritas.size(); i++){
                            System.out.println((i+1) + ".- " + favoritas.get(i));
                        }
                    }
                }
                    break;
                case 6: if (service.estaVacia(playlist)) {
                    System.out.println("No hay canciones para mostrar");
                } else {
                    System.out.println("Ingresa el artista a buscar: ");
                    String artistaBuscar = sc.nextLine();
                    ArrayList<Cancion> resultados = service.buscarArtista(playlist, artistaBuscar);
                    if (resultados.isEmpty()) {
                        System.out.println("No se hallaron canciones del artista buscado");
                    } else {
                        System.out.println("Las canciones de " + artistaBuscar + " son: ");
                        for (Cancion cancion : resultados) {
                            System.out.println(" - " + cancion);
                        }
                    }
                }
                    break;
                case 7: if(service.estaVacia(playlist)){
                    System.out.println("No hay caciones");
                } else{
                    int totalSegudnos = service.duracionTotal(playlist);
                    int horas = totalSegudnos / 3600;
                    int minutos = (totalSegudnos % 3600) / 60;
                    int segundos = totalSegudnos % 60;

                    String info = "horas: " + horas + "\nMinutos" + minutos + "\nsegundos: "+ segundos;
                    System.out.println("Duracion total: \n" + info);
                }
                    break;
                case 8: if (service.estaVacia(playlist)) {
                    System.out.println("No hay canciones actualmente");
                } else {
                    System.out.println("total de canciones: " + playlist.size());
                }
                    break;
                case 9: System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opcion invalida");
                    break;
            }
        } while(opcion != 9);
        sc.close();
    }
}
