import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("./randomRepeatedNumbers.txt");

        // Reading numbers from file
        Scanner fileScanner = new Scanner(f);
        int[] array = new int[100001];
        int size = 0;

        while (fileScanner.hasNextInt()) {
            array[size++] = fileScanner.nextInt();
        }
        fileScanner.close();

        long start = System.currentTimeMillis();
        sort(array, 0, array.length - 1);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        writeToFile(array);

        System.out.println("\nTime taken for sorting: " + timeElapsed + " milliseconds");
    }

    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void writeToFile(int arr[]) throws IOException {
        FileWriter writer = new FileWriter("./randomRepeatedNumbersSortedOutput.txt");
        for (int i = 0; i < arr.length - 1; i++) {
            writer.write(arr[i] + "\n");
        }
        writer.close();
    }
}