package POO.Biblioteca;

public class Libro {
    public String titulo, autor;
    public int publicacion, numPag;
    public boolean prestado = false;

    public Libro(String titulo, String autor, int publicacion, int numPag, boolean prestado){
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.numPag = numPag;
        this.prestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        if(publicacion > 0 && publicacion <= 2026)
            this.publicacion = publicacion;
        else{
            System.out.print("Año invalido");
            this.publicacion = 2000;
        }
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        if(numPag > 0)
           this.numPag = numPag;
        else {
            System.out.print("Paginas invalidas");
            this.numPag = 1;
        }
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void prestar(){
        boolean cambio = true;
        if(isPrestado() == false){
            System.out.print("Libro prestado");
            setPrestado(cambio);
        }
        else 
            System.out.print("Libro ya prestado");
    }

    public void devolver(){
        boolean cambio = false;
        if(isPrestado() == true){
            System.out.print("Libro regresado");
            setPrestado(cambio);
        }
        else 
            System.out.print("");
    }

    public int calcularTiempo(int fecha){
        int diferencia = getPublicacion() - fecha;
        return diferencia;
    }

    public boolean esLibroAntiguo(int fecha){
        int diferencia = getPublicacion() - fecha;
        if(diferencia >= 50)
            return true;
        else
            return false;
    }

    public String toString(){
        String s = "";
        s += "El nombre del libro es: " + getTitulo();
        s += "\nEl autor es: " + getAutor();
        s += "\nAño de publicación: " + getPublicacion();
        s += "\nNúmero de páginas: " + getNumPag();
        s += "\n¿Prestado?: " + (isPrestado() ? "Sí" : "No");
        return s;
    }
}
