package ProgramacionIII.tp1;


import java.util.Iterator;

public class MyLinkedList<T extends Comparable> implements Iterable<T>{
	
	private Node<T> firstNode;

	public MyLinkedList() {
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
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> current = firstNode;
		while (current != null) {
			sb.append(current.getInfo());
			if (current.getNext() != null) {
				sb.append(", ");
			}
			current = current.getNext();
		}
		sb.append("]");
		return sb.toString();
	}


	@Override
	public MyIterator<T> iterator() {
		return new MyIterator<>(this.firstNode);
	}

	public boolean contains(T info1) {
		Node<T> currentNode = this.firstNode;
		while (currentNode != null) {
			if (currentNode.getInfo().equals(info1)) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
}
