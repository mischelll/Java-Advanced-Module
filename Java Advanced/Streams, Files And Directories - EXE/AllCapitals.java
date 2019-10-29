package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals extends  SumLines {
    public static void main(String[] args) {

        File file = SumLines.input;
        File outputFile = new File("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt");

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile.getAbsolutePath()))) {

            String line = reader.readLine();
            while (line != null){
                writer.write(line.toUpperCase());
                writer.newLine();

                line = reader.readLine();
            }

        }catch (IOException e){
            System.out.println("Bad!");
        }
    }
}
