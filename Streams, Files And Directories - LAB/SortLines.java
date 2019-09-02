package JavaAdvancedLabs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {

        Path pathIn = Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathOut = Paths.get("C:\\Users\\User\\eclipse-workspace\\SoftUni\\rec\\output.txt");

        List<String> strings = Files.readAllLines(pathIn)
                .parallelStream()
                .filter(e -> !e.isEmpty())
                .sorted()
                .collect(Collectors.toList());

        Files.write(pathOut,strings);
    }
}
