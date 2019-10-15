package JavaAdvancedLabs.opinionpoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        List<Person> people = new LinkedList<>();

        while (N-- > 0){
            String[] data = reader.readLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(e -> System.out.printf("%s - %d%n",e.getName(),e.getAge()));
    }
}
