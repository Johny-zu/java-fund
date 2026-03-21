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
        int edad, op;

        do{
            System.out.printf(menu + "\nIngrresa una opcion: ");
            try {
                sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ingresa un opcion valida");
            }
            switch (op) {
                case 1: 
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
        } while(op != 5);
    }
}
