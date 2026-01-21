package arreglos;
import java.util.Scanner;

public class BusquedaElemento {

    public static boolean buscandoElemento(String listaElementos[], String elemento){
        for(int i = 0; i < listaElementos.length; i++){
            if(listaElementos[i].equals(elemento)){
                return true;
            }
        }
        return false;
    }

    public static String invirtiendoElemento(String elemento){
        String invertido = "";
        for(int i = elemento.length() - 1; i >= 0; i--){
            invertido += elemento.charAt(i);
        }
        return invertido;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String elemento = "";
        int n;

        System.out.print("Ingresa el numero de elementos: ");
        n = sc.nextInt();
        sc.nextLine();

        String [] listaElementos = new String[n];

        for(int i = 0; i < listaElementos.length; i++){
            int j = i;
            System.out.print("Ingresa el elemento " + (j+1) + ": ");
            elemento = sc.nextLine();
            listaElementos[i] = elemento;
        }

        System.out.println("Los elementos son: ");
        for(int i=0; i < listaElementos.length; i++){
            System.out.print(listaElementos[i] + ", ");
        }

        System.out.print("\nIngresa el elemento a buscar: ");
        elemento = sc.nextLine();

        if (buscandoElemento(listaElementos, elemento) == true) 
            System.out.println("El reverso del elemento es: " + invirtiendoElemento(elemento));
        else 
            System.out.println("El elemnto no existe");

        sc.close();
    }
}
