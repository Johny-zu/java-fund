package Ejercicios;

public class lenguaje_hacker {
    public static String traductor(String palabra){
        char letras[] = palabra.toCharArray();
        for(int i = 0; i < letras.length; i++){
            switch (letras[i]) {
                case 'a':
                    letras[i] = '4';
                    break;
                case 'b':
                    letras[i] = '8';
                case 'c':
                    letras[i] = '[';
                    break;
                case 'd':
                    letras[i] = ')';
                case 'e':
                    letras[i] = '3';
                    break;
                case 'f':
                    letras[i] = 'v';
                case 'g':
                    letras[i] = '$';
                    break;
                case 'h':
                    letras[i] = '#';
                case 'i':
                    letras[i] = '1';
                    break;
                case 'j':
                    letras[i] = ':';
                break;
                case 'k':
                    letras[i] = '>';
                    break;
                case 'l':
                    letras[i] = '7';
                case 'm':
                    letras[i] = '~';
                    break;
                case 'n':
                    letras[i] = '-';
                case 'o':
                    letras[i] = '*';
                    break;
                case 'p':
                    letras[i] = '/';
                case 'q':
                    letras[i] = '-';
                    break;
                case 'r':
                    letras[i] = '+';
                case 's':
                    letras[i] = '<';
                    break;
                case 't':
                    letras[i] = '_';
                case 'u':
                    letras[i] = '?';
                    break;
                case 'v':
                    letras[i] = '!';
                case 'w':
                    letras[i] = '"';
                    break;
                case 'x':
                    letras[i] = '$';
                case 'y':
                    letras[i] = '%';
                    break;
                case 'z':
                    letras[i] = '¿';
                break;
                default: System.out.println(".");
                    break;
            }
        }

        return new String(letras);
    }
    public static void main(String[] args) {
        String palabra = "asustado";
        System.out.println(traductor(palabra));
    }
}
