package DataStructureYoutube;

public class LinkedListYoutube {
    private NodeYoutube head;
    private int currentSize;

    public LinkedListYoutube() {

    }

    public void addLast(int data) {
        NodeYoutube newNode = new NodeYoutube();
        newNode.data = data;
        newNode.next = null;
        if (head == null) {
            head = newNode;
            currentSize++;
            return;

        }
        NodeYoutube tmpPointer = head;
        while (tmpPointer.next != null) {
            tmpPointer = tmpPointer.next;

        }
        tmpPointer.next = newNode;
        currentSize++;

    }

    public void addFirst(int data) {
        NodeYoutube newNode = new NodeYoutube();
        newNode.data = data;
        newNode.next = null;
        newNode.next = head;
        head = newNode;

    }

    public void insert(int index, int data) {
        NodeYoutube newNode = new NodeYoutube();
        newNode.data = data;
        newNode.next = null;
        if (head == null) {
            addFirst(data);
            currentSize++;
            return;

        }
        NodeYoutube tmpPointer = head;
        // We would move the tmpPointer to index - 1
        for (int i = 0; i < index - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        newNode.next = tmpPointer.next;
        tmpPointer.next = newNode;
        currentSize++;

    }

    public int remove(int index) {
        NodeYoutube newNode = new NodeYoutube();
        newNode.next = null;
        NodeYoutube tmpPointer = head;
        // We would move the tmpPointer to index - 1
        for (int i = 0; i < index - 1; i++) {
            tmpPointer = tmpPointer.next;

        }
        int removedData = (tmpPointer.next).data;
        tmpPointer.next = (tmpPointer.next).next;
        currentSize--;
        return removedData;

    }

    // We would use tmpPointer and currentSize to remove the last node
    public int removeLast() {
//        NodeYoutube tmpPointer = head;
//        int index = currentSize - 1;
//        for (int i = 0; i < index - 1; i++) {
//            tmpPointer = tmpPointer.next;
//
//        }
//        int removedData = (tmpPointer.next).data;
//        tmpPointer.next = (tmpPointer.next).next;
//        currentSize--;
//        return removedData;
        return remove(currentSize - 1);

    }

    public void show() {
        NodeYoutube current = head;
        while (true) {
            System.out.println(current.data);
            current = current.next;
            if (current == null) {
                break;

            }

        }
        System.out.println("The linked list size is " + currentSize);

    }
}
