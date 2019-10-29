package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {

        String inputPath = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\" + "inputLineNumbers.txt";
        String outputPath = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\" + "output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();

            int counter = 1;
            while (line != null) {

                writer.println(counter +". "+line);
                counter++;
                line = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println("Bad!");
        }
    }
}
