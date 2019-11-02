package javaoopexe.cardsWithPower;

import javaoopexe.cardsWithPower.enums.CardRank;
import javaoopexe.cardsWithPower.enums.CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank = reader.readLine();
        String suitPower = reader.readLine();

        CardRank rank1 = CardRank.valueOf(rank);
        CardSuit suit = CardSuit.valueOf(suitPower);

        Card card = new Card(rank1, suit);

        System.out.println(card.toString());
    }
}
