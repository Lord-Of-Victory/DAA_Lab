import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class randomRepeatedNumbers {

    public static void main(String[] args) {

        Random random = new Random();
        long startTime = System.currentTimeMillis();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("randomRepeatedNumbers.txt"))) {
            for (int i = 1; i <= 100000; i++) {
                bw.write(Integer.toString(random.nextInt(0, 100000)));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
