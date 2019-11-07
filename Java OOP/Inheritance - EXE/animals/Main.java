package javaoopexe.animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        List<Animal> animals = new ArrayList<>();
        while (!"Beast!".equals(command = reader.readLine())) {
            String[] data = reader.readLine().split("\\s+");

            try {
            String name = data[0];
            if (name.isEmpty()){
                throw new IllegalArgumentException("Invalid input!");
            }
            int age = Integer.parseInt(data[1]);
            if (age <= 0 || String.valueOf(age).isEmpty()){
                throw new IllegalArgumentException("Invalid input!");
            }
            if (data[2].isEmpty()){
                throw new IllegalArgumentException("Invalid input!");
            }
            String gender = "";

            Animal animal = null;

                switch (command) {
                    case "Dog":
                        gender = data[2];
                        animal = new Dog(name, age, gender);
                        break;
                    case "Cat":
                        gender = data[2];
                        animal = new Cat(name, age, gender);
                        break;
                    case "Frog":
                        gender = data[2];
                        animal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name,age);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name,age);
                        break;
                }
                animals.add(animal);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

    }
}
