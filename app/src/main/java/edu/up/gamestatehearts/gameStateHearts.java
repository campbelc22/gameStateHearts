package edu.up.gamestatehearts;

import android.util.Log;
import java.util.*;

import static edu.up.gamestatehearts.Card.coins;

public class gameStateHearts {

    //instance variables
    int p1numCurrentPoints, p2numCurrentPoints, p3numCurrentPoints, p4numCurrentPoints;
    int p1RunningPoints, p2RunningPoints, p3RunningPoints, p4RunningPoints;

    int numCards;
    Card selectedCard;

    String p1HandString;
    String p2HandString;
    String p3HandString;
    String p4HandString;
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
//Can this be automatic?
   /* boolean collectTrick () {
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
    }*/
    boolean selectCard(Card card) {
        if(whoTurn == 1) {
            selectedCard= new Card(card);
            //add code to insert card into variable that we can use in playCard
            //add code to highlight/make card bigger or whatever we decide
            return true;
        }
        else { return false; }
    }
    boolean playCard() {
        if(whoTurn == 1) {
            //add code to check if card is a valid play, ex. correct suit
            //check to see if selectedCard is not null
            //play selectedCard
            return true;
        }
        return false;
    }
    boolean passCard(){
        if(cardsPassed <4 && whoTurn == 1 &&tricksPlayed ==0) {
            //check to see if selectedCard is not null
            //pass selectedCard
            return true;
        }
        return false;
    }

    /**
     * this method prints the values of all of the variables in the game state by saving them all
     *  to a String.
     */
    @Override
    public String toString() {

        //sets the ArrayList to a String to be returned with the rest of the info
        for(Card tempCard : p1Hand) {
            p1HandString = "Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n";
        }

        for(Card tempCard : p2Hand) {
            p2HandString = "Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n";
        }

        for(Card tempCard : p3Hand) {
            p3HandString = "Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n";
        }

        for(Card tempCard : p4Hand) {
            p4HandString = "Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n";
        }


        return //prints the CURRENT score of the players to the Logcat Info window
                "Player 1 Current Points: " + p1numCurrentPoints + "\n"
                        + "Player 2 Current Points: " + p2numCurrentPoints + "\n"
                        + "Player 3 Current Points: " + p3numCurrentPoints + "\n"
                        + "Player 4 Current Points: " + p4numCurrentPoints + "\n"

                        //prints the RUNNING score of the players to the Logcat Info window
                        + "Player 1 Running Points: " + p1RunningPoints + "\n"
                        + "Player 2 Running Points: " + p2RunningPoints + "\n"
                        + "Player 3 Running Points: " + p3RunningPoints + "\n"
                        + "Player 4 Running Points: " + p4RunningPoints + "\n"

                        //prints numCards
                        + "Number of Cards in Hands: " + numCards + "\n"

                        //prints reference for what the suit numbers mean
                        + "1 = Cups\n2 = swords\n3 = coins\n4 = wands" + "\n"

                        //prints the hands of each player
                        + "Player 1 Hand:\n" + p1HandString + "\n"
                        + "Player 2 Hand:\n" + p2HandString + "\n"
                        + "Player 3 Hand:\n" + p3HandString + "\n"
                        + "Player 4 Hand:\n" + p4HandString + "\n" + " \n";
    }
}
