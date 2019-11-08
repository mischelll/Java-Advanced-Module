package javaooplabs.bordercontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Citizen> citizens = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        String command = "";
        while (!"End".equals(command = reader.readLine())) {
            String[] data = command.split("\\s+");

            if (data.length == 3) {
                citizens.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2]));

            } else {
                robots.add(new Robot(data[0], data[1]));
            }
        }

        String lastDigits = reader.readLine();

        citizens
                .stream()
                .filter(e -> e.getId().endsWith(lastDigits))
                .forEach(e -> System.out.println(e.getId()));

        robots
                .stream()
                .filter(e -> e.getId().endsWith(lastDigits))
                .forEach(e -> System.out.println(e.getId()));


    }


}
