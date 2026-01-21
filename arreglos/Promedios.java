package arreglos;
import java.util.Scanner;

public class Promedios {
    public static double obtenerPromedios(int[] notas){
        int suma = 0; 
        for(int i = 0; i < notas.length; i++){
            suma += notas[i];
        }
        
        return (double) suma/notas.length;
    }

    public static String acredita(double promedio){
        if (promedio >= 7) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numActvidades, calificacion = 0;
        System.out.print("ingresa la cantidad de actividades que hay: ");
        numActvidades = sc.nextInt();

        int [] notas = new int[numActvidades];
        
        for(int i = 0; i < notas.length; i++){
            System.out.print("Ingresa la nota " + (i+1) + ": ");
            calificacion = sc.nextInt();

            notas[i] = calificacion;
        }

        System.out.print("Notas: ");
        for(int i = 0; i < notas.length; i++){
            System.out.print(notas[i] + " ");
        }

        sc.close();
        double promedio = obtenerPromedios(notas);
        System.out.println("\nEl promedio del estudiante es: " + promedio);
        System.out.println("Estado del alumno: " + acredita(promedio));
    }
}