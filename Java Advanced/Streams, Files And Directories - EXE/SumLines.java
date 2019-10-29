package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
     static File input = new File("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\" + "input.txt");
    public static void main(String[] args) {

        //File input = new File("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\" + "input.txt");

        try (FileReader fr = new FileReader(input);
             BufferedReader reader = new BufferedReader(fr)) {

            String line = reader.readLine();
            while (line != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }

                System.out.println(sum);
                line = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println("Bad");
        }
    }
}
