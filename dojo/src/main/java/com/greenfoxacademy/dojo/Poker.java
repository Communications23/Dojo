package com.greenfoxacademy.dojo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Poker {
    public static void main(String[] args) {
        Card card1 = new Card("H", 2);
        Card card2 = new Card("D", 3);

        Player player1 = new Player("David");
        Player player2 = new Player("Ági");

        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(new Card("S", 5));
        player1.addCard(new Card("C", 9));
        player1.addCard(new Card("D", 13));

        player2.addCard(new Card("C", 2));
        player2.addCard(new Card("H", 3));
        player2.addCard(new Card("S", 4));
        player2.addCard(new Card("C", 8));
        player2.addCard(new Card("H", 14));
    }

    public boolean equalCards(Card card1, Card card2){
        if (card1.getSuit().equals(card2.getSuit()) && card1.getValue() == card2.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    public Card higherCard(Card card1, Card card2){
        try {
            if (card1.getValue() < card2.getValue()) {
                return card2;
            } else {
                return card1;
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
        return null;
    }

    public boolean straightFlush (Player player) {
       List<Card> sortedList = player.getCards().stream().sorted((Comparator.comparingInt(Card::getValue))).collect(Collectors.toList());
    for(Card card : sortedList) {
            if (card.getSuit() != player.getCards().get(0).getSuit()) {
                return false;
            }
        }
        for(int i = 0; i < 4; i++) {
            if(sortedList.get(i+1).getValue() - sortedList.get(i).getValue() != 1 ) {
                return false;
            }
        }
        return true;
    }

    public boolean fourOfAKind(Player player) {
        for (Card card: player.getCards()) {
            int counter = 0;
            for (int i = 0; i < 5; i++) {
                if (card.getValue() == player.getCards().get(i).getValue()) {
                    counter++;
                }
                if (counter == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fullHouse(Player player) {
            int counter3 = (int) player.getCards().stream().filter(p->p.getValue() == player.getCards().get(0).getValue()).count();
            List<Card> remainder = player.getCards().stream().filter(p->p.getValue() != player.getCards().get(0).getValue()).collect(Collectors.toList());
            int counter2 = (int) remainder.stream().filter(p->p.getValue() == remainder.get(0).getValue()).count();
            if(counter2 == 2 && counter3 == 3 || counter2 == 3 && counter3 == 2) {
                return true;
            }
        return false;
    }

    public boolean flush(Player player) {
       int counter = (int) player.getCards().stream().filter(p -> p.getSuit() == player.getCards().get(0).getSuit()).count();
       if (counter == 5) {
           return true;
       } else {
           return false;
       }
    }

    public boolean straight (Player player) {
        List<Card> sortedList = player.getCards().stream().sorted((Comparator.comparingInt(Card::getValue))).collect(Collectors.toList());
        for(int i = 0; i < 4; i++) {
            if(sortedList.get(i+1).getValue() - sortedList.get(i).getValue() != 1 ) {
                return false;
            }
        }
        return true;
    }

    public boolean threeOfAKind(Player player) {
        for (Card card: player.getCards()) {
            int counter = 0;
            for (int i = 0; i < 5; i++) {
                if (card.getValue() == player.getCards().get(i).getValue()) {
                    counter++;
                }
                if (counter == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean twoPairs(Player player) {
        int counter3 = (int) player.getCards().stream().filter(p->p.getValue() == player.getCards().get(0).getValue()).count();
        List<Card> remainder = player.getCards().stream().filter(p->p.getValue() != player.getCards().get(0).getValue()).collect(Collectors.toList());
        int counter2 = (int) remainder.stream().filter(p->p.getValue() == remainder.get(0).getValue()).count();
        List<Card> remainder2 = remainder.stream().filter(p->p.getValue() != remainder.get(0).getValue()).collect(Collectors.toList());
        int counter4 = (int) remainder2.stream().filter(p->p.getValue() == remainder2.get(0).getValue()).count();
        if(counter2 == 2 && counter3 == 2 || counter2 == 2 && counter4 == 2 || counter3 == 2 && counter4 == 2) {
            return true;
        }
        return false;
    }

    public boolean pair(Player player) {
        for (Card card : player.getCards()
        ) {
            int counter = (int) player.getCards().stream().filter(p -> p.getValue() == card.getValue()).count();
            if (counter == 2) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Card highestCard(Player player) {
        Card card = player.getCards().stream().max(Comparator.comparingInt(Card::getValue)).get();
        return card;
    }

}
