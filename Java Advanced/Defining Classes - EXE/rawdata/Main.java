package JavaAdvancedExe.rawdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        List<Car> carList = new LinkedList<>();
        while (N-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            carList.add(createCar(data));

        }

        String type = reader.readLine();
        Set<String> modelList = checkType(type,carList);
        modelList.forEach(System.out::println);

    }

    static Car createCar(String[] data) {
        String model = data[0];
        int engineSpeed = Integer.parseInt(data[1]);
        int enginePower = Integer.parseInt(data[2]);
        int cargoWeight = Integer.parseInt(data[3]);
        String cargoType = data[4];

        List<Tire> tireList = new LinkedList<>();
        int index1 = 5;
        int index2 = 6;
        for (int i = 0; i < Car.TIRES_COUNT; i++) {
            double tirePressure = Double.parseDouble(data[index1]);
            int tireAge = Integer.parseInt(data[index2]);

            Tire tire = new Tire(tirePressure, tireAge);
            tireList.add(tire);

            index1+=2;
            index2+=2;
        }

        Car car =
                new Car(model,
                        new Engine(engineSpeed, enginePower),
                        new Cargo(cargoWeight, cargoType),
                        tireList);

        return car;
    }

    static Set<String> checkType(String type, List<Car> carList){
        if (type.equals("fragile")){
            Set<String> modelList = new LinkedHashSet<>();
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals(type)){
                    for (Tire tire : car.getTires()) {
                        if (tire.getTirePressure() < 1){
                            modelList.add(car.getModel());
                        }
                    }
                }
            }
            return modelList;
        }else {
            Set<String> modelList = new LinkedHashSet<>();
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals(type) && car.getEngine().getEnginePower() > 250){
                    modelList.add(car.getModel());
                }
            }

            return modelList;
        }
    }
}
