package POO.Persona;

public class Caracteristicas {
    public String nombre;
    public int edad;
    public char genero;
    public double peso, altura;

    public Caracteristicas(String nombre, int edad, char genero, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // validaciones
    public void validarEdad(){
        if(getEdad() < 18)
            System.out.print("Menor de edad\n");
        else if(getEdad() >= 18)
            System.out.print("Mayor de edad\n");
        else if(getEdad() < 1 || getEdad() >= 110)
            System.out.print("Ingrese una edad valida\n");
    }

    public String definirGenero(){
        String definirGenero = "";
        if(getGenero() == 'm')
            definirGenero = "Masculino";
        else if(getGenero() == 'f')
            definirGenero = "Femenino";
        else
            definirGenero = "Sin genero";
        return definirGenero;
    }
    

    public String toString(){
        String s = "";
        s += "El nombre de la persona es: " + getNombre();
        s += "\nLa edad de la persona es: " + getEdad();
        s += "\nEl género de la persona es: " + definirGenero();
        s += "\nEl peso de la persona es: " + getPeso();
        s += "\nLa altura de la persona es: " + getAltura();
        return s + "\n";
    }
}
