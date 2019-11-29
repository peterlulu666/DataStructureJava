package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addFirst(100);
        linkedList.addFirst(200);
        linkedList.addFirst(300);
        linkedList.addFirst(400);
        linkedList.addFirst(500);
        linkedList.insert(600, 3);
        System.out.println(linkedList.removeFirst());
        linkedList.addLast(1000);
        System.out.println(linkedList);


    }
}
