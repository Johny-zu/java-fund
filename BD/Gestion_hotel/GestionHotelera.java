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
        String ModuloHuespedes = "--- GESTIÓN DE HUÉSPEDES ---\n" +
                        "\n1. Registrar nuevo huésped" + 
                        "\n2. Listar todos los huéspedes" + 
                        "\n3. Buscar huésped por ID" + 
                        "\n4. Buscar huésped por nombre" + 
                        "\n5. Buscar huésped por documento" + 
                        "\n6. Actualizar datos de huésped" + 
                        "\n7. Eliminar huésped" + 
                        "\n8. Volver al menú principal" +
                        "\nSeleccione una opcion: ";
        String ModuloReservas = "--- GESTIÓN DE RESERVAS ---\n" +
                        "\n1. Crear nueva reserva" + 
                        "\n2. Realizar check-in" + 
                        "\n3. Realizar check-out" + 
                        "\n4. Cancelar reserva" + 
                        "\n5. Listar reservas (con filtros)" +
                        "\n6. Ver detalle de reserva" + 
                        "\n7. Volver al menú principal" +
                        "\nSeleccione una opcion: ";
        String ModuloPagos = "--- GESTIÓN DE PAGOS ---\n" +
                        "\n1. Registrar pago" + 
                        "\n2. Ver pagos de una reserva" + 
                        "\n3. Ver saldo pendiente" + 
                        "\n4. Volver al menú principal" +
                        "\nSeleccione una opcion: ";
        String ModuloReportes = "--- REPORTES ---\n" + 
                        "\n1. Ocupación por fecha" + 
                        "\n2. Ingresos por período" + 
                        "\n3. Habitaciones más reservadas" + 
                        "\n4. Huéspedes frecuentes" + 
                        "\n5. Reservas activas hoy" + 
                        "\n6. Volver al menú principal"+
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
                        case 6: System.out.println("Saliendo del modulo de habitaciones...");
                            break;
                        default:
                            break;
                    }
                } while (m1 != 6); 
                    break;
                case 2: do {
                    System.out.printf(ModuloHuespedes);
                    m2 = sc.nextInt();
                    switch (m2) {
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
                        case 8: System.out.println("Saliendo del modulo de huespedes...");
                            break;
                        default:
                            break;
                    }
                } while (m2 != 8); 
                    break;
                case 3: do {
                    System.out.printf(ModuloReservas);
                    m3 = sc.nextInt();
                    switch (m3) {
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
                        case 7: System.out.println("Saliendo del modulo de reservas...");
                            break;
                        default:
                            break;
                    }
                } while (m3 != 7); 
                    break;
                case 4:  do {
                    System.out.printf(ModuloPagos);
                    m4 = sc.nextInt();
                    switch (m4) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4: System.out.println("Saliendo del modulo de pagos...");
                            break;
                        default:
                            break;
                    }
                } while (m4 != 4); 
                    break;
                case 5: do {
                    System.out.printf(ModuloReportes);
                    m5 = sc.nextInt();
                    switch (m5) {
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
                        case 6: System.out.println("Saliendo del modulo de reportes...");
                            break;
                        default:
                            break;
                    }
                } while (m5 != 6); 
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
