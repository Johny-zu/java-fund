package Ejercicios.Playlist;

public class Cancion {
    private String titulo, artista;
    private int duracion; //Dato de tiempo en segundos(60 = 1min, 120 = 2min, 180 = 3 min)
    private boolean favoritos;

    public Cancion(String titulo, String artista, int duracion, boolean favoritos){
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion > 0 ? duracion : 1;
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
        this.duracion = duracion > 0 ? duracion : 1;
    }

    public boolean isFavoritos() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    public String toString(){
        String s = "";
        String minutos = (getDuracion() / 60) + ":" + String.format("%02d", getDuracion() % 60);
        s += "La cancion se llama: " + getTitulo();
        s += "\nEl nombrel del artista es: " + getArtista();
        s += "\nLa canción dura: " + minutos;
        
        if (favoritos) {
            s += "\nEsta en favoritos";
        } else
            s += "\nNo esta en favoritos";
        
        return s;
    }

    public boolean esMismaCancion(String titulo, String artista){
        return this.titulo.equalsIgnoreCase(titulo) && this.artista.equalsIgnoreCase(artista);
    }
}
