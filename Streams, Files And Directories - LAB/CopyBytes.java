package JavaAdvancedLabs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String toPath = "C:\\Users\\User\\eclipse-workspace\\SoftUni\\rec\\output.txt";

        try (FileInputStream fis = new FileInputStream(path);
             FileOutputStream fos = new FileOutputStream(toPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10){
                    fos.write(oneByte);
                }else {
                    String word = String.valueOf(oneByte);
                    for (int i = 0; i < word.length(); i++) {
                        fos.write(word.charAt(i));
                    }
                }


                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
