public class ej1 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};

       if(verificarArregloOrdenado(arr,0)){
            System.out.println("el arreglo esta ordenado");

        }else{
            System.out.println("el arreglo no esta ordenado");
        }

    }


    public static boolean verificarArregloOrdenado(int [] arr,int pos){
        System.out.println("Comprobando el elemento en el índice " + pos);

        if (pos >= arr.length-1){
            return true;

        } else if (arr[pos] > arr[pos+1]) {
            return false;
        }
        System.out.println("Los elementos en los índices " + pos + " y " + (pos + 1) + " están ordenados.");

        return verificarArregloOrdenado(arr, pos+1);
    }
}

//1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
// Es un O(n), n = es el tamaño del array

//2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
/* para este codigo no parece tener un problema importante . ya que hace una pasada comparando par de valores
* y corta si llego al rango maximo del array o si no esta ordenado por eso tenemos un o(n)
* */

//3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
/*primero que no puedo usar la pos como en un arreglo para acceder a cada nodo, ya que cada nodo es individual,
y tiene guardado un valor en memoria que apunta al siguiente para poder comparar en este caso,
verificaria que no sea null para que la llamada recurisva siga y ademas
comparar los valores o la informacion de un nodo con el siguiente para ver si esta
ordenado. En fin tendriamos la misma complejidad pero tiene otra logica trabajar con
listas de nodos
*
* */

