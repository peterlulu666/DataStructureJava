package test;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicArray {
    int capacity = 2;
    int[] dynamicArray = new int[capacity];
    int topIndex = -1;
    int size = 0;

    public DynamicArray() {

    }

    public void addData(int data) {
        if (isFull()) {
            extended();

        }
        topIndex++;
        dynamicArray[topIndex] = data;
        size++;

    }

    public boolean isFull() {
        return size >= capacity;

    }

    public void extended() {
        capacity = capacity * 2;
        int[] extendedArray = new int[capacity];
        for (int i = 0; i < dynamicArray.length; i++) {
            extendedArray[i] = dynamicArray[i];

        }
        dynamicArray = extendedArray;

    }

    public void show() {
        System.out.println(Arrays.toString(dynamicArray));
        for (int i = 0; i < size; i++) {
            System.out.println(dynamicArray[i] + " ");

        }
    }

    public static void main(String[] args) {
        var dynamicArray = new DynamicArray();
        while (true) {
            System.out.println("Enter a number ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            scanner.nextLine();
            dynamicArray.addData(number);
            dynamicArray.show();


        }


    }
}
