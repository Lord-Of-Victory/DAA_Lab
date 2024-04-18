import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class randomUnrepeatedNumbers {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("randomUnrepeatedNumbers.txt"))) {
            for (int number : numbers) {
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}
