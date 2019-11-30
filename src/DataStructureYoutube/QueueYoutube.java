package DataStructureYoutube;

public class QueueYoutube {
    int front = 0;
    int rear = -1;
    int capacity = 5;
    int[] queue = new int[capacity];
    int size = 0;

    public QueueYoutube() {

    }

    public void enQueue(int data) {
        rear++;
        queue[rear] = data;
        size++;

    }

    public int deQueue() {
        int removedData = queue[front];
        front++;
        size--;
        return removedData;

//        int removedData = queue[0];
//        for (int i = 1; i < size; i++) {
//            queue[i - 1] = queue[i];
//
//        }
//        size--;
//        return removedData;

    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[front + i] + " ");
        }
    }

    public static void main(String[] args) {
        QueueYoutube queueYoutube = new QueueYoutube();
        queueYoutube.enQueue(1);
        queueYoutube.enQueue(2);
        queueYoutube.enQueue(3);
        queueYoutube.enQueue(4);
        queueYoutube.enQueue(5);
        System.out.println("The removed data is " + queueYoutube.deQueue());
        System.out.println("The removed data is " + queueYoutube.deQueue());
        queueYoutube.show();


    }
}
