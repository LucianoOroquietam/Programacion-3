package ProgramacionIII.tp1;

import javax.swing.plaf.IconUIResource;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> lista = new MyLinkedList<>();
        lista.insertFront(20);
        lista.insertFront(17);
        lista.insertFront(14);
        lista.insertFront(10);
        lista.insertFront(9);

        MyLinkedList<Integer> lista2 = new MyLinkedList<>();
        lista2.insertFront(23);
        lista2.insertFront(20);
        lista2.insertFront(11);
        lista2.insertFront(10);
        lista2.insertFront(7);


        MyDoublyLinkedList<Integer> listaDoblementeVinculada = new MyDoublyLinkedList<>();
        listaDoblementeVinculada.insertHead(2);
        listaDoblementeVinculada.insertHead(4);
        listaDoblementeVinculada.insertHead(6);
        listaDoblementeVinculada.insertHead(8);
        listaDoblementeVinculada.insertHead(10);
        listaDoblementeVinculada.insertHead(12);



        System.out.println(listaDoblementeVinculada);

        Node<Integer> currentNode = listaDoblementeVinculada.getHead();

// Iterar sobre la lista e imprimir cada nodo con sus referencias next y previous
        while (currentNode != null) {
            System.out.println("Node: " + currentNode + ", Next: " + currentNode.getNext() + ", Previous: " + currentNode.getPrevious());
            currentNode = currentNode.getNext(); // Avanzar al siguiente nodo
        }


        //llamo a mi iterador de mi clase principal
        Iterator<Integer> iterator1 = lista.iterator();

        System.out.println("Lista de nodos 1");
        //mienteas el iteato tenga un siguiente
        while (iterator1.hasNext()) {
            //Guardo cada valor
            Integer i = iterator1.next();
            System.out.println(i);
        }

        System.out.println("el tamaño de mi lista de nodos 1 es de : " + lista.size());

        System.out.println("Lista de nodos 2");

        for (Integer i : lista2) {
            System.out.println(i);
        }
        System.out.println("el tamaño de mi lista de nodos 2 es de : " + lista.size());

        System.out.println("------------");
        System.out.println("My iterator ejercicios");

        MyLinkedList<Integer> resultado = findCommonList(lista, lista2);
        if (resultado.isEmpty()) {
            System.out.println("No hay elementos comunes en las listas.");
        } else {
            System.out.println(resultado);
        }


        MyLinkedList<Integer> resultado2 = findUniqueElementsInFirstList(lista, lista2);
        if (resultado2.isEmpty()) {
            System.out.println("No hay elementos comunes en las listas.");
        } else {
            System.out.println(resultado);
        }

        /*ListBuilder<Integer> listaNueva = new ListBuilder<>();
        listaNueva.findCommonList(lista,lista2);
        System.out.println(listaNueva);*/

    }


    public static MyLinkedList<Integer> findUniqueElementsInFirstList(MyLinkedList<Integer> lista1, MyLinkedList<Integer> lista2){
        MyLinkedList<Integer> listResult = new MyLinkedList<>();
        MyIterator<Integer> i1 = lista1.iterator();
        MyIterator<Integer> i2 = lista2.iterator();
        
        while (i1.hasNext() && i2.hasNext()){
            int info1 = i1.getInfoIterator();
            int info2 = i2.getInfoIterator();

            System.out.println("ejercicio 6  Info1: " + info1 + ", Info2: " + info2);
            
            if (info1 == info2){
                i1.next();
                i2.next();
            } else if (info1<info2) {
                System.out.println("entro");
                listResult.insertFront(info1);
                i1.next();
            }else{
                i2.next();
            }
        }
        return listResult;
    }

    public static MyLinkedList<Integer> findCommonList(MyLinkedList<Integer> lista1, MyLinkedList<Integer> lista2) {
        MyLinkedList<Integer> commonList = new MyLinkedList<>();
        MyIterator<Integer> iteratorLista1 = lista1.iterator();
        MyIterator<Integer> iteratorLista2 = lista2.iterator();

        while (iteratorLista1.hasNext() && iteratorLista2.hasNext()) {
            // Obtener la información de los elementos actuales
            Integer info1 = iteratorLista1.getInfoIterator();
            Integer info2 = iteratorLista2.getInfoIterator();
            int comparison = info1.compareTo(info2);

           // System.out.println("Info1: " + info1 + ", Info2: " + info2);

            if (comparison == 0) {
                // Si los valores son iguales, agregar el elemento a la lista común
                commonList.insertFront(info1);
                // Avanzar ambos iteradores al siguiente par de valores
                iteratorLista1.next();
                iteratorLista2.next();
            } else if (comparison < 0) {
                // Si info1 es menor que info2, avanzar el iterador de lista1
                iteratorLista1.next();
            } else {
                // Si info2 es menor que info1, avanzar el iterador de lista2
                iteratorLista2.next();
            }
        }
        return commonList;
    }


}


//si la info de i2 es menor a i1  avanzo i1
//sino si i1 menor a i2 avanzo i2
//si son iguales avanzo ambos