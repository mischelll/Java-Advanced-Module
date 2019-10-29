package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) {

        File one = new File("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        File two = new File("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        File output = new File("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\newFile.txt");

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(one.toString()));
            PrintWriter writer = new PrintWriter(output);

            String line = reader.readLine();
            while (line != null) {
                writer.println(line);

                line = reader.readLine();
            }

            reader.close();

            reader = Files.newBufferedReader(Paths.get(two.toString()));
            line = reader.readLine();

            while (line != null){
                writer.println(line);
                line = reader.readLine();
            }

            reader.close();
            writer.close();


        } catch (IOException e) {
            System.out.println("BAD!");
        }
    }
}
