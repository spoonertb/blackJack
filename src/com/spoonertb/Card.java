package com.spoonertb;

class Card {
    private String suit, rank;
    private int cardValue;

    private static String[] suits = {"Hearts","Diamonds","Clubs","Spades"};

    private static String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10",
            "Jack","Queen","King"};

    Card(int suit, int rank) {
        this.suit = suits[suit];
        this.rank = ranks[rank];

        switch (rank) {
            case 10: this.cardValue = 10; break;
            case 11: this.cardValue = 10; break;
            case 12: this.cardValue = 10; break;
            default: this.cardValue = rank + 1; break;
        }
    }

    Card() {};

    public String getValue() {
        return rank + " of " + suit;
    }

    public int getCardValue() {
        return cardValue;
    }

}