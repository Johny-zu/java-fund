package Metodos;
public class notas{
    public static String ingresar_calificacion(int calificacion){
        if (calificacion >= 70) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    public static void main(String[] args) {
        int calificacion = 90;

        System.out.println("El alumno: " + ingresar_calificacion(calificacion));
    }
}