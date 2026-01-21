package Metodos;

public class edad {
    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    public static void main(String[] args) {
        int edad = 21;

        esMayorDeEdad(edad);
        System.out.println("La persona es mayor de edad? " + esMayorDeEdad(edad));
        System.out.println("la Persona es mayor de edad? " + esMayorDeEdad(12));
    }
}
