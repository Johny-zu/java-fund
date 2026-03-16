package POO.Estudiantes;
import java.util.Scanner;

public class GestionEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1.- Agregar nuevo estudiante"
                    + "\n2.- Buscar estudiante por matricula"
                    + "\n3.- Mostrar todos los estudiantes"
                    + "\n4.- Mostrar estudiantes aprobados"
                    + "\n5.- Mostrar estudiantes reprobados"
                    + "\n6.- Calcular promedio general por estudiante"
                    + "\n7.- Salir";
        String nombre, carrera, matricula;
        int numEstudiantes, opcion;
        boolean grupoVacio = true;

        System.out.println("Ingresa la cantidad de estudiantes de los grupos: ");
        numEstudiantes = sc.nextInt();

        Estudiante [] grupo = new Estudiante[numEstudiantes];

        do{
            System.out.printf(menu + "\nIngresa una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: 
                boolean grupoCompleto = true;
                for(int i = 0; i < grupo.length; i++){
                    if(grupo[i] == null){
                        grupoCompleto = false;
                        break;
                    }
                }   
                if (grupoCompleto) {
                    System.out.println("El grupo esta completo;");
                } else{
                    for(int i = 0; i < grupo.length; i++){
                        if (grupo[i] == null) {
                            System.out.println("Ingrese el nombre del estudiante: ");
                            sc.nextLine(); // limpiar buffer si antes hubo nextInt
                            nombre = sc.nextLine();
                            System.out.println("Ingrese la carrera del estudiante: ");
                            carrera = sc.nextLine();
                            System.out.println("Ingrese la matrícula del estudiante: ");
                            matricula = sc.nextLine();
                            
                            double[] calificaciones = new double[3];
                            for(int j = 0; j < calificaciones.length; j++){
                                System.out.println("ingresa la calificacion " + (j + 1) + ": ");
                                calificaciones[j] = sc.nextDouble();
                            }
                            grupo[i] = new Estudiante(nombre, carrera, matricula, calificaciones);
                            break;
                        }
                    }
                }
                    break;
                case 2: grupoVacio = true;
                for(int i =0; i < grupo.length; i++){
                    if(grupo[i] != null){
                        grupoVacio = false;
                        break;
                    }
                }
                if (grupoVacio) {
                    System.out.println("El grupo esta vacio");
                } else{
                    String matriculaProv;
                    boolean encontrado = false;
                    System.out.println("Ingresa matricula a buscar: ");
                    sc.nextLine();
                    matriculaProv = sc.nextLine();
                    for(int i=0; i < grupo.length; i++){
                        if(grupo[i] != null && matriculaProv.equals(grupo[i].getMatricula())){
                            System.out.println(grupo[i].toString());
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado == false) {
                        System.out.println("El estudiante no existe");
                    }
                }
                break;
                case 3 :  
                grupoVacio = true;
                for(int i = 0; i < grupo.length ; i++){
                    if (grupo[i] != null && !grupo[i].estaVacio()) {
                        System.out.println(grupo[i].toString());
                        grupoVacio = false;
                    } 
                }
                if (grupoVacio) {
                    System.out.println("El grupo aun no tiene estudiantes");
                }
                    break;
                case 4: grupoVacio = true;
                for(int i =0; i < grupo.length; i++){
                    if(grupo[i] != null){
                        grupoVacio = false;
                        break;
                    }
                }
                if (grupoVacio) {
                    System.out.println("El grupo esta vacio");
                } else{
                    boolean revision = false;
                    for(int i = 0; i < grupo.length; i++){
                        if(grupo[i] != null && grupo[i].tienePromedioAprobatorio() == true){
                            System.out.println(grupo[i].getNombre());
                        }
                    }
                }
                    break;
                case 7 : System.out.println("Saliendo...");  
                    break;
                default: System.out.println("Opcion no encontrada");
                    break;
            }

        }while(opcion != 7);
    }
}