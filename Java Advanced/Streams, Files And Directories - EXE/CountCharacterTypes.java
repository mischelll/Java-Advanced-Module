package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String inputPath = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\" + "input.txt";
        String outputPath = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\" + "output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String line = reader.readLine();

            String vowels = "aeiou";
            String punctuation = "!?.,";

            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != ' ' ) {

                        if (vowels.contains(c + "")) {
                            vowelsCount++;
                        } else if (punctuation.contains(c + "")) {
                            punctuationCount++;
                        }else {
                            consonantsCount++;
                        }
                    }
                }

                line = reader.readLine();
            }

            writer.printf("Vowels: %d%n",vowelsCount);
            writer.printf("Consonants: %d%n",consonantsCount);
            writer.printf("Punctuation: %d",punctuationCount);

        } catch (IOException e) {
            System.out.println("Bad!");
        }
    }
}
