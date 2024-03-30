import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSortFile2 {
    public static void main(String[] args) throws IOException {
        String file_name="randomUnrepeatedNumbers";
        FileReader f = new FileReader("./"+file_name+".txt");

        // Reading numbers from file
        Scanner fileScanner = new Scanner(f);
        int[] array = new int[100001];
        int size = 0;

        while (fileScanner.hasNextInt()) {
            array[size++] = fileScanner.nextInt();
        }
        fileScanner.close();

        long start = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        writeToFile(array,file_name);

        System.out.println("\nTime taken for sorting: " + timeElapsed + " milliseconds");
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = array[mid];
        int i = low - 1;
    
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
    
        swap(array, i + 1, mid);
    
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void writeToFile(int arr[],String file_name) throws IOException {
        FileWriter writer = new FileWriter("./"+file_name+"SortedOutput.txt");
        for (int i = 0; i < arr.length - 1; i++) {
            writer.write(arr[i] + "\n");
        }
        writer.close();
    }
}