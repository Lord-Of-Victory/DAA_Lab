import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchPrac2File2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader f = new FileReader("./randomRepeatedNumbersSortedOutput.txt");

        Scanner fileScanner = new Scanner(f);
        List<Integer> intArray = new ArrayList<Integer>(); // maximum of 100000 elements in the file
        while (fileScanner.hasNextInt()) {
            intArray.add(fileScanner.nextInt()); 
        }
        fileScanner.close();
        
        System.out.print("Enter Element To Find: ");
        int elementToFind = scanner.nextInt();

        long start = System.nanoTime();
        int result=binarySearch(intArray, elementToFind);
        long finish = System.nanoTime();
        if (result == -1){
            System.out.println("Element not present");
        }
        else{
            System.out.println("Element found at index " + result);
        }
        
        long timeElapsed = finish - start;
        System.out.println("\nTime taken for searching : " + timeElapsed + " nanoseconds");

        scanner.close();
    }

    public static int binarySearch(List<Integer> intArray, int x){
        int startInt = 0; 
        int endInt = intArray.size() - 1;
        while (startInt <= endInt) {
            int mid = (startInt + endInt) / 2;
            if (intArray.get(mid) == x) {
                return mid;
            } else if (intArray.get(mid) > x) {
                endInt = mid - 1;
            } else {
              startInt = mid + 1;
            }  
        }
        return -1;
    }
}

