package JavaAdvancedExe.speedracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        List<Car> cars = new LinkedList<>();
        while (N-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Integer.parseInt(data[1]);
            double fuelCostPerKm = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.add(car);
        }

        String command = "";
        while (!"End".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            String model = data[1];
            double amountOfKm = Integer.parseInt(data[2]);

            for (Car car : cars) {
                if (model.equals(car.getModel())){
                    if (car.drive(amountOfKm)){
                        car.setFuelAmount(amountOfKm);
                        car.addDistance(amountOfKm);
                    }else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            }

        }

        cars.forEach(e -> System.out.print(e.toString()));

    }
}

