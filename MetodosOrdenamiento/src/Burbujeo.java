import java.util.Arrays;

public class Burbujeo {
    public static void main(String[] args) {
        int [] A = {5, 3, 8, 2, 7, 1};
        System.out.println("Arreglo sin ordenar");
        System.out.println(Arrays.toString(A));
        int i, j, aux, contF1 =0, contF2=0,cont=0;

        for ( i=0; i<A.length-1; i++){
            contF1++;
            for ( j=0; j < A.length-i-1; j++){
                contF2++;
                if (A[ j ] > A[ j+1 ]) {
                    aux = A[ j+1 ];
                    A[ j+1 ] = A[ j ];
                    A[ j ] = aux;
                    cont++;
                }
            }
        }
        System.out.println("Arreglo ordenado asc con metodo de burbujeo");
        System.out.println(Arrays.toString(A));
        System.out.println("Al primer for entro " + contF1 + " veces y realizo " + contF2 + " intercambios" + " veces que entro al if " + cont);


    }
}
//5, 3, 8, 2, 7, 1
//3, 5, 2, 7, 1, 8
//3 , 2 , 5 , 1 ,7 ,8
//2,1,3,5,7,8
//1,2,3,5,7,8



//5+4+3+2+1 = 15 veces intercambio
//5 veces entro al primer for

//si yo no le resto -i lo va a realizar 10 veces mas en este caso. de todas formas es un o(n cuadrado)