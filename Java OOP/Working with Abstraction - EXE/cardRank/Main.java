package javaoopexe.cardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public enum Card {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        System.out.println("Card Ranks:");
        for (Card value : Card.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.toString());
        }
    }
}
