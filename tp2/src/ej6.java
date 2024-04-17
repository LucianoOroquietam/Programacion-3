import java.util.Arrays;



/**
 * Ejercicio 6
 * Implemente un algoritmo de ordenamiento por selección en un arreglo.
 * Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
 * ● ¿Qué complejidad big-O tienen estos algoritmos?
 * */

public class ej6 {
    public static void main(String[] args) {
        int [] arrA = {10,11,1,3,8,9,4,5,2};
        System.out.println("Arreglo sin ordenar");
        System.out.println( Arrays.toString(arrA));
        System.out.println("Metodo burbujeo");
        //burbujeo(arrA);
        System.out.println( Arrays.toString(arrA));
        System.out.println("ordenamiento por seleccion");
        seleccion(arrA);
        System.out.println(Arrays.toString(arrA));

    }


    public static void burbujeo(int [] A ){
        int i, j, aux;

        for ( i=0; i<A.length-1; i++){
            for ( j=0; j < A.length-i-1; j++){
                if (A[ j ] > A[ j+1 ]) {
                    aux = A[ j+1 ];
                    A[ j+1 ] = A[ j ];
                    A[ j ] = aux;

                }
            }
        }
    }


    public static void seleccion(int [] arr){
        int menor,pos,tmp;
        for (int i =0; i< arr.length-1; i++){
            //toma como menor el primero de los elementos que quedan por ordenar
            menor = arr[i];
            //guardamos su pos
            pos = i;
            //buscamos en el resto del array algun elemento menor al actual
            for (int j = i +1; j<arr.length-1; j++){
                if (arr[j] < menor){
                    menor = arr[j];
                    pos = j;
                }
            }
            // si hay alguno menor se intercambia
            if (pos!=i){
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
    }
}
