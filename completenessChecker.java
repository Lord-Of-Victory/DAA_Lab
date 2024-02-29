import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class completenessChecker {
    public static void main(String[] args) {
        File txtFile = new File("./sequentialUnrepeatedNumbers.txt");
        try {
            FileReader fr = new FileReader(txtFile);
            BufferedReader br = new BufferedReader(fr);

            for (int j = 1; j < 100001; j++) {
                Boolean flag = false;
                String number = br.readLine();
                for (int i = 1; i < 100001; i++) {
                    // System.out.println(i + ":::" + number + ":::" + Integer.toString(i).equals(number));
                    // if (Integer.toString(i) == number) {
                    if (Integer.toString(i).equals(number)) {
                        // System.out.println(number);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("flag:" + j);
                    System.out.println("Incomplete");
                    System.exit(240);
                }
            }
            System.out.println("Complete");
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
