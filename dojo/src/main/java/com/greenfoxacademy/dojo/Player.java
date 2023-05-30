package com.greenfoxacademy.dojo;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> cards;
    private String name;

    public Player(String name) {
        cards = new ArrayList<>();
        this.name = name;
    }

    public void addCard (Card card) {
        this.cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
