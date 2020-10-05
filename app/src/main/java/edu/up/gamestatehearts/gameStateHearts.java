package edu.up.gamestatehearts;

import java.util.ArrayList;

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

}
