import java.io.*;
import java.util.Scanner;

public class SelectionSortFile2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader f = new FileReader("./randomUnrepeatedNumbers.txt");

        Scanner fileScanner = new Scanner(f);
        int[] array = new int[100001]; // maximum of 100000 elements in the file
        int size = 0;

        while (fileScanner.hasNextInt()) {
            array[size++] = fileScanner.nextInt();
        }
        fileScanner.close();

        long start = System.currentTimeMillis();
        selectionSort(array, size);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("\nTime taken for sorting: " + timeElapsed + " ms");

        FileWriter writer = new FileWriter("./randomUnrepeatedNumbersSortedOutput.txt");
        for (int i = 0; i < size; i++) {
            writer.write(array[i]+"\n");
        }
        writer.close();

        scanner.close();
    }

    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
