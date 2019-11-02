package javaoopexe.cardSuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public enum Card {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES,

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        System.out.println("Card Suits:");

        for (Card value : Card.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.toString());
        }

    }
}
