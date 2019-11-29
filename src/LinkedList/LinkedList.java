package LinkedList;

public class LinkedList<E> {
    private Node<E> head;
    private int currentSize;

    public LinkedList() {
        head = null;
        currentSize = 0;

    }

    public void addFirst(E obj) {
        Node<E> newNode = new Node<E>(obj);
        newNode.next = head;
        head = newNode;
        currentSize++;

    }

    public void addLast(E obj) {
        Node<E> newNode = new Node<E>(obj);
        if (head == null) {
            head = newNode;
            currentSize++;
//            addFirst(obj);
            return;

        }
        Node<E> tmpPointer = head;
        while (tmpPointer.next != null) {
            tmpPointer = tmpPointer.next;

        }
        tmpPointer.next = newNode;
        currentSize++;
        newNode.next = null;

    }

    public void insert(E obj, int index) {
        if (index == 0) {
            addFirst(obj);
            return;

        }
        Node<E> newNode = new Node<E>(obj);
        Node<E> tmpPointer = head;
        // We would move the tmpPointer to index - 1
        for (int i = 0; i < index - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        newNode.next = tmpPointer.next;
        tmpPointer.next = newNode;
        currentSize++;

    }

    public E removeFirst() {
        if (head == null) {
            return null;

        }
        E removedData = head.data;
        if (head.next == null) {
            head = null;

        } else {
            head = head.next;

        }
        currentSize--;
        return removedData;

    }

    @Override
    public String toString() {
        String node = "";
        Node<E> current = head;
        while (current != null) {
            if (current == head) {
                node = node + "[Head: " + current.data + " ]" + "->";

            } else if (current.next == null) {
                node = node + "[Tail: " + current.data + " ]" + "->";

            } else {
                node = node + "[ " + current.data + " ]" + "->";

            }
            current = current.next;

        }

        return node + "\n" + "Size is " + currentSize;


    }
}
