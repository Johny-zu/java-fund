package POO.Estudiantes;

public class Estudiante {

    private String matricula;
    private String nombre;
    private String carrera;
    private double[] calificaciones;

    public Estudiante(String matricula, String nombre, String carrera, double[] calificaciones) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.calificaciones = calificaciones;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public double calcularPromedio() {
        double suma = 0;

        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
        }

        return suma / calificaciones.length;
    }

    public boolean tienePromedioAprobatorio() {
        return calcularPromedio() >= 7.0;
    }

    @Override
    public String toString() {

        String s = "";
        s += "Nombre: " + nombre;
        s += "\nCarrera: " + carrera;
        s += "\nMatricula: " + matricula;
        s += "\nCalificacion 1: " + calificaciones[0];
        s += "\nCalificacion 2: " + calificaciones[1];
        s += "\nCalificacion 3: " + calificaciones[2];
        s += "\nPromedio: " + calcularPromedio();
        return s;
    }
}