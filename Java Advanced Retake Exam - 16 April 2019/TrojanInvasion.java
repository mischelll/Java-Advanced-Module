package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfWaves = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> plates = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(plates::offer);

        ArrayDeque<Integer> warriors = new ArrayDeque<>();

        boolean noMorePlates = false;

        for (int i = 1; i <= numberOfWaves; i++) {

            if (plates.isEmpty()) {
                break;
            }

            Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(warriors::push);


            if (i % 3 == 0) {
                int newPlate = Integer.parseInt(reader.readLine());
                plates.offer(newPlate);
            }

            while (!warriors.isEmpty() && !plates.isEmpty()) {
                int warrior = warriors.pop();
                int plate = plates.poll();

                if (plate > warrior) {
                    plate -= warrior;
                    plates.addFirst(plate);
                } else if (plate < warrior) {
                    warrior -= plate;
                    warriors.push(warrior);
                }
            }

        }


        if (plates.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            List<String> toList = warriors.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.printf("Warriors left: %s%n", String.join(", ", warriors.toString()).replaceAll("\\[|\\]",""));
        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            List<String> toList = plates.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.printf("Plates left: %s%n", String.join(", ", plates.toString()).replaceAll("\\[|\\]",""));
        }

    }
}
