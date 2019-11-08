package javaooplabs.firstandreserveteam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            try {
                String[] data = reader.readLine().split("\\s+");
                String fName = data[0];
                String lName = data[1];
                int age = Integer.parseInt(data[2]);
                double salary = Double.parseDouble(data[3]);

                people.add(new Person(fName, lName, age, salary));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        Team team = new Team("Black Eagles");

        for (Person person : people) {
            team.addPlayer(person);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}

