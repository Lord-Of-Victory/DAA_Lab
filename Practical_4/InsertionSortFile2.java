import java.io.*;
import java.util.Scanner;

public class InsertionSortFile2 {
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
        insertionSort(array);
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

    public static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
