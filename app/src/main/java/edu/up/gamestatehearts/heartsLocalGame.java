package edu.up.gamestatehearts;


import java.util.ArrayList;

public class heartsLocalGame {

    private gameStateHearts state;

    public heartsLocalGame() {
        state = new gameStateHearts();
    }

    public heartsLocalGame(heartsLocalGame localGame) {
        state = new gameStateHearts(localGame.state);
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
        if(state.getWhoTurn() == 1) {
            state.getCardsPlayed().add(state.getSelectedCard());
            return true;
        }
        return false;
    }

    boolean passCard(){
        if(state.getCardsPassed() < 4 && state.getWhoTurn() == 1 && state.getTricksPlayed() == 0) {
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

        for(Card tempCard : state.getP2Hand()) {
            state.setP2HandString("Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n");
        }

        for(Card tempCard : state.getP3Hand()) {
            state.setP3HandString("Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n");
        }

        for(Card tempCard : state.getP4Hand()) {
            state.setP4HandString("Suit: " + tempCard.cardSuit + "\tValue: " + tempCard.cardVal + "\n");
        }


        return //prints the CURRENT score of the players to the Logcat Info window
                "Player 1 Current Points: " + state.getP1numCurrentPoints() + "\n"
                        + "Player 2 Current Points: " + state.getP2numCurrentPoints() + "\n"
                        + "Player 3 Current Points: " + state.getP3numCurrentPoints() + "\n"
                        + "Player 4 Current Points: " + state.getP4numCurrentPoints() + "\n"

                        //prints the RUNNING score of the players to the Logcat Info window
                        + "Player 1 Running Points: " + state.getP1RunningPoints() + "\n"
                        + "Player 2 Running Points: " + state.getP2RunningPoints() + "\n"
                        + "Player 3 Running Points: " + state.getP3RunningPoints() + "\n"
                        + "Player 4 Running Points: " + state.getP4RunningPoints() + "\n"

                        //prints numCards
                        + "Number of Cards in Hands: " + state.getNumCards() + "\n"

                        //prints reference for what the suit numbers mean
                        + "1 = Cups\n2 = swords\n3 = coins\n4 = wands" + "\n"

                        //prints the hands of each player
                        + "Player 1 Hand:\n" + state.getP1HandString() + "\n"
                        + "Player 2 Hand:\n" + state.getP2HandString() + "\n"
                        + "Player 3 Hand:\n" + state.getP3HandString() + "\n"
                        + "Player 4 Hand:\n" + state.getP4HandString() + "\n" + " \n";
    }
}
