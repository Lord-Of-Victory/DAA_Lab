import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SelectionSortFile1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader f = new FileReader("../sequentialUnrepeatedNumbers.txt");

        // Reading numbers from file
        Scanner fileScanner = new Scanner(f);
        int[] array = new int[100001]; // Assuming a maximum of 100 elements in the file
        int size = 0;

        while (fileScanner.hasNextInt()) {
            array[size++] = fileScanner.nextInt();
        }
        fileScanner.close();

        // Selection Sort
        long start = System.currentTimeMillis();
        selectionSort(array, size);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        // System.out.println("Sorted array:");
        // for (int i = 0; i < size; i++) {
        //     System.out.print(array[i] + " ");
        // }
        System.out.println("\nTime taken for sorting: " + timeElapsed + " milliseconds");

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
            // Swap arr[i] and arr[minIndex]
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
