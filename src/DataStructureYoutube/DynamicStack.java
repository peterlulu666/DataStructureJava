package DataStructureYoutube;

import java.util.Arrays;

public class DynamicStack {
    private int topIndex = -1;
    private int capacity = 2;
    private int[] stack = new int[capacity];
    private int size = 0;

    public DynamicStack() {

    }

    public void push(int data) {
        if (isFull()) {
            extend();

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
        shrink();
        return removedNumber;

    }

    public int peek() {
        int topNumber = stack[topIndex];
        return topNumber;

    }

    public boolean isEmpty() {
        return topIndex < 0;

    }

    public boolean isFull() {
        return size >= capacity;

    }

    public void extend() {
        capacity = capacity * 2;
        int[] extendedStack = new int[capacity];
        // We would copy the array like this
        System.arraycopy(stack, 0, extendedStack, 0, size);
        stack = extendedStack;

    }

    public void shrink() {
        if (size <= (capacity / 2) / 2) {
            capacity = capacity / 2;

        }
        int[] shrinkedStack = new int[capacity];
        // We would copy the array like this
        System.arraycopy(stack, 0, shrinkedStack, 0, size);
        stack = shrinkedStack;

    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println(Arrays.toString(stack));
    }

    public static void main(String[] args) {
        var dynamicStack = new DynamicStack();
        dynamicStack.push(15);
        dynamicStack.show();
        dynamicStack.push(8);
        dynamicStack.show();
        dynamicStack.push(10);
        dynamicStack.show();
        dynamicStack.push(10);
        dynamicStack.show();
        dynamicStack.push(10);
        dynamicStack.show();
        dynamicStack.pop();
        dynamicStack.show();
        dynamicStack.pop();
        dynamicStack.show();
        dynamicStack.pop();
        dynamicStack.show();
        dynamicStack.pop();
        dynamicStack.show();
        dynamicStack.pop();
        dynamicStack.show();
        dynamicStack.pop();
        dynamicStack.show();

        
    }

}


