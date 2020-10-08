package edu.up.gamestatehearts;


import java.util.ArrayList;

public class heartsLocalGame {

    private gameStateHearts state;

    public heartsLocalGame() {
        state = new gameStateHearts();
    }


    boolean quit() {
        //you can always quit!!
        return true;
    }

    boolean isInSuit (Card card) {
        int suit = card.getCardSuit();
        if (state.getSuitLed() == suit) {
            return true;
        }
        return false;
    }

    ArrayList<Card> CardsInSuit() {
        ArrayList<Card> cardsInSuit = new ArrayList<>();
        if(isInSuit(state.getSelectedCard())) {
            cardsInSuit.add(state.getP1CardPlayed());
        }
        if(isInSuit(state.getP2CardPlayed())) {
            cardsInSuit.add(state.getP2CardPlayed());
        }
        if(isInSuit(state.getP3CardPlayed())) {
            cardsInSuit.add(state.getP3CardPlayed());
        }
        if(isInSuit(state.getP4CardPlayed())) {
            cardsInSuit.add(state.getP4CardPlayed());
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
        if(state.getWhoTurn() == 1) {
            state.setSelectedCard(card);
            return true;
        }
        else { return false; }
    }

    boolean playCard() {
        if(state.whoTurn == 1) {
            state.cardsPlayed.add(state.selectedCard);
            return true;
        }
        return false;
    }

    boolean passCard(){
        if(state.cardsPassed < 4 && state.whoTurn == 1 && state.tricksPlayed == 0) {
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
        for(Card tempCard : state.getP1Hand()) {
            state.setP1HandString("Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n");
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
