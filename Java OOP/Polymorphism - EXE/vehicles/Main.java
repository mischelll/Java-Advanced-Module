package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));

        String[] data2 = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(data2[1]), Double.parseDouble(data2[2]));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            if (input[0].equals("Drive")){
                if (input[1].equals("Car")){
                    car.drive(Double.parseDouble(input[2]));
                }else {
                    truck.drive(Double.parseDouble(input[2]));
                }

            }else {
                if (input[1].equals("Car")){
                    car.refuel(Double.parseDouble(input[2]));
                }else {
                    truck.refuel(Double.parseDouble(input[2]));
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
