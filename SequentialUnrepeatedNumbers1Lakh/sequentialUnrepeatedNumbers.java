import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sequentialUnrepeatedNumbers {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("sequentialUnrepeatedNumbers.txt"))) {
            for (int i = 1; i <= 100000; i++) {
                bw.write(Integer.toString(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
