package Practical_1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LinearSearchFile1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        FileReader f = new FileReader("./sequentialUnrepeatedNumbers.txt");
        System.out.println("Enter element you want to search : ");
        String element = scanner.next();
        long start = 0;
        Scanner scanner2 = new Scanner(f);
        start = System.currentTimeMillis();
        while (scanner2.hasNext()) {
            if (scanner2.next().equals(element)) {
                long finish = System.currentTimeMillis();
                long timeElapsed = finish - start;
                System.out.println("Element found \nAnd time taken is " + timeElapsed);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println("Element not found \nAnd time taken is " + timeElapsed);
        }
        scanner.close();
        scanner2.close();
    }
}