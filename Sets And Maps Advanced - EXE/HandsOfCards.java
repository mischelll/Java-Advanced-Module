package JavaAdvancedExe;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> playerPoints = new LinkedHashMap<>();
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();


        String command;
        while (!"JOKER".equals(command = in.nextLine())) {
            String[] input = command.split(": ");

            String name = input[0];

            List<String> cardsType = Arrays.stream(input[1].split(", "))
                    .collect(Collectors.toList());

            Set<String> checkCards = new LinkedHashSet<>();
            checkCards.addAll(cardsType);

            playerCards.putIfAbsent(name, new LinkedHashSet<>());

            checkCards.removeIf(e -> playerCards.get(name).contains(e));
            playerCards.get(name).addAll(cardsType);


            int points = 0;
            if (checkCards.size() == 0) {
                points = sumPoints(playerCards.get(name));
            } else {
                points = sumPoints(checkCards);
            }

            playerPoints.putIfAbsent(name, 0);
            playerPoints.put(name, playerPoints.get(name) + points);


        }

        playerPoints.entrySet().stream().forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));

    }

    static int sumPoints(Set<String> cards) {
        int sum = 0;
        int digit = 0;
        for (String card : cards) {
            char[] arr = card.toCharArray();
            if (arr.length == 3) {
                char type = arr[2];
                sum += checkSignGetPoints(type, 10);
            } else {


                if (!Character.isDigit(arr[0])) {
                    if (arr[0] == 'J') {
                        digit = 11;
                    } else if (arr[0] == 'Q') {
                        digit = 12;
                    } else if (arr[0] == 'K') {
                        digit = 13;
                    } else if (arr[0] == 'A') {
                        digit = 14;
                    }

                } else {
                    digit = arr[0] - '0';
                }
                char type = arr[1];
                sum += checkSignGetPoints(type, digit);
            }


        }


        return sum;
    }

    static int checkSignGetPoints(char sign, int digit) {

        if (sign == 'S') {
            digit *= 4;
        } else if (sign == 'H') {
            digit *= 3;
        } else if (sign == 'D') {
            digit *= 2;
        } else if (sign == 'C') {
            digit *= 1;
        }

        return digit;
    }
}
