/*
* Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de
Fibonacci.
Por ej. los 6 primeros términos son: 0 1 1 2 3 5
* */

public class ej4 {
    public static void main(String[] args) {
        int N = 6;
        System.out.println("Los " + N + " primeros términos de la secuencia de Fibonacci son:");
        for (int i = 0; i < N; i++) {
            System.out.print(secuenciaFibonacci(i) + " ");
        }
    }

    public static int secuenciaFibonacci(int numero){

        if (numero == 0 || numero == 1){
            return numero;
        }else{
           return secuenciaFibonacci(numero-1)+secuenciaFibonacci(numero-2);
        }
    }
}
