package JavaAdvancedExe.genericMethodCountDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Double> list = new ArrayList<>();
        while (n-- > 0){
            Double number = Double.parseDouble(reader.readLine());
            list.add(number);
        }

        double element = Double.parseDouble(reader.readLine());
        Box<Double> doubleBox = new Box<>(list);
        System.out.println(doubleBox.getCount(list,element));
    }
}
