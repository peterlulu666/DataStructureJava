package DataStructureYoutube;

public class StackYoutube {
    private int topIndex = -1;
    private int capacity = 5;
    private int[] stack = new int[capacity];
    private int size = 0;

    public StackYoutube() {

    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("The stack is full. ");
            return;

        }
        topIndex++;
        stack[topIndex] = data;
        size++;

    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty. ");
            return 0;

        }
        int removedNumber = stack[topIndex];
        topIndex--;
        size--;
        return removedNumber;

    }

    public int peek() {
        int topNumber = stack[topIndex];
        return topNumber;

    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
    }

    public boolean isEmpty() {
        return topIndex < 0;

    }

    public boolean isFull() {
        return size >= capacity;

    }

    public static void main(String[] args) {
        var stack = new StackYoutube();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        System.out.println("The removed number is " + stack.pop());
        stack.push(100);
        System.out.println("The top number is " + stack.peek());
        System.out.println("The removed number is " + stack.pop());
        System.out.println("The removed number is " + stack.pop());
        System.out.println("The removed number is " + stack.pop());
        System.out.println("The removed number is " + stack.pop());
        System.out.println("The removed number is " + stack.pop());
        System.out.println("The removed number is " + stack.pop());
        stack.show();


    }

}


