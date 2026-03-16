package Ejercicios.Videojuegos;
import java.util.Scanner;

public class GestionVid {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1.- Agregar videojuego" + 
                    "\n2.- Marcar juego como completado (buscar por título)" + 
                    "\n3.- Mostrar todos los juegos" + 
                    "\n4.- Mostrar solo juegos completados" + 
                    "\n5.- Mostrar solo juegos pendientes" + 
                    "\n6.- Salir";
        String titulo;
        int horasJugadas, opcion, tamañoscoleccion;
        boolean completado = false;
        
        System.out.printf("Ingrese el tamaño de la coleccion: ");
        tamañoscoleccion = sc.nextInt();

        Juego[] coleccionJuego = new Juego[tamañoscoleccion];
        do{
            System.out.printf(menu + "\nIngrese una opcion del menu: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (coleccionLlena(coleccionJuego)) {
                        System.out.println("La coleccion ya esta llena");
                    } else {
                        for(int i = 0; i < coleccionJuego.length; i++){
                            if(coleccionJuego[i] == null){
                                System.out.printf("Ingrese el nombre del juego: ");
                                sc.nextLine();
                                titulo = sc.nextLine();
                                System.out.printf("Ingrese las horas jugadas: ");
                                horasJugadas = sc.nextInt();
                                System.out.printf("¿Ha terminado el juego? Si/No ");
                                String validacion;
                                sc.nextLine();
                                validacion = sc.nextLine();
                                
                                if(validacion.equalsIgnoreCase("si"))
                                    completado = true;
                                else if(validacion.equalsIgnoreCase("no"))
                                    completado = false;
                                else{
                                    System.out.println("Opcion invalida, se asume que no fue acabado");
                                    completado = false;
                                }
                                
                                coleccionJuego[i] = new Juego(titulo, horasJugadas, completado);
                                break;
                            }
                        }
                    }
                    break;
                case 2: if (coleccionVacia(coleccionJuego)) {
                    System.out.println("No hay juegos para buscar");
                } else{
                    System.out.printf("Ingresa el juego terminado: ");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    if(enColeccion(coleccionJuego, titulo)) {  
                        for(int i = 0; i < coleccionJuego.length; i++){
                            if(coleccionJuego[i] != null && coleccionJuego[i].getTitulo().equalsIgnoreCase(titulo)){
                                if(!coleccionJuego[i].getCompletado()) {  // Valida que no esté completado
                                    coleccionJuego[i].setCompletado(true);
                                    System.out.println("Juego marcado como completado");
                                } else {
                                    System.out.println("El juego ya estaba completado");
                                }
                                break;
                            }
                        }
                    }
                }
                    break;
                case 3: if (coleccionVacia(coleccionJuego)) {
                    System.out.println("No hay juegos para mostrar");
                } else{
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if (coleccionJuego[i] != null) 
                            System.out.println(coleccionJuego[i].getTitulo());
                    }
                }
                    break;
                case 4 : if(coleccionVacia(coleccionJuego)){
                    System.out.println("no hay juegos para mostrar");
                } else {
                    boolean hayCompletados = false;
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            if(coleccionJuego[i].getCompletado()){
                                System.out.println("El juego: " + coleccionJuego[i].getTitulo() + " Ha sido concluido");
                                hayCompletados = true;
                            }
                        }
                    }
                    if(!hayCompletados)
                        System.out.println("No hay juegos completados");
                }
                    break; 
                case 5 : if(coleccionVacia(coleccionJuego)){
                    System.out.println("no hay juegos para mostrar");
                } else {
                    boolean hayCompletados = false;
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            if(!coleccionJuego[i].getCompletado()){
                                System.out.println("El juego: " + coleccionJuego[i].getTitulo() + " No ha sido concluido");
                                hayCompletados = true;
                            }
                        }
                    }
                    if(!hayCompletados)
                        System.out.println("No hay juegos sin completar");
                }
                    break; 
                case 6 : System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opcion no encontrada");
                    break;
            }
        } while(opcion != 6);
        sc.close();
    }
}
