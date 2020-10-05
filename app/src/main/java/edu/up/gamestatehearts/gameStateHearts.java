package edu.up.gamestatehearts;

import java.util.ArrayList;

import static edu.up.gamestatehearts.Card.coins;

public class gameStateHearts {

    //instance variables
    int p1numCurrentPoints, p2numCurrentPoints, p3numCurrentPoints, p4numCurrentPoints;
    int p1RunningPoints, p2RunningPoints, p3RunningPoints, p4RunningPoints;

    int numCards;
    ArrayList<Card> p1Hand;
    ArrayList<Card> p2Hand;
    ArrayList<Card> p3Hand;
    ArrayList<Card> p4Hand;
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

        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        p3Hand = new ArrayList<>();
        p4Hand = new ArrayList<>();
    }

    public gameStateHearts(gameStateHearts oldState){ //deep copy gameStateHearts
        p1numCurrentPoints = oldState.p1numCurrentPoints;
        p2numCurrentPoints = oldState.p2numCurrentPoints;
        p3numCurrentPoints = oldState.p3numCurrentPoints;
        p4numCurrentPoints = oldState.p4numCurrentPoints;

        p1RunningPoints = oldState.p1RunningPoints;
        p2RunningPoints = oldState.p2RunningPoints;
        p3RunningPoints = oldState.p3RunningPoints;
        p4RunningPoints = oldState.p4RunningPoints;

        numCards = oldState.numCards;
        heartsBroken = oldState.heartsBroken;
        suitLed = oldState.suitLed;
        tricksPlayed = oldState.tricksPlayed;

        p1Hand = handDeepCopy(oldState.p1Hand);
        p2Hand = handDeepCopy(oldState.p2Hand);
        p3Hand = handDeepCopy(oldState.p3Hand);
        p4Hand = handDeepCopy(oldState.p4Hand);
    }

    private ArrayList<Card> handDeepCopy(ArrayList<Card> oldHand){
        ArrayList<Card> newList = new ArrayList<>();
        for (int i = 0; i < oldHand.size(); i++){
            Card cardToAdd = new Card(oldHand.get(i));
            newList.add(cardToAdd);
        }
        return newList;
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
            cardsPassed++;
            return true;
        }
        return false;
    }

}
