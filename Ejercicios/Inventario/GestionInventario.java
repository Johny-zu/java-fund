package Ejercicios.Inventario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionInventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu = "1.- Agregar producto nuevo\n" + 
                        "2.- Eliminar producto por ID\n" +
                        "3.- Mostrar todo el inventario\n" +
                        "4.- Buscar productos por nombre\n" +
                        "5.- Buscar productos por categoría\n" +
                        "6.- Mostrar productos bajos en stock (menos de 5 unidades)\n" + //
                        "7.- Calcular valor total del inventario\n" +
                        "8.- Ver producto más caro y de mayor valor total\n" + 
                        "9.- Ver categorías disponibles\n" + 
                        "10.- Aplicar descuento a categoría\n" +
                        "11.- Salir";
        int opcion;

        ArrayList<Productos> listadoInventario = new ArrayList<>();
        InventarioFunciones funcionInventario = new InventarioFunciones();
        do {
            System.out.printf(menu + "\nEscoje una opción: ");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número válido");
                sc.nextLine(); 
                opcion = 0;
            }
            switch (opcion) {
                case 1: 
                int id = funcionInventario.generadorID(listadoInventario);
                System.out.println("El ID asignado al producto es: " + id);
                sc.nextLine(); 
                System.out.printf("Ingresa el nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.printf("Ingresa la categoria: ");
                String categoria = sc.nextLine();
                System.out.printf("Ingresa la cantidad en stock: ");
                int cantidadStock = sc.nextInt();
                System.out.printf("Ingresa el precio del producto: ");
                double precio = sc.nextDouble();
                sc.nextLine(); 
                LocalDate fecha = LocalDate.now();
                System.out.println("El producto fue ingresado el dia: " + fecha);
                Productos productoNuevo = new Productos(id, cantidadStock, nombre, categoria, precio, fecha);
                listadoInventario.add(productoNuevo);
                    break;
                case 2: if (funcionInventario.listaVacia(listadoInventario)) {
                    System.out.println("Sin existencias");
                } else{
                    System.out.println("Lista de productos: \n");
                    int contador = 1;
                    for (Productos productos : listadoInventario) {
                        System.out.println(contador + ".- " + productos.getNombre());
                        contador++;
                    }
                    System.out.printf("Ingresa el producto a eliminar: ");
                    try {
                        int indice = sc.nextInt() -1;
                        funcionInventario.eliminarProducto(listadoInventario, indice);
                    } catch (Exception e) {
                        System.out.println("Ingresa una opcion valida");
                    }
                }
                    break;
                case 3: if (funcionInventario.listaVacia(listadoInventario)) {
                    System.out.println("El inventario aun no recibe productos");
                } else {
                    for (Productos productos : listadoInventario) {
                        System.out.println(productos.toString());
                    }
                }
                    break;
                case 4: if (funcionInventario.listaVacia(listadoInventario)) {
                    System.out.println("Sin productos por buscar");
                } else {
                    System.out.println("Producto por buscar: ");
                    sc.nextLine();
                    String buscarNombreProdcuto = sc.nextLine();                    
                    System.out.println(funcionInventario.buscarPorNombre(listadoInventario, buscarNombreProdcuto));
                }
                    break;
                case 5: if(funcionInventario.listaVacia(listadoInventario)){
                    System.out.println("Sin datos por buscar");
                } else {
                    System.out.println("De las categorias existentes, de cual busca los datos: " + funcionInventario.categoriasUnicas(listadoInventario));
                    sc.nextLine();
                    String productoBusqueda = sc.nextLine();
                    System.out.println(funcionInventario.buscarPorCategoria(listadoInventario, productoBusqueda));
                }
                    break;
                case 6: if (funcionInventario.listaVacia(listadoInventario)) {
                    System.out.println("No hay datos por mostrar");
                } else
                    System.out.println(funcionInventario.buscarBajoStock(listadoInventario));
                    break;
                case 7: if(funcionInventario.listaVacia(listadoInventario)){
                    System.out.println("No hay inventario");
                } else{
                    System.out.println("El inventario vale $" + funcionInventario.valorTotalInventario(listadoInventario));
                }
                    break;
                case 8: if (funcionInventario.listaVacia(listadoInventario)) {
                    System.out.println("No hay productos por mostrar");
                } else{
                    System.out.println("El producto mas caro es: \n" + funcionInventario.productoMasCaro(listadoInventario));
                    System.out.println("El producto/s con mayor producto es: " + funcionInventario.productoMayorValorTotal(listadoInventario));
                }
                    break;
                case 9: System.out.println(funcionInventario.categoriasUnicas(listadoInventario));
                    break;
                case 10: if (funcionInventario.listaVacia(listadoInventario)) {
                    System.out.println("No hay productos para dar descuentos");
                } else{
                    System.out.println("Ingresa la categoria a la que se le afectura el descuento: ");
                    sc.nextLine();
                    String categoriaParaDescuento = sc.nextLine();
                    System.out.println("Ingresa el descuento entre 1% y 50%");
                    int descuento = sc.nextInt();
                    if (descuento > 1 && descuento <= 50) {
                        funcionInventario.aplicarDescuentoPorCategoria(listadoInventario, categoriaParaDescuento, descuento);
                    } else{
                        System.out.println("No se puede aplicar el descuento, verificar las reglas del descuento");
                    }
                }
                    break;
                case 11: System.out.println("Saliendo del sistema...");
                    break;
                default: System.out.println("Ingrese una opcion valida");
                    break;
            }            
        } while(opcion != 11);
        sc.close();
    }
}
