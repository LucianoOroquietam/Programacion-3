/*Implemente un algoritmo recursivo que convierta un número en notación decimal a su
equivalente en notación binaria.*/

import static java.lang.Integer.parseInt;

public class ej3 {
    public static void main(String[] args) {
        int num = 26;

        String binario = convertirNumeroBinario(num);
        System.out.println(binario);

    }


    public static String convertirNumeroBinario (int num){

        System.out.println("Comprobando numero " + num);
        int resto;

        if (num<=1){
            return String.valueOf(num);
        }else{
            resto = num % 2;
            return convertirNumeroBinario(num / 2) + String.valueOf(resto);
        }

    }
}
