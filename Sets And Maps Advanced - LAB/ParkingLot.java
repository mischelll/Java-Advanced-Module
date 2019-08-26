package JavaAdvancedLabs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<String> cars = new HashSet<>();
        String input;

        while (!"END".equals(input = in.nextLine())) {
            String[] data = input.split(", ");

            String command = data[0];
            String regNumber = data[1];

            if (command.equals("IN")) {
                cars.add(regNumber);
            } else {
                if (cars.contains(regNumber)) {
                    cars.remove(regNumber);
                }
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {

            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
