public class ej5 {
    public static void main(String[] args) {
        int [] arr = {-3, -1, 0, 2, 4, 6, 10};
        if (buscarCoincidencia(arr,0)){
            System.out.println("matcheo de valores entre el indice y el valor de la posicion");
        }else {
            System.out.println("no matcheo");
        }

    }

    public static boolean buscarCoincidencia(int [] arr, int indice ){
        System.out.println("el valor de la pos " + indice);

        if (indice>=arr.length-1){
            return false;
        }else if (arr[indice]==indice){
            System.out.println("el valor de la pos es " + arr[indice] + " y el indice del arreglo es " + indice + " por lo tanto se produjo un matcheo de valores");
            return true;
        }

        return buscarCoincidencia(arr,indice+1);
    }
}
