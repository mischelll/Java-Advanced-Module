package JavaAdvancedExe.tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] data = reader.readLine().split("\\s+");

            if (i == 0) {
                String name = reader.readLine();
                String address = reader.readLine();
                String town = reader.readLine();
                Tuple<String, String, String> stringStringTuple = new Tuple<>(name, address, town);
                System.out.println(stringStringTuple.toString());
            } else if (i == 1) {
                String name = reader.readLine();
                int liters = Integer.parseInt(reader.readLine());
                String text = data[2];
                boolean bool = false;
                if (text.equals("drunk")) {
                    bool = true;
                }
                Tuple<String, Integer, Boolean> stringIntegerTuple = new Tuple<>(name, liters, bool);
                System.out.println(stringIntegerTuple.toString());
            } else {
                String name = data[0];
                double number2 = Double.parseDouble(data[1]);
                String bankName = data[2];
                Tuple<String, Double, String> integerDoubleTuple = new Tuple<>(name, number2, bankName);
                System.out.println(integerDoubleTuple.toString());
            }
        }
    }
}
