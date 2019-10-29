package JavaAdvancedLabs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
         String path = "C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
         String toPath = "C:\\Users\\User\\eclipse-workspace\\SoftUni\\rec\\output.txt";

        try(FileInputStream fis = new FileInputStream(path);
            FileOutputStream fos = new FileOutputStream(toPath)){
            int oneByte = fis.read();


            while (oneByte >= 0){
                if (oneByte != '.' && oneByte != ',' && oneByte != '?' && oneByte != '!'){
                    fos.write(oneByte);
                }

                oneByte = fis.read();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
