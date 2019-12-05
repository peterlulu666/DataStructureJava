package test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("Enter a floating point number ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            float number = Float.parseFloat(str);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.'){
                    System.out.println("The number is a floating point number. ");
                    return;

                }

            }
            System.out.println("The number is not a floating point number. ");

        } catch (NumberFormatException e) {
            System.out.println("The number is not a floating point number. ");       

        }
    }
}
