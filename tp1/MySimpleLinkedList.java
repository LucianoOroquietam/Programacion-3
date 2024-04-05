package ProgramacionIII.tp1;


import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> firstNode;
	
	public MySimpleLinkedList() {
		this.firstNode = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.firstNode);
		this.firstNode = tmp;
	}
	
	public T extractFront() {		
		//extaigo el nodo , y muestro el nodo que extraje
		 //el primer nodo se vuelve el siguiente siempre y cuando exista

		Node<T> temp = this.firstNode;
		this.firstNode = firstNode.getNext();// Avanzar al siguiente nodo

		return temp.getInfo();
	}

	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
	public T get(int index) {
		int pos = 0;
		Node<T> currentNode = this.firstNode;
		while (currentNode!=null && pos<index){
			pos++;
			currentNode = currentNode.getNext();
		}

		if (currentNode!=null)
			return currentNode.getInfo();
		else
			return null;
	}

	public int indexOf(T element){
		//reciba un elemento y retorne el índice donde está almacenado ese
		//elemento, o -1 si el elemento no existe en la lista
		Node<T>currentNode = this.firstNode;
		int pos = 0;
		while (currentNode!=null){
			if (currentNode.getInfo().equals(element)){
				return pos;
			}

			currentNode = currentNode.getNext();
			pos++;
		}
		return -1;
	}

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

	public int size() {
		int size = 0;
		Node<T> currentNode = this.firstNode;
		while (currentNode!=null){
			currentNode = currentNode.getNext();
			size++;
		}
		return size;
	}


	@Override
	public String toString() {
		return
				"primer nodo=" + firstNode;
	}


	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.firstNode);
	}
}
