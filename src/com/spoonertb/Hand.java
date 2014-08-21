package com.spoonertb;

import java.util.*;

class Hand {
    private int sizeHand;
    private static final int maxCards = 12;
    private int handTotal;

    ArrayList<Card> handofCards;

    Hand() {
        handofCards = new ArrayList<Card>();
        sizeHand = 0;
        handTotal = 0;
    }

    public void addCardToHand(Deck deck) {
        Card temp = deck.dealCard();
        handofCards.add(temp);
        sizeHand += 1;
        handTotal += temp.getCardValue();
    }

    public void printHand() {
        for(int i = 0; i < handofCards.size(); i++) {
            System.out.println(handofCards.get(i).getValue());
        }
    }

    public int getSizeHand() {
        return sizeHand;
    }

    public void returnToDeck() {
        for(int i = 0; i < sizeHand; i++) {
            //	deck.addToDeck(handofCards.get(i));
            //	handofCards.remove(i);
        }
    }

    public boolean blackjack() {
        if (handTotal == 21)
            return true;
        else return false;
    }

    public boolean under() {
        if (handTotal < 21)
            return true;
        else return false;
    }

    public boolean mustHit() {
        if (handTotal <= 17)
            return true;
        else return false;
    }

    public boolean busted() {
        if(handTotal > 21)
            return true;
        else return false;
    }

}