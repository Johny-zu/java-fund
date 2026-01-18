import java.util.Scanner;

public class operaciones_ifelse{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int op;
        double a, b, c;
        String menu = "Escoge un numero para realizar las siguiente actividades \n1.- Sumar \n2.- Restar \n3.- dividir \n4.- multiplicar";

        System.out.print("Ingresa primer numero: ");
        a = sc.nextDouble();
        System.out.print("Ingresa segundo numero: ");
        b = sc.nextDouble();

        System.out.print(menu);

        System.out.print("\nQue haras? ");
        op = sc.nextInt();

        sc.close();
        if(op == 1)
            System.out.print("La suma de los dos numeros es: " + (c = a+b));
        else if(op == 2)
            System.out.print("La resta de los dos numeros es: " + (c = a-b));
        else if(op == 3)
            System.out.print("La division de los dos numeros es: " + (c = a/b));
        else if(op == 4)
            System.out.print("La multiplicación de los dos numeros es: " + (c = a*b));
        else
            System.out.print("Ingresa un operacion posible");
        
    }
}