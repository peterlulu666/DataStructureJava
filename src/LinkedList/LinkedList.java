package LinkedList;

public class LinkedList<E> {
    private Node<E> head;
    private int currentSize;

    /**
     * Constructor
     */
    public LinkedList() {
        head = null;
        currentSize = 0;

    }

    /**
     * addFirst
     *
     * @param obj
     * Does Add a new node to the first node and increment the linked list size
     */
    public void addFirst(E obj) {
        Node<E> newNode = new Node<E>(obj);
        newNode.next = head;
        head = newNode;
        currentSize++;

    }

    /**
     * addLast
     *
     * @param obj
     * Does Add a new node to the last node and increment the linked list size
     */
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

    /**
     * insert
     *
     * @param obj
     * @param index
     * Does Insert a new node in the index and increment the linked list size
     */
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

    /**
     * removeFirst
     *
     * @return The data in the first node
     * Does Remove the first node and decrement the linked list size
     */
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

    // We would use prevPointer and tmpPointer to remove the last node

    /**
     * removeLast
     *
     * @return The data in the last node
     * Does Remove the last node the decrement the linked list size
     */
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

    // We would use tmpPointer and currentSize to remove the last node

    /**
     * removeLastNode
     *
     * @return The data in the last node
     * Does Remove the last node the decrement the linked list size
     */
    public E removeLastNode() {
//        Node<E> tmpPointer = head;
//        int index = currentSize - 1;
//        for (int i = 0; i < index - 1; i++) {
//            tmpPointer = tmpPointer.next;
//
//        }
//        E removedData = (tmpPointer.next).data;
//        tmpPointer.next = null;
//        currentSize--;
//        return removedData;
        // We would use the remove function as the helper function
        return remove(currentSize - 1);


    }

    /**
     * remove
     *
     * @param index
     * @return The data in the last node
     * Does Remove the node in the index and decrement the linked list size
     */
    public E remove(int index) {
        Node<E> tmpPointer = head;
        // We would move the tmpPointer to index - 1
        for (int i = 0; i < index - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        E removedData = (tmpPointer.next).data;
        tmpPointer.next = (tmpPointer.next).next;
        currentSize--;
        return removedData;

    }

    /**
     * removeNode
     * @param obj
     * @return The data in the removed node
     * Does Remove the node and decrement the linked list size
     */
    public E removeNode(E obj) {
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

    /**
     * contains
     * @param obj
     * @return True if the data is in the linked list, or false if the data is not in the linked list
     */
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

    /**
     * lookup
     * @param obj
     * @return The address of the node
     */
    public Node<E> lookup(E obj){
        for (Node<E> tmpPointer = head; tmpPointer != null; tmpPointer = tmpPointer.next){
            if (((Comparable<E>) obj).compareTo(tmpPointer.data) == 0){
                return tmpPointer;

            }

        }

        return null;

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
