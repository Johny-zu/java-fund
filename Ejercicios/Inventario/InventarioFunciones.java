package Ejercicios.Inventario;
import java.util.ArrayList;

public class InventarioFunciones {
    public void agregarProducto(ArrayList<Productos> listadoInventario, Productos nuevoProducto){
        listadoInventario.add(nuevoProducto);
        System.out.println("Nuevo producto agregado: " + nuevoProducto.getNombre());
    }

    public boolean eliminarProducto(ArrayList<Productos> listadoInventario, int indice){
        if(indice > 0 && indice < listadoInventario.size()){
            Productos eliminar = listadoInventario.remove(indice);
            System.out.println("El producto: " + eliminar.getNombre() + " fue eliminado con exito");
            return true;
        } else {
            System.out.println("Indice no encontrado");
            return false;
        }
    }

    public ArrayList<Productos> buscarPorNombre(ArrayList<Productos> listadoInventario, String productoBuscado) {
        if (listadoInventario == null || listadoInventario.isEmpty() || productoBuscado == null) {
            return new ArrayList<>(); // Retornar lista vacía en lugar de null
        }
        ArrayList<Productos> listadoCoincidencias = new ArrayList<>();
        String busquedaProducto = productoBuscado.toLowerCase().trim();
        for (Productos producto : listadoInventario) {
            if (producto != null && producto.getNombre() != null) {
                if (producto.getNombre().toLowerCase().contains(busquedaProducto)) {
                    listadoCoincidencias.add(producto);
                }
            }
        }
        return listadoCoincidencias;
    }

    public boolean listaVacia(ArrayList<Productos> listadoInventario){
        if (listadoInventario == null || listadoInventario.isEmpty()) {
            return true;
        } else
            return false;
    }

    public ArrayList<Productos> buscarPorCategoria(ArrayList<Productos> listadoInventario, String productoBusqueda){
        if(listaVacia(listadoInventario) || productoBusqueda == null){
            return new ArrayList<>();
        }
        ArrayList<Productos> listadoCategoria = new ArrayList<>();
        String busquedaProducto = productoBusqueda.trim();
        for (Productos producto : listadoInventario) {
            if (producto != null && producto.esMismaCategoria(busquedaProducto)) {
                listadoCategoria.add(producto);
            }
        }
        return listadoCategoria;
    }
    
    public ArrayList<Productos> buscarBajoStock(ArrayList<Productos> listadoInventario){
        if (listaVacia(listadoInventario))
            return new ArrayList<>();
        ArrayList<Productos> listadoBajoStock = new ArrayList<>();
        for (Productos producto : listadoInventario) {
            if (producto != null && producto.necesitaReposicion()) {
                listadoBajoStock.add(producto);
            }
        }
        return listadoBajoStock;
    }

    public double valorTotalInventario(ArrayList<Productos> listadoInventario){
        if (listaVacia(listadoInventario)) 
            return 0;
        double valorTotal = 0;
        for (Productos productos : listadoInventario) {
            valorTotal += productos.valorTotalProducto();
        }
        return valorTotal;
    }

    public ArrayList<Productos> productoMasCaro(ArrayList<Productos> listadoInventario){
        if (listaVacia(listadoInventario)) 
            return new ArrayList<>();
        ArrayList<Productos> listadoMasCaros = new ArrayList<>();
        double precioMasAlto = 0;
        for (Productos productos : listadoInventario) {
            if (precioMasAlto < productos.getPrecio()) {
                precioMasAlto = productos.getPrecio();
            }
        }
        for (Productos productos : listadoInventario) {
            if (productos.getPrecio() == precioMasAlto) {
                listadoMasCaros.add(productos);
            }
        }
        return listadoMasCaros;
    }

    public ArrayList<Productos> productoMayorValorTotal(ArrayList<Productos> listadoInventario){
        if (listaVacia(listadoInventario)) {
            return new ArrayList<>();
        }
        ArrayList<Productos> listaMayorValorTotal = new ArrayList<>();
        double mayorValor = 0;
        for (Productos productos : listadoInventario) {
            if (mayorValor < productos.valorTotalProducto()) {
                mayorValor = productos.valorTotalProducto();
            }
        }
        for (Productos productos : listadoInventario) {
            if (productos.valorTotalProducto() == mayorValor) {
                listaMayorValorTotal.add(productos);
            }
        }
        return listaMayorValorTotal;
    }

    public String categoriasUnicas(ArrayList<Productos> listadoInventario){
        if (listaVacia(listadoInventario)) {
            return "No se han ingresado categorias";
        }
        String listadoCategorias = "";
        ArrayList<String> listadoCategoriasUnicas = new ArrayList<>();
        for (Productos productos : listadoInventario) {
            String categorias = productos.getCategoria();
            if (!listadoCategoriasUnicas.contains(categorias)) {
                listadoCategoriasUnicas.add(categorias);
            }
        }
        for(int i = 0; i < listadoCategoriasUnicas.size(); i++){
            if (i == 0) {
                listadoCategorias += listadoCategoriasUnicas.get(i);
            } else {
                listadoCategorias += ", " + listadoCategoriasUnicas.get(i);
            }
        }
        return listadoCategorias;
    }

    public void aplicarDescuentoPorCategoria(ArrayList<Productos> listadoInventario, String categoriaParaDescuento, double descuento){
        if (listaVacia(listadoInventario)) {
            System.out.println("No productos en lista");
            return;
        }  
        if(descuento > 0 && descuento <= 50){
            int contador = 0;
            for (Productos productos : listadoInventario) {
                if (productos != null && productos.esMismaCategoria(categoriaParaDescuento)) {
                    double precioOriginal = productos.getPrecio();
                    double nuevoPrecio = precioOriginal - (precioOriginal * (descuento/100));
                    productos.setPrecio(nuevoPrecio);
                    contador++;

                    System.out.println("El precio de " + productos.getNombre() + " costaba: $" +
                                    precioOriginal + "\nAhora cuesta: $" + nuevoPrecio);
                }
            }
            if (contador == 0) {
                System.out.println("No se hallaron productos de la categoria: " + categoriaParaDescuento);
            } else {
                System.out.println("El descuento de " + descuento + " a aplicado a " + contador + " prouctos de " + categoriaParaDescuento);
            }
        } else {
            System.out.println("El descuento debe ser entre 1% y 50%");
        }
    }

    public int generadorID(ArrayList<Productos> listadoInventario){
        if (listaVacia(listadoInventario)) {
            return 1;
        }
        boolean [] idUsados = new boolean[listadoInventario.size() + 2];

        for (Productos producto: listadoInventario) {
            if (producto.getId() < idUsados.length) {
                idUsados[producto.getId()] = true;
            }
        }
        for (int i = 1; i < idUsados.length; i++){
            if (!idUsados[i]) {
                return i;
            }
        }
        return idUsados.length;
    }
}
