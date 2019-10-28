package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());
        List<String> input = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> halls = new ArrayDeque<>(); //queue
        List<Integer> currentReservations = new LinkedList<>();

        Collections.reverse(input);

        for (int i = 0; i < input.size(); i++) {
            String current = input.get(i);

            if (Character.isDigit(current.charAt(0))) {
                if (!halls.isEmpty()) {
                    int reservation = Integer.parseInt(current);
                    if (!(reservation > capacity)) {
                        int sum = currentReservations.stream().mapToInt(x -> x).sum();
                        if (sum + reservation > capacity){
                            printHall(halls.poll(),currentReservations);
                            currentReservations.clear();
                            i--;
                        }else {
                            currentReservations.add(reservation);
                        }
                    }
                }
            } else {
                halls.offer(current);
            }

        }

    }

    static void printHall(String str, List<Integer> list) {
        System.out.printf("%s -> %s%n", str,
                String.join(", ", list.stream().map(String::valueOf).collect(Collectors.toList())));

    }
}
