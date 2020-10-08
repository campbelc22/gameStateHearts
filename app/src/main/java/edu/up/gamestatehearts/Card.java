/**
 *  Card class
 *  contains information about a card's suit and value
 *  card value should only be between 1 and 13
 *
 * @version October 8, 2020
 * @author  Alex Junkins, Malia Lundstrom, Chloe Campbell, Addison Raak
 */

package edu.up.gamestatehearts;

import android.util.Log;

public class Card {
    //hearts = cups
    //swords = spades
    //coins = clubs
    //wands = diamonds

    public static final int cups = 1;   //hearts
    public static final int swords = 2; //spades
    public static final int coins = 3;  //clubs
    public static final int wands = 4;  //diamonds

    //a card has value and a suit
    int cardVal;
    int cardSuit;

    /**
     * Parameter Constructor
     * returns a new card object initialized with the given values
     * returns a card with value and suit -1 if unsuccessful
     *
     * @param cardVal   a value between 1 and 13
     * @param cardSuit  a value between 1 and 4
     */
    public Card (int cardVal, int cardSuit) {
        //check card validity and suit
        int check = checkCardVals(cardVal, cardSuit);
        if (check < 0) {
            if (check == -1) {
                Log.e("Card", "Tried to initialize a card with a bad value: " + cardVal);
            }
            if (check == -2) {
                Log.e("Card", "Tried to initialize a card with a bad suit: " + cardSuit);
            }
            this.cardVal = -1;
            this.cardSuit = -1;
            return;
        }
        this.cardVal = cardVal;
        this.cardSuit = cardSuit;
    }

    /**
     * Deep-copy Constructor
     * returns a new card object initialized with the values of a given card
     * returns a card with value and suit -1 if the given card is invalid
     *
     * @param oldCard   the card to be deep copied
     */
    public Card (Card oldCard){ //deep copy
        //check card validity and suit
        int check = checkCardVals(oldCard.cardVal, oldCard.cardVal);
        if (check < 0) {
            if (check == -1) {
                Log.e("Card", "Tried to initialize a card with a bad value: " + cardVal);
            }
            if (check == -2) {
                Log.e("Card", "Tried to initialize a card with a bad suit: " + cardSuit);
            }
            this.cardVal = -1;
            this.cardSuit = -1;
            return;
        }
        this.cardVal = oldCard.cardVal;
        this.cardSuit = oldCard.cardSuit;
    }

    /**
     * Invalid card value check
     * a helper method to check if card values are valid
     *
     * @param cardVal   value to test
     * @param cardSuit  suit to test
     * @return          0 if valid, -1 if value is wrong, -2 if suit is wrong, -3 if both are wrong
     */
    private int checkCardVals(int cardVal, int cardSuit){
        int returnMe = 0;
        if (cardVal < 1 || cardVal > 13){
            returnMe--;
        }
        if (cardSuit < 1 || cardSuit > 4){
            returnMe -= 2;
        }
        return returnMe;
    }

    /**
     * getter for a card's suit
     * @return  suit
     */
    public int getCardSuit() {
        return cardSuit;
    }

    /**
     * setter for a card's value
     * @return  value
     */
    public int getCardVal() {
        return cardVal;
    }
}
