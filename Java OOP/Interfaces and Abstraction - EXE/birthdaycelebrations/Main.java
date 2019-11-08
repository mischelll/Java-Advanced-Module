package javaoopexe.birthdaycelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        List<Citizen> citizens = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        while (!"End".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");

            switch (data[0]) {
                case "Citizen":
                    citizens.add(new Citizen(data[1],
                            Integer.parseInt(data[2])
                            , data[3]
                            , data[4]));
                    break;
                case "Pet":
                    pets.add(new Pet(data[1], data[2]));
                    break;
                case "Robot":
                    robots.add(new Robot(data[1], data[2]));
                    break;
            }
        }

        String lastDigits = reader.readLine();

        citizens
                .stream()
                .filter(e -> e.getBirthDate().endsWith(lastDigits))
                .forEach(e -> System.out.println(e.getBirthDate()));

        pets
                .stream()
                .filter(e -> e.getBirthDate().endsWith(lastDigits))
                .forEach(e -> System.out.println(e.getBirthDate()));
    }
}
