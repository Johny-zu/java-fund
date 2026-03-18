package Ejercicios.Inventario;
import java.time.LocalDate;

public class Productos {
    private int id, cantidadStock;
    private String nombre, categoria;
    private double precio;
    private LocalDate fecha;

    public Productos(int id, int cantidadStock, String nombre, String categoria, double precio, LocalDate fecha){
        this.id = id > 0 ? id : 1;
        this.cantidadStock = cantidadStock > 0 ? cantidadStock : 0;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio > 0 ? cantidadStock : 1;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id > 0 ? id : 1;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock > 0 ? cantidadStock : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio > 0 ? cantidadStock : 1;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean enExistencia(){
        return getCantidadStock() > 0 ? true : false;
    }

    public String toString(){
        String s = "";
        s += "El ID del producto es: " + getId();
        s += "\nEl nombre del producto es: " + getNombre();
        s += "\nLa categoria del producto es: " + getCategoria();
        s += "\nEl precio del producto es: " + getPrecio();
        s += "\nLa fecha de ingreso fue: " + getFecha();

        if (enExistencia()) 
            s += "\nHay " + getCantidadStock() + " en existencia";
        else
            s += "\nSin existencia del producto";
        return s;
    }
}
