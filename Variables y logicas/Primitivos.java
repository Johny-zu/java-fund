import java.util.Scanner;

public class Primitivos {
    public static void main(String[] args) {
        // Tipos de datos primitivos en Java
        Scanner sc = new Scanner(System.in);

        int numeroEntero = 0;               // Entero
        double numeroDecimal = 0.0;         // Decimal
        char caracter = 'A';                  // Carácter
        boolean vf = true;          // Booleano

        // Imprimir los valores
        System.out.print("Introduce un numero entero: ");
        numeroEntero = sc.nextInt();
        System.out.println("Número Entero: " + numeroEntero);


        System.out.print("Introduce un numero Decimal: ");
        numeroDecimal = sc.nextDouble();
        System.out.println("el numero decimal es: " + numeroDecimal);

        System.out.print("Introduce un carácter: ");
        caracter = sc.next().charAt(0);
        System.out.println("Carácter: " + caracter);

        System.out.print("Verdadero o false? ");
        vf = sc.nextBoolean();
        System.out.println("Booleano: " + vf);
        
        //En caso de ser necesario, cerramos el scanner
        sc.close();
    }
}