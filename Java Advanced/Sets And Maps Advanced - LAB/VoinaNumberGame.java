package JavaAdvancedLabs;

import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Integer> firstPlayer = getPlayerNumbers(in.nextLine());


                Set < Integer > secondPlayer = getPlayerNumbers(in.nextLine());

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            Iterator<Integer> firstPlayerCard = firstPlayer.iterator();
            Iterator<Integer> secondPlayerCard = secondPlayer.iterator();

            int topCard1 = firstPlayerCard.next();
            firstPlayer.remove(topCard1);
            int topCard2 = secondPlayerCard.next();
            secondPlayer.remove(topCard2);

            if (topCard1 > topCard2) {
                firstPlayer.add(topCard1);
                firstPlayer.add(topCard2);

            } else if (topCard2 > topCard1) {
                secondPlayer.add(topCard1);
                secondPlayer.add(topCard2);

            } else {
                firstPlayer.add(topCard1);
                secondPlayer.add(topCard2);

            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    static LinkedHashSet<Integer> getPlayerNumbers(String input) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(result::add);


        return result;
    }
}
