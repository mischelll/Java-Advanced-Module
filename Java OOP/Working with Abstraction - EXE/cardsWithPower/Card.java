package javaoopexe.cardsWithPower;

import javaoopexe.cardsWithPower.enums.CardRank;
import javaoopexe.cardsWithPower.enums.CardSuit;

public class Card {
    private CardRank rank;
    private CardSuit suitPower;

    public Card(CardRank rank, CardSuit suitPower) {
        this.rank = rank;
        this.suitPower = suitPower;
    }

    public int calculatePower() {
        return this.rank.getValue() + this.suitPower.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.toString(),
                this.suitPower.toString(),
                calculatePower());
    }
}
