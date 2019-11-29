package DataStructureYoutube;

public class AppYoutube {
    public static void main(String[] args) {
        LinkedListYoutube linkedList = new LinkedListYoutube();
        linkedList.addLast(100);
        linkedList.addLast(200);
        linkedList.addLast(300);
        linkedList.addLast(400);
        linkedList.addLast(500);
        linkedList.addLast(600);
        System.out.println("removed is " + linkedList.remove(2));
        System.out.println("removed is " + linkedList.removeLast());
        linkedList.show();

    }
}
