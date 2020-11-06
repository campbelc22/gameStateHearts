package edu.up.gamestatehearts.TESt;

import org.junit.Test;

import java.util.ArrayList;

import edu.up.gamestatehearts.Card;
import edu.up.gamestatehearts.gameStateHearts;
import edu.up.gamestatehearts.heartsLocalGame;

import static org.junit.Assert.*;

public class heartsLocalGameTest {

    heartsLocalGame hlg= new heartsLocalGame();

    @Test
    public void quit() {
        assertTrue(hlg.quit());
    }

    @Test
    public void isInSuit() {
        Card card1 = new Card(1,1);
        Card card2 = new Card(2, 1);
        hlg.state.setSuitLed(card1.getCardSuit());
        assertTrue(hlg.isInSuit(card2));
    }

    @Test
    public void cardsInSuit() {
        Card card1 = new Card(1,1);
        Card card2 = new Card(2,2);
        Card card3 = new Card(3,3);
        Card card4 = new Card(4,4);
        hlg.state.setSuitLed(1);
        hlg.state.setSelectedCard(card1);
        hlg.state.setP1CardPlayed(card1);
        hlg.state.setP2CardPlayed(card2);
        hlg.state.setP3CardPlayed(card3);
        hlg.state.setP4CardPlayed(card4);
        assertTrue(hlg.cardsInSuit().size() == 1);
    }

    @Test
    public void selectCard() {
        Card card1 = new Card(1,1);
        hlg.state.setWhoTurn(1);
        assertTrue(hlg.selectCard(card1));
    }

    @Test
    public void isCardValid() {
        ArrayList <Card> hand = new ArrayList<>();
        Card card1 = new Card(1,1);
        Card card2 = new Card(2, 1);
        hand.add(card1);
        hlg.state.setSuitLed(card2.getCardSuit());
        assertTrue(hlg.isCardValid(hand, card1));
    }

    @Test
    public void playCard() {
        hlg.state.setWhoTurn(1);
        ArrayList <Card> hand = new ArrayList<>();
        Card card1 = new Card(1,1);
        Card card2 = new Card(2, 1);
        hand.add(card1);
        hlg.state.setSuitLed(card2.getCardSuit());
        hlg.state.setP1Hand(hand);
        hlg.state.setSelectedCard(card1);
        assertTrue(hlg.playCard());
    }

    @Test
    public void passCard() {
    }

    @Test
    public void testToString() {
    }
}