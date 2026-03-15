package Ejercicios;

public class Fizbus {
    public static boolean esMultiplosTres(int num){
        if (num % 3 == 0) {
            return true;
        }
        return false;
    }
    public static boolean esMultiplosCinco(int num){
        if (num % 5 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 1;
        for(int i = 0; i < 100; i++){
            String f = "fizz", b = "buzz";
            if (esMultiplosTres(num+i) == true && esMultiplosCinco(num+i) == true) {
                System.out.println(f + b);
            } else if (esMultiplosTres(num+i) == true) {                
                System.out.println(f);
            } else if (esMultiplosCinco(num+i) == true) {
                System.out.println(b);
            } else {
                System.out.println(num + i);
            }
        }
    }
}
