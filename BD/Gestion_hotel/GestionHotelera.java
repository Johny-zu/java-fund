package BD.Gestion_hotel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import BD.Gestion_hotel.FuncionesHotel.FuncionHabitacion;
import BD.Gestion_hotel.FuncionesHotel.FuncionHuespedes;
import BD.Gestion_hotel.Modelo.EstadoHabitacion;
import BD.Gestion_hotel.Modelo.Habitacion;
import BD.Gestion_hotel.Modelo.Huesped;
import BD.Gestion_hotel.Modelo.TipoHabitacion;

public class GestionHotelera {
    public static void main(String[] args) throws SQLException {
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
                        "\n4. Actualizar precio" + 
                        "\n5. Actualizar estado" +
                        "\n6. Eliminar habitación" + 
                        "\n7. Volver al menú principal" +
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
        
        //Global
        String numero = "";
        
        // Habitacion
        TipoHabitacion tipo;
        double precio_noche;
        int capacidad;
        EstadoHabitacion estado;

        // Huesped
        String nombre, telefono, documento, email;
        LocalDate fecha_registro;

        do {
            System.out.printf(menuPrincipal);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: do {
                    System.out.printf(ModuloHabitaciones);
                    m1 = sc.nextInt();
                    sc.nextLine();
                    FuncionHabitacion FunHab = new FuncionHabitacion();                
                    switch (m1) {
                        case 1: // Registrar nueva habitación
                            System.out.printf("Ingrese numero de habitacion: ");
                            numero = sc.nextLine();
                            System.out.printf("Ingrese el tipo de la habitacion (individual/doble/suite): ");
                            String tipoStr = sc.nextLine();
                            tipo = TipoHabitacion.fromString(tipoStr); 
                            System.out.printf("Ingrese el precio por noche: ");
                            precio_noche = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Ingrese la capacidad: ");
                            capacidad = sc.nextInt();
                            sc.nextLine(); 
                            System.out.printf("Ingrese el estado (disponible/mantenimiento): ");
                            String estadoStr = sc.nextLine();
                            estado = EstadoHabitacion.fromString(estadoStr);  
                            Habitacion nuevHabitacion = new Habitacion(numero, tipo, precio_noche, capacidad, estado);
                            FunHab.insertar(nuevHabitacion);
                            System.out.printf("Nueva habitacion registrada con exito\n");
                        break;
                        case 2: // Listar todas las habitaciones
                            if (!FunHab.hayRegistros()) {
                                System.out.println("No hay habitaciones registradas en el sistema.");
                                break;
                            }
                            System.out.println(FunHab.enlistarHabitaciones());
                        break;
                        case 3: //Buscar habitación por ID
                            if (!FunHab.hayRegistros()) {
                                System.out.println("No hay habitaciones registradas en el sistema.");
                                break;
                            }
                            System.out.printf("Ingrese el numero de habitacion por buscar: ");
                            int id = sc.nextInt();
                            System.out.println("\nDetalles de la habitacion: \n" + FunHab.buscarID(id));
                        break;
                        case 4: // Actualizar precio
                            if (!FunHab.hayRegistros()) {
                                System.out.println("No hay habitaciones registradas en el sistema.");
                                break;
                            }
                            System.out.print("Ingrese el ID de la habitación a actualizar: ");
                            int id_habitacion_precio = sc.nextInt();
                            sc.nextLine();
                            Habitacion precioHabitacionExistente = FunHab.buscarID(id_habitacion_precio);
                            if (precioHabitacionExistente == null) {
                                System.out.println("No se encontró la habitación con ID: " + id_habitacion_precio);
                                break;
                            }
                            System.out.print("Ingrese el nuevo precio: ");
                            double nuevoPrecio = sc.nextDouble();
                            sc.nextLine();
                            precioHabitacionExistente.setPrecio_noche(nuevoPrecio);
                            FunHab.actualizar(precioHabitacionExistente);
                            System.out.println("Precio actualizado con éxito");
                        break;
                        case 5: // Actualizar estado
                            if (!FunHab.hayRegistros()) {
                                System.out.println("No hay habitaciones registradas en el sistema.");
                                break;
                            }
                            System.out.print("Ingrese el ID de la habitación a actualizar: ");
                            int id_habitacion_estado = sc.nextInt();
                            sc.nextLine();
                            Habitacion estadoHabitacionExistente = FunHab.buscarID(id_habitacion_estado);
                            if (estadoHabitacionExistente == null) {
                                System.out.println("No se encontró la habitación con ID: " + id_habitacion_estado);
                                break;
                            }
                            System.out.print("Ingrese el nuevo estado (disponible/mantenimiento): ");
                            String nuevoEstadoStr = sc.nextLine();
                            EstadoHabitacion nuevoEstado = EstadoHabitacion.fromString(nuevoEstadoStr);
                            estadoHabitacionExistente.setEstado(nuevoEstado);
                            FunHab.actualizar(estadoHabitacionExistente);
                            System.out.println("Estado actualizado con éxito");
                        break;                        
                        case 6: // Eliminar habitación
                            if (!FunHab.hayRegistros()) {
                                System.out.println("No hay habitaciones registradas en el sistema.");
                                break;
                            }
                            System.out.print("Ingrese el ID de la habitación a eliminar: ");
                            int id_eliminar = sc.nextInt();
                            sc.nextLine();
                            FunHab.eliminarPorID(id_eliminar);
                        break;
                        case 7: System.out.println("Saliendo del modulo de habitaciones...");
                            break;
                        default:
                            break;
                    }
                } while (m1 != 7); 
                    break;
                case 2: do {
                    System.out.printf(ModuloHuespedes);
                    m2 = sc.nextInt();
                    sc.nextLine();
                    FuncionHuespedes FunHues = new FuncionHuespedes();
                    switch (m2) {
                        case 1: // Registrar nuevo huésped
                        System.out.printf("Ingrese nombre del huesped: ");
                        nombre = sc.nextLine();
                        System.out.printf("Ingrese el email del huesped: ");
                        email = sc.nextLine();
                        System.out.printf("Ingrese el telefono del huespes: ");
                        telefono = sc.nextLine();
                        System.out.printf("Ingresa el documento de validacion del usuario: ");
                        documento = sc.nextLine();
                        fecha_registro = LocalDate.now();
                        Huesped nuevoHuesped = new Huesped(nombre, email, telefono, documento, fecha_registro);
                        FunHues.insertar(nuevoHuesped);
                        System.out.println("Huesped ingresado con exito\n");
                            break;
                        case 2: // Listar todos los huéspedes
                        break;
                        case 3: // Buscar huésped por ID
                            break;
                        case 4: //Buscar huésped por nombre
                            break;
                        case 5: // Buscar huésped por documento
                            break;
                        case 6: // Actualizar datos de huésped
                            break;
                        case 7: // Eliminar huésped
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
                default: System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 6);
        sc.close();
    }
}
