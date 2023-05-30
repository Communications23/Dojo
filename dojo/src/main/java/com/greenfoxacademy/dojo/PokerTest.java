package com.greenfoxacademy.dojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerTest {
    Card card1;
    Card card2;
    Poker poker1;
    Player player;

    Player player2;
    Player player3;

    Player player4;

    Player player5;
    Player player6;

    @BeforeEach
    void init () {

        card1 = new Card("H", 2);
      card2 = new Card("D", 3);
      poker1 = new Poker();
      player = new Player("Ági");
        player.addCard(new Card("C", 2));
        player.addCard(new Card("H", 3));
        player.addCard(new Card("S", 4));
        player.addCard(new Card("C", 8));
        player.addCard(new Card("H", 14));

        player2 = new Player("David");
        player2.addCard(new Card("C", 4));
        player2.addCard(new Card("C", 3));
        player2.addCard(new Card("C", 5));
        player2.addCard(new Card("C", 6));
        player2.addCard(new Card("C", 7));

        player3 = new Player("Maggi");
        player3.addCard(new Card("C", 4));
        player3.addCard(new Card("C", 4));
        player3.addCard(new Card("C", 4));
        player3.addCard(new Card("C", 4));
        player3.addCard(new Card("C", 7));

        player4 = new Player("Maggi");
        player4.addCard(new Card("C", 4));
        player4.addCard(new Card("C", 4));
        player4.addCard(new Card("C", 4));
        player4.addCard(new Card("C", 7));
        player4.addCard(new Card("C", 7));

        player5 = new Player("Filip");
        player5.addCard(new Card("C", 6));
        player5.addCard(new Card("C", 4));
        player5.addCard(new Card("C", 4));
        player5.addCard(new Card("C", 7));
        player5.addCard(new Card("C", 7));

        player6 = new Player("Filip");
        player6.addCard(new Card("C", 6));
        player6.addCard(new Card("C", 4));
        player6.addCard(new Card("C", 4));
        player6.addCard(new Card("C", 8));
        player6.addCard(new Card("C", 7));


    }


    @Test
    public void equalsTest () {
        poker1.equalCards(card1, card2);
        Assertions.assertEquals(false, poker1.equalCards(card1, card2));
    }

    @Test
    public void higherCard2 () {
        poker1.higherCard(card1, card2);
        Assertions.assertEquals(card2, poker1.higherCard(card1, card2));
    }

    @Test
    public void higherCardIncorrectInput () {
       card1 = null;
        Assertions.assertEquals(null, poker1.higherCard(card1, card2));
    }

    @Test
    public void isStraightFlush () {
        Assertions.assertFalse(poker1.straightFlush(player));
    }

    @Test
    public void isStraightFlushSameSuit () {
        Assertions.assertTrue(poker1.straightFlush(player2));
    }

    @Test
    public void isFourOfAKindFalse () {
        Assertions.assertFalse(poker1.fourOfAKind(player));
    }

    @Test
    public void isFourOfAKindTrue () {
        Assertions.assertTrue(poker1.fourOfAKind(player3));
    }

    @Test
    public void isFullHouse() {
        Assertions.assertTrue(poker1.fullHouse(player4));
    }

    @Test
    public void isNotFullHouse() {
        Assertions.assertFalse(poker1.fullHouse(player));
    }

    @Test
    public void isFlush () {
        Assertions.assertTrue(poker1.flush(player2));
    }

    @Test
    public void isStraight() {
        Assertions.assertTrue(poker1.flush(player2));
    }

    @Test
    public void isThreeOfAKindTrue () {
        Assertions.assertTrue(poker1.threeOfAKind(player3));
    }

    @Test
    public void isTwoPairs() {
        Assertions.assertTrue(poker1.twoPairs(player5));
    }

    @Test
    public void isPair() {
        Assertions.assertTrue(poker1.twoPairs(player5));
    }

    @Test
    public void maximumCard () {
        Assertions.assertEquals(7, poker1.highestCard(player3).getValue());
    }
}
