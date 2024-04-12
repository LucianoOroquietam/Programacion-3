package ProgramacionIII.tp1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T extends Comparable> implements Iterator<T> {

    private Node<T>node;

    public MyIterator(Node<T> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return this.node!=null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos en el iterador");
        }
        T info = this.node.getInfo();
        this.node = this.node.getNext();
        return info;

    }
    public T getInfoIterator(){
        if (this.node != null) {
            return this.node.getInfo();
        } else {
            throw new NoSuchElementException("El iterador no apunta a ningún nodo");
        }
    }
}
