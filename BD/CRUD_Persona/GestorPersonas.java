package BD.CRUD_Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionesPersona funcionesPersonas = new FuncionesPersona();
        String menu = "1.- Ingresa a una persona" +
                    "\n2.- Listar a las personas" + 
                    "\n3.- Actualizar a una persona" +
                    "\n4.- Eliminar persona" + 
                    "\n5.- Salir";

        String nombre, email;
        int edad;

        int opcion;
        do{
            System.out.printf(menu + "\nIngresa una opcion: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ingresa un opcion valida");
                opcion = 0;
            }
            switch (opcion) {
                case 1:
                    System.out.printf("Ingresa el nombre de la persona: ");
                    nombre = sc.nextLine();
                    System.out.printf("Ingresa la edad de la persona: ");
                    edad = sc.nextInt();
                    sc.nextLine();
                    System.out.printf("Ingresa el email de la persona: ");
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
                try {
                    List<Persona> personas = funcionesPersonas.enlistarTodos();
                    if (personas.isEmpty()) {
                        System.out.println("No hay datos por mostrar");
                    } else {
                        for (Persona per : personas) {
                            System.out.println(per.toString() + "\n");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("No se pudo relizar la operacion");
                    //e.printStackTrace();
                }                   
                    break;
               case 3: // apdate
                System.out.printf("Ingresa el ID de la persona a actualizar: ");
                int id = sc.nextInt();
                sc.nextLine();
                try {
                    Persona personaExistente = funcionesPersonas.busacarID(id);
                if (personaExistente == null) {
                            System.out.println("No existe una persona con ID: " + id);
                        } else {
                            System.out.println("Datos actuales:");
                            System.out.println(personaExistente);
                            System.out.println("\nIngresa los nuevos datos:");
                            
                            System.out.print("Ingrese nombre: ");
                            String nuevoNombre = sc.nextLine();
                            System.out.print("Ingrese la edad: ");
                            int nuevaEdad = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingrese el email: ");
                            String nuevoEmail = sc.nextLine();
                            
                            // Crear persona con los datos actualizados (conservando el mismo ID)
                            Persona personaActualizada = new Persona(id, nuevoNombre, nuevaEdad, nuevoEmail);
                        try {
                            funcionesPersonas.actualizar(personaActualizada);
                            System.out.println("Persona actualizada con exito");
                        } catch (Exception e) {
                            System.out.println("Fallo la operacion");
                            e.printStackTrace();   
                        }
                    }
                } catch (Exception e) {
                    System.out.println("No se logro ingresar a la BD");
                    e.printStackTrace();
                }
                    break;
               case 4: // Eliminar
                System.out.printf("Ingresa el ID de la persona a eliminar: ");
                int idEliminar = sc.nextInt();
                sc.nextLine();
                try {
                    // Verificar si existe
                    Persona personaEliminar = funcionesPersonas.busacarID(idEliminar);
                    if (personaEliminar == null) {
                        System.out.println("No existe una persona con ID: " + idEliminar);
                    } else {
                        System.out.println("Persona a eliminar:");
                        System.out.println(personaEliminar);
                        System.out.print("¿Estás seguro? (s/n): ");
                        String confirmacion = sc.nextLine();
                        if (confirmacion.equalsIgnoreCase("s")) {
                            funcionesPersonas.eliminarPorID(idEliminar);
                        } else {
                            System.out.println("Operacion cancelada");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Error al eliminar: " + e.getMessage());
                    e.printStackTrace();
                }
                break;
               case 5: System.out.println("Saliendo del programa..."); 
                    break;
                default: System.out.println("ingresa una opcion valida");
                    break;
            }
        } while(opcion != 5);
        sc.close();;
    }
}
