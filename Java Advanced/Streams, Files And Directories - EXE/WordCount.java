package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {

        String inputPath = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputPath2 = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "D:\\Stuff\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             BufferedReader reader2 = Files.newBufferedReader(Paths.get(inputPath2));
             PrintWriter writer = new PrintWriter(outputPath)) {

            String[] words = reader.readLine().split("\\s+");
            Map<String, Integer> wordsCount = new HashMap<>();

            for (String word : words) {
                wordsCount.putIfAbsent(word, 0);

            }

            String[] words2 = reader2.readLine().split("\\s+");
            for (String s : words2) {
                if (wordsCount.containsKey(s)) {
                    wordsCount.put(s, wordsCount.get(s) + 1);
                }
            }

            wordsCount
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(x -> {
                        writer.println(x.getKey() + " - " + x.getValue());
                    });


        } catch (IOException e) {
            System.out.println("BAD!");
        }
    }
}
