package JavaAdvancedLabs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String toPath = "C:\\Users\\User\\eclipse-workspace\\SoftUni\\rec\\output.txt";

        try (Scanner scanner = new Scanner(new FileReader(path))) {
            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {

                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
