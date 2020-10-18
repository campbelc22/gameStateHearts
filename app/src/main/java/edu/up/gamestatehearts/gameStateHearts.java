/**
 * GameStateHearts class
 * contains all information for the Hearts (Chalice) game state
 *
 * @version October 8, 2020
 * @author  Alex Junkins, Malia Lundstrom, Chloe Campbell, Addison Raak
 */
package edu.up.gamestatehearts;

import java.util.*;
import static edu.up.gamestatehearts.Card.coins;

public class gameStateHearts {

    //instance variables
    private int p1numCurrentPoints, p2numCurrentPoints, p3numCurrentPoints, p4numCurrentPoints;
    private int p1RunningPoints, p2RunningPoints, p3RunningPoints, p4RunningPoints;

    private int numCards;
    private Card selectedCard;

    private String p1HandString;
    private String p2HandString;
    private String p3HandString;
    private String p4HandString;
    private ArrayList<Card> p1Hand;
    private ArrayList<Card> p2Hand;
    private ArrayList<Card> p3Hand;
    private ArrayList<Card> p4Hand;
    private ArrayList<Card> cardsPlayed;

    private boolean heartsBroken;
    private int suitLed;
    private int whoTurn;
    private int tricksPlayed;
    private int cardsPassed;

    private Card p1CardPlayed, p2CardPlayed, p3CardPlayed, p4CardPlayed;

    /**
     * Empty Constructor
     * Initializes a game state with default values in its
     */
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
        cardsPassed = 0;

        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
        p3Hand = new ArrayList<>();
        p4Hand = new ArrayList<>();
        cardsPlayed = new ArrayList<>();
    }

    /**
     * Deep Copy Constructor
     * creates and returns a new game state with all the attributes
     * of a provided state
     *
     * @param oldState  the state to be copied
     */
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
        cardsPlayed= handDeepCopy(oldState.cardsPlayed);
    }

    /**
     * a helper method to deep-copy a hand
     * @param oldHand   the hand to be copied
     * @return          the new hand
     */
    private ArrayList<Card> handDeepCopy(ArrayList<Card> oldHand){
        ArrayList<Card> newList = new ArrayList<>();
        for (int i = 0; i < oldHand.size(); i++){
            Card cardToAdd = new Card(oldHand.get(i));
            newList.add(cardToAdd);
        }
        return newList;
    }


    /** Setters for instance variables **/
    public int getP1numCurrentPoints() {
        return p1numCurrentPoints;
    }

    public int getP2numCurrentPoints() {
        return p2numCurrentPoints;
    }

    public int getP3numCurrentPoints() {
        return p3numCurrentPoints;
    }

    public int getP4numCurrentPoints() {
        return p4numCurrentPoints;
    }

    public int getP1RunningPoints() {
        return p1RunningPoints;
    }

    public int getP2RunningPoints() {
        return p2RunningPoints;
    }

    public int getP3RunningPoints() {
        return p3RunningPoints;
    }

    public int getP4RunningPoints() {
        return p4RunningPoints;
    }

    public int getNumCards() {
        return numCards;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public String getP1HandString() {
        return p1HandString;
    }

    public String getP2HandString() {
        return p2HandString;
    }

    public String getP3HandString() {
        return p3HandString;
    }

    public String getP4HandString() {
        return p4HandString;
    }

    public ArrayList<Card> getP1Hand() {
        return p1Hand;
    }

    public ArrayList<Card> getP2Hand() {
        return p2Hand;
    }

    public ArrayList<Card> getP3Hand() {
        return p3Hand;
    }

    public ArrayList<Card> getP4Hand() {
        return p4Hand;
    }

    public ArrayList<Card> getCardsPlayed() {
        return cardsPlayed;
    }

    public boolean isHeartsBroken() {
        return heartsBroken;
    }

    public int getSuitLed() {
        return suitLed;
    }

    public int getWhoTurn() {
        return whoTurn;
    }

    public int getTricksPlayed() {
        return tricksPlayed;
    }

    public int getCardsPassed() {
        return cardsPassed;
    }

    public Card getP1CardPlayed() {
        return p1CardPlayed;
    }

    public Card getP2CardPlayed() {
        return p2CardPlayed;
    }

    public Card getP3CardPlayed() {
        return p3CardPlayed;
    }
    public Card getP4CardPlayed() {
        return p4CardPlayed;
    }

    /**Setters for instance variables**/
    public void setP1numCurrentPoints(int p1numCurrentPoints) {
        this.p1numCurrentPoints = p1numCurrentPoints;
    }

    public void setP2numCurrentPoints(int p2numCurrentPoints) {
        this.p2numCurrentPoints = p2numCurrentPoints;
    }

    public void setP3numCurrentPoints(int p3numCurrentPoints) {
        this.p3numCurrentPoints = p3numCurrentPoints;
    }

    public void setP4numCurrentPoints(int p4numCurrentPoints) {
        this.p4numCurrentPoints = p4numCurrentPoints;
    }

    public void setP1RunningPoints(int p1RunningPoints) {
        this.p1RunningPoints = p1RunningPoints;
    }

    public void setP2RunningPoints(int p2RunningPoints) {
        this.p2RunningPoints = p2RunningPoints;
    }

    public void setP3RunningPoints(int p3RunningPoints) {
        this.p3RunningPoints = p3RunningPoints;
    }

    public void setP4RunningPoints(int p4RunningPoints) {
        this.p4RunningPoints = p4RunningPoints;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public void setP1HandString(String p1HandString) {
        this.p1HandString = p1HandString;
    }

    public void setP2HandString(String p2HandString) {
        this.p2HandString = p2HandString;
    }

    public void setP3HandString(String p3HandString) {
        this.p3HandString = p3HandString;
    }

    public void setP4HandString(String p4HandString) {
        this.p4HandString = p4HandString;
    }

    public void setP1Hand(ArrayList<Card> p1Hand) {
        this.p1Hand = p1Hand;
    }

    public void setP2Hand(ArrayList<Card> p2Hand) {
        this.p2Hand = p2Hand;
    }

    public void setP3Hand(ArrayList<Card> p3Hand) {
        this.p3Hand = p3Hand;
    }

    public void setP4Hand(ArrayList<Card> p4Hand) {
        this.p4Hand = p4Hand;
    }

    public void setCardsPlayed(ArrayList<Card> cardsPlayed) {
        this.cardsPlayed = cardsPlayed;
    }

    public void setHeartsBroken(boolean heartsBroken) {
        this.heartsBroken = heartsBroken;
    }

    public void setSuitLed(int suitLed) {
        this.suitLed = suitLed;
    }

    public void setWhoTurn(int whoTurn) {
        this.whoTurn = whoTurn;
    }

    public void setTricksPlayed(int tricksPlayed) {
        this.tricksPlayed = tricksPlayed;
    }

    public void setCardsPassed(int cardsPassed) {
        this.cardsPassed = cardsPassed;
    }

    public void setP1CardPlayed(Card p1CardPlayed) {
        this.p1CardPlayed = p1CardPlayed;
    }

    public void setP2CardPlayed(Card p2CardPlayed) {
        this.p2CardPlayed = p2CardPlayed;
    }

    public void setP3CardPlayed(Card p3CardPlayed) {
        this.p3CardPlayed = p3CardPlayed;
    }

    public void setP4CardPlayed(Card p4CardPlayed) {
        this.p4CardPlayed = p4CardPlayed;
    }
} // gameStateHearts