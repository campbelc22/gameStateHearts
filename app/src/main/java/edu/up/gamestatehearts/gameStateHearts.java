package edu.up.gamestatehearts;

import java.util.ArrayList;

import static edu.up.gamestatehearts.Card.coins;

public class gameStateHearts {

    //instance variables
    int p1numCurrentPoints, p2numCurrentPoints, p3numCurrentPoints, p4numCurrentPoints;
    int p1RunningPoints, p2RunningPoints, p3RunningPoints, p4RunningPoints;

    int numCards;
    ArrayList<Card> p1Hand = new ArrayList<>();
    ArrayList<Card> p2Hand = new ArrayList<>();
    ArrayList<Card> p3Hand = new ArrayList<>();
    ArrayList<Card> p4Hand = new ArrayList<>();
    boolean heartsBroken;
    int suitLed;
    int whoTurn;
    int tricksPlayed;
    int cardsPassed;

    Card p1CardPlayed, p2CardPlayed, p3CardPlayed, p4CardPlayed;

    public gameStateHearts() {
        p1numCurrentPoints = 0;
        p2numCurrentPoints = 0;
        p3numCurrentPoints = 0;
        p4numCurrentPoints = 0;

        p1RunningPoints = 0;
        p2RunningPoints = 0;
        p3RunningPoints = 0;
        p4RunningPoints = 0;

        numCards = 13;
        heartsBroken = false;
        suitLed = coins;
        tricksPlayed = 0;
        cardsPassed=0;
    }
    boolean quit() {
        //you can always quit!!
        return true;
    }
    boolean isInSuit (Card card) {
        int suit = card.getCardSuit();
        if (suitLed == suit) {
            return true;
        }
        return false;
    }

    ArrayList<Card> CardsInSuit() {
        ArrayList<Card> cardsInSuit = new ArrayList<>();
        if(isInSuit(p1CardPlayed)) {
            cardsInSuit.add(p1CardPlayed);
        }
        if(isInSuit(p2CardPlayed)) {
            cardsInSuit.add(p2CardPlayed);
        }
        if(isInSuit(p3CardPlayed)) {
            cardsInSuit.add(p3CardPlayed);
        }
        if(isInSuit(p4CardPlayed)) {
            cardsInSuit.add(p4CardPlayed);
        }
        return cardsInSuit;
    }

    boolean collectTrick () {
        //if suit of card played == suitLed
        int highVal=0;
        Card highCard = new Card(0, suitLed);
        for (Card card : CardsInSuit()) {
            if (highVal > card.getCardVal()) {
                highCard = card;
            }
        }
        if(highCard == p1CardPlayed){
            return true;
        }
        return false;
    }
    boolean selectCard() {
        if(whoTurn == 1) {
            return true;
        }
        else { return false; }
    }
    boolean playCard() {
        if(selectCard()) {
            return true;
        }
        return false;
    }
    boolean passCard(){
        if(cardsPassed <4 && selectCard() &&tricksPlayed ==0) {
            return true;
        }
        return false;
    }
}
