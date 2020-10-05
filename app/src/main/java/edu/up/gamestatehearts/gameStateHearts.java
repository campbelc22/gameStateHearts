package edu.up.gamestatehearts;

import android.util.Log;
import java.util.*;

import static edu.up.gamestatehearts.Card.coins;

public class gameStateHearts {

    //instance variables
    int p1numCurrentPoints;
    int p2numCurrentPoints;
    int p3numCurrentPoints;
    int p4numCurrentPoints;
    int p1RunningPoints;
    int p2RunningPoints;
    int p3RunningPoints;
    int p4RunningPoints;

    int numCards;
    ArrayList<Card> p1Hand = new ArrayList<>();
    ArrayList<Card> p2Hand = new ArrayList<>();
    ArrayList<Card> p3Hand = new ArrayList<>();
    ArrayList<Card> p4Hand = new ArrayList<>();
    String p1HandString;
    String p2HandString;
    String p3HandString;
    String p4HandString;
    boolean heartsBroken;
    int suitLed;

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
                "Player 1 Current Points: " + p1numCurrentPoints
                + "Player 2 Current Points: " + p2numCurrentPoints
                + "Player 3 Current Points: " + p3numCurrentPoints
                + "Player 4 Current Points: " + p4numCurrentPoints

                //prints the RUNNING score of the players to the Logcat Info window
                + "Player 1 Running Points: " + p1RunningPoints
                + "Player 2 Running Points: " + p2RunningPoints
                + "Player 3 Running Points: " + p3RunningPoints
                + "Player 4 Running Points: " + p4RunningPoints

                //prints numCards
                + "Number of Cards in Hands: " + numCards

                //prints reference for what the suit numbers mean
                + "1 = Cups\n2 = swords\n3 = coins\n4 = wands"

                //prints the hands of each player
                + "Player 1 Hand:\n" + p1HandString + "\n"
                + "Player 2 Hand:\n" + p2HandString + "\n"
                + "Player 3 Hand:\n" + p3HandString + "\n"
                + "Player 4 Hand:\n" + p4HandString;
    }
}
