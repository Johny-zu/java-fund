package Ejercicios.Videojuegos;
import java.util.Scanner;

public class GestionVid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1.- Agregar videojuego" + 
                    "\n2.- Marcar juego como completado (buscar por título)" + 
                    "\n3.- Mostrar todos los juegos" + 
                    "\n4.- Mostrar solo juegos completados" + 
                    "\n5.- Mostrar solo juegos pendientes" +
                    "\n6.- Total de juegos en coleccion" + 
                    "\n7.- Promedio de horas jugadas" + 
                    "\n8.- Juego con mas horas" + 
                    "\n9.- Juego con menos horas" +
                    "\n10.- Porcentaje de juegos completado" +
                    "\n11.- Busqueda parcial de titulo" + 
                    "\n12.- Busqueda por rango de tiempo" + 
                    "\n13.- Recomendaciones de los no finalizados" +
                    "\n15.- Salir";
        String titulo;
        int horasJugadas, opcion, tamañoColeccion;
        boolean completado = false;
        
        System.out.printf("Ingrese el tamaño de la coleccion: ");
        tamañoColeccion = sc.nextInt();

        Juego[] coleccionJuego = new Juego[tamañoColeccion];
        do{
            System.out.printf(menu + "\nIngrese una opcion del menu: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (FuncionesVid.coleccionLlena(coleccionJuego)) {
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
                case 2: if (FuncionesVid.coleccionVacia(coleccionJuego)) {
                    System.out.println("No hay juegos para buscar");
                } else{
                    System.out.printf("Ingresa el juego terminado: ");
                    sc.nextLine();
                    titulo = sc.nextLine();
                    if(FuncionesVid.enColeccion(coleccionJuego, titulo)) {  
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
                case 3: if (FuncionesVid.coleccionVacia(coleccionJuego)) {
                    System.out.println("No hay juegos para mostrar");
                } else{
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if (coleccionJuego[i] != null) 
                            System.out.println(coleccionJuego[i].getTitulo());
                    }
                }
                    break;
                case 4 : if(FuncionesVid.coleccionVacia(coleccionJuego)){
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
                case 5 : if(FuncionesVid.coleccionVacia(coleccionJuego)){
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
                case 6: 
                if (FuncionesVid.coleccionVacia(coleccionJuego)){
                    System.out.println("No hay juegos para mostrar");
                } else{
                    int contador = 0;
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            contador++;
                        }
                    }
                    System.out.println(contador + " de: " + tamañoColeccion);
                }
                    break;
                case 7: //Promedio de horas jugadas
                if (FuncionesVid.coleccionVacia(coleccionJuego)) {
                    System.out.println("No hay juegos para mostrar");
                } else{
                    int contadorJuegos = 0;
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            contadorJuegos++;
                        }
                    }
                    int horasTotales = FuncionesVid.contadorHoras(coleccionJuego);
                    double promedioHoras = (double) horasTotales / contadorJuegos; //Casting
                    
                    if(promedioHoras == 0)
                        System.out.println("No se han empezado los juegos");
                    else
                        System.out.println("El promedio de horas es: " + promedioHoras);
                }
                    break;
                case 8: //Juego con mas horas 
                if(FuncionesVid.coleccionVacia(coleccionJuego)){
                    System.out.println("No hay juegos por mostrar");
                } else {
                    int mayor = 0;
                    String nombreJuego = "";
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            if (mayor < coleccionJuego[i].gethorasJugadas()) {
                                mayor = coleccionJuego[i].gethorasJugadas();
                                nombreJuego = coleccionJuego[i].getTitulo();
                            }
                        }
                    }
                    System.out.println("El juego mayor jugado es: " + nombreJuego);
                }
                    break;
                case 9: // Juego con menos horas
                if(FuncionesVid.coleccionVacia(coleccionJuego)){
                    System.out.println("No hay juegos por mostrar");
                } else {
                    int menor = 1000;
                    String nombreJuego = "";
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            if (menor > coleccionJuego[i].gethorasJugadas()) {
                                menor = coleccionJuego[i].gethorasJugadas();
                                nombreJuego = coleccionJuego[i].getTitulo();
                            }
                        }
                    }
                    System.out.println("El juego menor jugado es: " + nombreJuego);
                }
                    break;
                case 10: // Porcentaje de juegos acabados
                if(FuncionesVid.coleccionVacia(coleccionJuego)){
                    System.out.println("No hay juegos para contar");
                } else{
                    int totalJuegos = 0, juegosCompletados=0;
                    for(int i = 0; i < coleccionJuego.length; i++){
                        if(coleccionJuego[i] != null){
                            totalJuegos++;
                            if(coleccionJuego[i].getCompletado()){
                                juegosCompletados++;
                            }
                        }
                    }
                    if(juegosCompletados == 0){
                        System.out.println("No hay juegos completados");
                    } else {
                        double porcentaje = (juegosCompletados * 100.0) / totalJuegos;
                        System.out.println("El porcentaje de juegos acabados es: " + porcentaje + "%");
                    }
                }
                    break;
                case 11: //busqueda parcial
                    break;
                case 12: // por rango de tiempo
                    break; 
                case 13: // recomendaciones de los no finalizados
                    break;
                case 14 : System.out.println("Saliendo...");
                    break;
                default: System.out.println("Opcion no encontrada");
                    break;
            }
        } while(opcion != 14);
        sc.close();
    }
}
