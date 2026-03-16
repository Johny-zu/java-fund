package POO.Persona;
import java.util.Scanner;

public class listaPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = "1.- Ingresa los datos de la persona" +
                    "\n2.- Estado de edad" +
                    "\n3.- Datos generales" +
                    "\n4.- Salida";

        String nombre = "";
        int edad = 0;
        char genero = 0, op;
        double peso = 0.0, altura = 0.0;

        System.out.printf("Ingresa el nombre del paciente: ");
        nombre = sc.next();

        Caracteristicas per = new Caracteristicas(nombre, edad, genero, peso, altura);
        do{
            System.out.printf(menu + "\nIngrese una opcion a tomar: ");
            op = sc.next().charAt(0);
            switch (op) {
                case '1' :
                    System.out.printf("Ingrese edad: ");
                    edad = sc.nextInt();
                    System.out.printf("Ingrese sexo m(masculino) f(femenino): ");
                    genero = sc.next().charAt(0);
                    System.out.printf("Ingrese peso: ");
                    peso = sc.nextDouble();
                    System.out.printf("Ingrese altura: ");
                    altura = sc.nextDouble();
                    per.setNombre(nombre);
                    per.setEdad(edad);
                    per.setGenero(genero);
                    per.setPeso(peso);
                    per.setAltura(altura);
                    break;
                case '2': per.validarEdad();
                    break;
                case '3': System.out.printf(per.toString());
                default: System.out.printf("Ingrese una opcion valida\n");
                    break;
            }
        } while (op != '4');
        sc.close();
    }
}
