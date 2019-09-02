package JavaAdvancedLabs;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] files = file.listFiles();

        if (files.length > 0) {

            for (File file1 : files) {
                if (!file1.isDirectory()) {
                    System.out.println(String.format("%s: [%d]", file1.getName(), file1.length()));
                }
            }
        }
    }
}
