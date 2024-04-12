package ProgramacionIII.tp1;


import java.util.Iterator;

public class ListBuilder<T extends Comparable> {

    public void findCommonList(MyLinkedList<T> list_1, MyLinkedList<T> list_2) {

        MyLinkedList<T> listCommonElements = new MyLinkedList<>();

        Iterator<T> iterator_one = list_1.iterator();
        while (iterator_one.hasNext()) {
            //si tengo un siguiente , guardo el elemento en una variable
            T elemento = iterator_one.next();

            // Verificar si el elemento ya ha sido visto o encontrado en list_2
            if (yaFueVistoEnLista2(elemento,list_2)) {
                // Si el elemento está presente en ambas listas, agregarlo a la lista de elementos comunes
                listCommonElements.insertFront(elemento);
            }
        }
    }


    private boolean yaFueVistoEnLista2(T elemento, MyLinkedList<T> list_2) {
        // Verificar si el elemento ya ha sido visto en list_2
        Iterator<T> iterator_two = list_2.iterator();
        while (iterator_two.hasNext()) {
            if (iterator_two.next().equals(elemento)) {
                return true;
            }
        }
        return false;
    }


}

/*
primera idea - O(n cuadrado)
public MySimpleLinkedList<T> encontrarElementosComunes(MySimpleLinkedList<T> list1, MySimpleLinkedList<T>list2){
		MySimpleLinkedList<T> listaElementosComunes= new MySimpleLinkedList<>();

		//me voy a parar en la lista 1 , primer nodo
		Node<T> currentNode_l1 = list1.firstNode;

		while (currentNode_l1 != null) {
			//agarro la informacion del nodo para comparar
			T elemento = currentNode_l1.getInfo();
			//me paro en el primer nodo de la lista 2
			Node<T> currentNode_l2 = list2.firstNode;
			boolean encontrado = false;
				while (currentNode_l2 != null && !encontrado) {
					// Si el elemento de lista1 coincide con el de lista2
					if (currentNode_l2.getInfo().equals(currentNode_l1)){
						listaElementosComunes.insertFront(elemento);
						encontrado = true;
					}

					currentNode_l2=currentNode_l2.getNext();
			}

			currentNode_l1 = currentNode_l1.getNext();
		}

		//podria llamar a un metodo que me ordene por valor de getInfo() osea si me quedo 2 1 4 -> que me quede 4 2 1 o 1 2 4 .

		return listaElementosComunes;
	}

*
*
* */
