package JavaAdvancedExe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {

        Path folder = Paths.get("D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

            long size = Files.walk(folder)
                    .filter(e -> e.toFile().isFile())
                    .mapToLong(e -> e.toFile().length())
                    .sum();

        System.out.println("Folder size: " + size);

    }
}
