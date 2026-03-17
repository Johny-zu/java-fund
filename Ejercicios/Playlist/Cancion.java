package Ejercicios.Playlist;

public class Cancion {
    private String titulo, artista;
    private int duracion; //Dato de tiempo en segundos(60 = 1min, 120 = 2min, 180 = 3 min)
    private boolean favoritos;

    public Cancion(String titulo, String artista, int duracion, boolean favoritos){
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favoritos = favoritos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) 
            this.duracion = 1;
        else
            this.duracion = duracion;
    }

    public boolean isFavoritos() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    public String toString(){
        String s = "";
        s += "La cancion se llama: " + getTitulo();
        s += "\nEl nombrel del artista es: " + getArtista();
        s += "\nLa canción dura: " + getDuracion() + " segundos";
        
        if (favoritos) {
            s += "\nEsta en favoritos";
        } else
            s += "\nNo esta enfavoritos";
        
        return s;
    }
}
