package com.spoonertb;

import java.util.*;

class Deck {

    private static final int numCards = 52;
    private ArrayList<Card> deckOfCards;

    Deck(int j) {
        if(j == 1) {
            deckOfCards = new ArrayList<Card>();

            int i = 0;

            for( int suit = 0; suit < 4; suit++) {
                while (i < 13) {
                    Card card = new Card(suit, i);
                    //System.out.println("Added card " + card.getValue() + " with value: " + card.getCardValue());
                    deckOfCards.add(card);
                    i = i + 1;
                }

                i = 0;
            }
        }
        else {
            deckOfCards = new ArrayList<Card>();
        }
    }

    public void shuffleDeck() {
        Card temp = new Card();

        for(int i = 0; i < deckOfCards.size(); i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt(52);

            temp = deckOfCards.get(i);
            deckOfCards.set(i, deckOfCards.get(randomNum));
            //deckOfCards.set(i) = deckOfCards.get(randomNum);
            deckOfCards.set(randomNum, temp);
            //deckOfCards.set(randomNum) = temp;
        }
    }

    public Card dealCard() {
        Card temp = new Card();
        temp = deckOfCards.get(0);
        deckOfCards.remove(0);
        return temp;
    }

    public void addToDeck(Card temp) {
        deckOfCards.add(temp);
    }

    public void printDeck() {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.println(deckOfCards.get(i).getValue());
        }
    }
}