package BD.CRUD_Persona;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionesPersona funcionesPersonas = new FuncionesPersona();
        ArrayList<Persona> listadoPersonas = new ArrayList<>();

        String menu = "1.- Ingresa a una persona" +
                    "\n2.- Listar a las personas" + 
                    "\n3.- Actualizar a una persona" +
                    "\n4.- Eliminar persona" + 
                    "\n5.- Salir";

        String nombre, email;
        int edad;

        int opcion;
        do{
            System.out.printf(menu + "\nIngrresa una opcion: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ingresa un opcion valida");
                opcion = 0;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre de la persona:");
                    nombre = sc.nextLine();
                    System.out.println("Ingresa la edad de la persona:");
                    edad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el email de la persona:");
                    email = sc.nextLine();
                    Persona nuevaPersona = new Persona(nombre, edad, email);
                    try {
                        funcionesPersonas.insertar(nuevaPersona);
                        System.out.println("Persona insertada correctamente");
                    } catch (Exception e) {
                        System.out.println("Error al insertar: " + e.getMessage());
                    }
                    break;
               case 2:
                    
                    break;
               case 3:
                    
                    break;
               case 4:
                    
                    break;
               case 5: System.out.println("Saliendo del programa..."); 
                    break;
                default: System.out.println("ingresa una opcion valida");
                    break;
            }
        } while(opcion != 5);
    }
}
