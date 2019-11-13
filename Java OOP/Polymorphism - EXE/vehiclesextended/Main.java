package javaoopexe.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));

        String[] data2 = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(data2[1]), Double.parseDouble(data2[2]),Double.parseDouble(data2[3]));

        String[] data3 = reader.readLine().split("\\s+");
        Vehicle bus = new Bus(Double.parseDouble(data3[1]), Double.parseDouble(data3[2]),Double.parseDouble(data3[3]));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            if (input[0].equals("Drive")){
                if (input[1].equals("Car")){
                    car.drive(Double.parseDouble(input[2]));
                }else if (input[1].equals("Truck")){
                    truck.drive(Double.parseDouble(input[2]));
                }else {
                    bus.drive(Double.parseDouble(input[2]));
                }

            }else if (input[0].equals("Refuel")){
                if (input[1].equals("Car")){
                    car.refuel(Double.parseDouble(input[2]));
                }else if (input[1].equals("Truck")){
                    truck.refuel(Double.parseDouble(input[2]));
                }else {
                    bus.refuel(Double.parseDouble(input[2]));
                }
            }else {
                bus.driveEmptyBus(Double.parseDouble(input[2]));
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
