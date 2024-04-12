package ProgramacionIII.tp1;

public class MyDoublyLinkedList<T extends Comparable> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertHead(T info){
        Node<T> newNode = new Node<>(info, head,tail);
        if (head !=null){
            head.setPrevious(newNode);
        }else{
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public Node<T> getHead() {
        return head;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            builder.append(current.getInfo());
            if (current.getNext() != null) {
                builder.append(", ");
            }
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
}
