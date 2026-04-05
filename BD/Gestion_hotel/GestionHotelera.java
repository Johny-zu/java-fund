package BD.Gestion_hotel;
import java.util.Scanner;

public class GestionHotelera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menuPrincipal = "=== SISTEMA DE GESTIÓN HOTELERA ===\n" + 
                        "\n" + 
                        "1. Módulo Habitaciones" + 
                        "\n2. Módulo Huéspedes" +
                        "\n3. Módulo Reservas" + 
                        "\n4. Módulo Pagos" + 
                        "\n5. Reportes" + 
                        "\n6. Salir" + 
                        "\n" + 
                        "Seleccione una opción: ";
        String ModuloHabitaciones = "--- GESTIÓN DE HABITACIONES ---\n" + 
                        "\n1. Registrar nueva habitación" + 
                        "\n2. Listar todas las habitaciones" + 
                        "\n3. Buscar habitación por ID" + 
                        "\n4. Actualizar precio o estado" + 
                        "\n5. Eliminar habitación" + 
                        "\n6. Volver al menú principal" +
                        "\nSeleccione una opcion: ";
        int opcion, m1, m2, m3, m4, m5;
        
        do {
            System.out.printf(menuPrincipal);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: do {
                    System.out.printf(ModuloHabitaciones);
                    m1 = sc.nextInt();
                    switch (m1) {
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
                        case 6: System.out.println("Saliendo del modulo de habitaciones");
                            break;
                        default:
                            break;
                    }
                }while (m1 != 6); 
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6: System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }
        } while (opcion != 6);
        sc.close();
    }
}
