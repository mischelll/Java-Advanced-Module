package softUniParking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new LinkedHashMap<>();
    }

    public String addCar(Car car){
        if (this.cars.containsKey(car.getRegistrationNumber())){
            return "Car with that registration number, already exists!";
        }else if (this.cars.size() >= this.capacity){
            return "Parking is full!";
        }else {
            this.cars.put(car.getRegistrationNumber(),car);
            return "Successfully added new car " + car.getMake() + " " + car.getRegistrationNumber();
        }
    }

    public String removeCar(String regNumber){
        if (this.cars.containsKey(regNumber)){
            this.cars.remove(regNumber);
            return "Successfully removed " + regNumber;
        }
        return "Car with that registration number, doesn't exists!";
    }

    public Car getCar(String regNumber){
        return this.cars.get(regNumber);
    }

    public void removeSetOfRegistrationNumber(List<String> regNumbers){
        for (String regNumber : regNumbers) {
            removeCar(regNumber);
        }
    }

    public int getCount(){
        return this.cars.size();
    }
}
