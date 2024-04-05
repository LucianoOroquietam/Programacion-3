package ProgramacionIII.tp1;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<>();
        lista.insertFront(1);
        lista.insertFront(2);
        lista.insertFront(3);
        lista.insertFront(4);
        lista.insertFront(5);

        //llamo a mi iterador de mi clase principal
        Iterator<Integer> iterator = lista.iterator();

        //mienteas el iteato tenga un siguiente
        while (iterator.hasNext()){
            //Guardo cada valor
            Integer i = iterator.next();
            System.out.println(i);
        }

    /*    for (int i: myList){
            sout(i)
        }*/



        // Imprimir la representación de la lista enlazada
        System.out.println(lista.toString());


    }
}
