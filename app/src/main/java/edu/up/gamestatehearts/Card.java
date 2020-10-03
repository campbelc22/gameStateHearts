package edu.up.gamestatehearts;

public class Card {
    public static final int cups = 1;
    public static final int swords = 2;
    public static final int coins = 3;
    public static final int wands = 4;

    //a card has value and a suit
    int cardVal;
    int cardSuit;

    public Card (int cardVal, int cardSuit) {
        this.cardVal = cardVal;
        this.cardSuit = cardSuit;
    }

    public int getCardSuit() {
        return cardSuit;
    }

    public int getCardVal() {
        return cardVal;
    }
}
