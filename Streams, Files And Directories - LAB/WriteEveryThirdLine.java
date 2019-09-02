package JavaAdvancedLabs;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String toPath = "C:\\Users\\User\\eclipse-workspace\\SoftUni\\rec\\output.txt";

        int position = 1;

        try (BufferedReader bfr = new BufferedReader(new FileReader(path));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(toPath))) {

            String line = "";
            while ((line = bfr.readLine()) != null) {

                if (position % 3 == 0) {
                    bfw.write(line);
                    bfw.newLine();
                }
                position++;


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
