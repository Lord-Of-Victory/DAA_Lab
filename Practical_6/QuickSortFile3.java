import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickSortFile3 {
    public static void main(String[] args) throws IOException {
        String file_name="randomRepeatedNumbers";
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
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] array, int low, int high) {
        int pivot = array[(low + high) / 2];
        
        while (low <= high) {
            while (array[low] < pivot) {
                low++;
            }
            while (array[high] > pivot) {
                high--;
            }
            
            if (low <= high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
                low++;
                high--;
            }
        }
        
        return low;
    }

    public static void writeToFile(int arr[],String file_name) throws IOException {
        FileWriter writer = new FileWriter("./"+file_name+"SortedOutput.txt");
        for (int i = 0; i < arr.length - 1; i++) {
            writer.write(arr[i] + "\n");
        }
        writer.close();
    }
}