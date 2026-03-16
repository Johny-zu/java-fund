package POO.Biblioteca;
import java.util.Scanner;

public class GestionBiblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String titulo, autor;
        int publicacion, numPag;
        boolean prestado;
        int op;
        String menu = "1.- Crear libro \n2.- Prestar libro \n3.- Devolver libro \n4.- consultar informacion del lbro, \n5.- Verificar si el libro es antiguo \n6.- Salida";

        Libro lib = null;
        do{
            System.out.printf(menu + "\nIngrese una opción: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.printf("Ingrese el nombre del libro: ");
                    sc.nextLine(); // Consumir el salto de línea pendiente
                    titulo = sc.nextLine();
                    System.out.printf("Ingrese el autor del libro: ");
                    autor = sc.nextLine();
                    System.out.printf("Ingrese el año de publicación: ");
                    publicacion = sc.nextInt();
                    System.out.printf("Ingrese el número de páginas: ");
                    numPag = sc.nextInt();
                    prestado = false;
                    System.out.println("Libro creado exitosamente.");
                    lib = new Libro(titulo, autor, publicacion, numPag, prestado);
                break;
                case 2: lib.prestar();
                System.out.println("Libro prestado");
                break;
                case 3: lib.devolver();
                System.out.println("Libro devuelto");
                break;
                case 4:
                    if (lib == null)
                        System.out.println("No hay datos del libro");
                    else 
                       System.out.println(lib.toString());
                break;
                case 5: int fecha;
                System.out.println("Ingresa la fecha");
                fecha = sc.nextInt();
                int tiempo = lib.calcularTiempo(fecha);
                if (tiempo >= 50)
                    System.out.println("El libro es viejo");
                else 
                    System.out.println("El Libro es moderno");
                break;
                case 6: System.out.println("Saliendo...");
                break;
                default: System.out.printf("Ingrese una opcion valida\n");
                break;
            }
        } while (op != 6);
        sc.close();
    }
}
