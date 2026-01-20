package bucles;
import java.util.Scanner;

public class multiplicaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.print("Ingresa un numero a multiplicar: ");
        numero = sc.nextInt();

        sc.close();
        //Ejemplo de for
        for(int i = 1; i <= 10; i++){
            System.out.println(numero * i);
        }

        //Ejemplo de while
        while (numero < 9) {
            System.out.println("El numero actual es: " + numero);
            numero++; // Esto es igual a numero = numero + 1
        }
    }
}
