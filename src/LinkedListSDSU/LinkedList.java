package LinkedListSDSU;

public abstract class LinkedList<E> implements Iterable<E> {
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;

        }

    }

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

    //      +-----> NodeA   +> NodeB   +> NodeC
    //     |               |          |
    // head+      +-----+  | +-----+  | +-----+    null
    //            |     |  | |     |  | |     |     ^
    // tmpPointer | next+--+ | next+--+ | next+-----+
    //            |     |    |     |    |     |
    //            +-----+    +-----+    +-----+
    //            |     |    |     |    |     |
    //            | data|    | data|    | data|
    //            |     |    |     |    |     |
    //            +-----+    +-----+    +-----+
    //       tmpPointer.next
    //                   (tmpPointer.next).next
    //                               ((tmpPointer.next).next).next
    public void addLast(E obj) {
        Node<E> newNode = new Node<E>(obj);
        // If the linked list is empty
        if (head == null) {
            head = newNode;
            currentSize++;
            return;

        }
        Node<E> tmpPointer = head;
        // Move the tmpPointer to the last node
        // Traverse the linked list
        // ((tmpPointer.next).next).next would be pointing to null
        while (tmpPointer.next != null) {
            tmpPointer = tmpPointer.next;

        }
        // We would copy the address of newNode to tmpPointer.next
        tmpPointer.next = newNode;
        currentSize++;
        newNode.next = null;

    }

    //                   head
    //                    +
    //                    |
    //                    v
    //  nodeA       +->  NodeB       +--> NodeC
    //              |                |
    //+----------+  |  +----------+  |  +----------+
    //|          |  |  |          |  |  |          |
    //|          |  |  |          |  |  |          |
    //|     next+---+  |     next+---+  |     next+---------> null
    //|          |     |          |     |          |
    //|          |     |          |     |          |
    //+----------+     +----------+     +----------+
    //|          |     |          |     |          |
    //|          |     |          |     |          |
    //|     data |     |     data |     |     data |
    //|          |     |          |     |          |
    //+----------+     +----------+     +----------+
    //
    //                   head = head.next
    public E removeFirst() {
        // If the linked list is empty
        if (head == null) {
            return null;

        }
        E removedData = head.data;
        // If the linked list has one node
        if (head.next == null) {
            head = null;

        }
        // If the linked list has more than one node, we copy the address of nodeB to head pointer
        // The address of nodeB is head.next        
        else {
            head = head.next;

        }
        currentSize--;
        return removedData;

    }

    // We would use prevPointer and tmpPointer to remove the last node
    public E removeLast() {
        // If the linked list is empty
        if (head == null) {
            return null;

        }
        // If the linked list has one node
        if (head.next == null) {
            return removeFirst();

        }
        // If the linked list has more than one node
        Node<E> tmpPointer = head;
        Node<E> prevPointer = null;
        // We would move tmpPointer to last node and move prevPointer to second last node
        // Traverse the linked list
        while (tmpPointer.next != null) {
            prevPointer = tmpPointer;
            tmpPointer = tmpPointer.next;

        }
        prevPointer.next = null;
        currentSize--;
        return tmpPointer.data;

    }

    public E remove(E obj) {
        Node<E> tmpPointer = head;
        Node<E> prevPointer = null;
        // If the linked list is empty the while loop would be skipped
        while (tmpPointer != null) {
            if (((Comparable<E>) obj).compareTo(tmpPointer.data) == 0) {
                if (tmpPointer == head) {
                    return removeFirst();

                }
                if (tmpPointer.next == null) {
                    return removeLast();

                }
                currentSize--;
                prevPointer.next = tmpPointer.next;
                return tmpPointer.data;

            }
            // We would move the tmpPointer and the prevPointer until we find the object
            prevPointer = tmpPointer;
            tmpPointer = tmpPointer.next;

        }
        return null;

    }

    public boolean contains(E obj) {
        Node<E> tmpPointer = head;
        while (tmpPointer != null) {
            if (((Comparable<E>) obj).compareTo(tmpPointer.data) == 0) {
                return true;

            }
            tmpPointer = tmpPointer.next;

        }
        return false;

    }
}
