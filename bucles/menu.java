package bucles;
import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args) {
        String menu = "Escoja una opcion: \n1.- Manzana \n2.- Pera \n3.- Platano \n4.- Salida";
        int opcion;

        do {
            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(null, menu)
            );

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Elegiste Manzana 🍎");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Elegiste Pera 🍐");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Elegiste Platano 🍌");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 4);
    }
}
