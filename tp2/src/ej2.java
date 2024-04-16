/*
* Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado
ascendentemente.

* */

public class ej2 {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7,8,9,10};
        int elemento = 7;
        int posicion = buscarPos(arr, 0, elemento);

        if (posicion != -1) {
            System.out.println("El elemento " + elemento + " se encuentra en la posición " + posicion);
        } else {
            System.out.println("El elemento " + elemento + " no se encuentra en el arreglo.");
        }
    }

    public static int buscarPos(int [] arr, int pos, int elemento){
        System.out.println("Comprobando el elemento en el índice " + pos);

        if(arr[pos] == elemento){
            System.out.println("matcheo elemento" + " en pos " + pos);
            return pos;
        } else if (pos>=arr.length-1) {
            return -1;
        }
        return buscarPos(arr,pos+1, elemento);
    }
}
