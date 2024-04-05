package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

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
        T info = this.node.getInfo();
        this.node = this.node.getNext();

        return info;

    }
}
