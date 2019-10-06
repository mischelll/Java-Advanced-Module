package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class SumBytes extends SumLines {
    public static void main(String[] args) {

        File file = SumLines.input;

        try(FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr)){
            BigInteger big = new BigInteger("0");

            String line = reader.readLine();

            while (line != null){

                for (char c : line.toCharArray()) {
                    big = big.add(BigInteger.valueOf(c));
                }

                line = reader.readLine();
            }

            System.out.println(big);

        }catch (IOException e){
            System.out.println("Bad!");
        }
    }
}
