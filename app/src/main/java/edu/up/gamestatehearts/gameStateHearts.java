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
    int whoTurn;
    int tricksPlayed;

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
    }
    boolean quit() {
        //you can always quit!!
        return true;
    }
    boolean collectTrick () {
        //if suit of card played == suitLed
        return true;
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
        return false;
    }
}
