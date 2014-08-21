package com.spoonertb;

import java.util.*;
import java.io.DataInputStream;

class BlackJackGame {
    private static final int cardsPerHand = 2;
    private int bet;
    private int money = 100;
    private int hit;
    private int reset = 0;

    Deck deck;
    //Deck used;
    BlackJackGame() {}

    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();

    Scanner reader = new Scanner(System.in);
    int one = 1;
    int zero = 0;

    public void play() {
        deck = new Deck(one);
        //used = new Deck(zero);

        deck.shuffleDeck();
        deck.shuffleDeck();
        bet = placeBet();
        initialDeal();

        do {
            playerHand.printHand();
            //playerHand.returnToDeck();
            //System.out.println("Returned to deck");
            //playerHand.printHand();

            while (playerHits()) {
                playerHand.addCardToHand(deck);
                System.out.println("Player Hand: ");
                playerHand.printHand();

                playerWins();
                dealerWins();
                tie();

                if(reset == 1) {
                    reset = 0;
                    //collectCards();
                    break;
                }
            }

            //Dealer decides whether to hit or stand

            bet = placeBet();
        } while (bet > 0);
    }

    public void initialDeal() {

        for(int i = 0; i < cardsPerHand; i++) {
            playerHand.addCardToHand(deck);
        }

        for(int i = 0; i < cardsPerHand; i++) {
            dealerHand.addCardToHand(deck);
        }

    }

    public void collectCards() {
        //	playerHand.returnToDeck(deck);

        //	dealerHand.returnToDeck(deck);
    }

    public int placeBet() {
        int bet;
        System.out.println("Place a bet: ");
        bet = reader.nextInt();
        return bet;
    }

    public void playerWins() {
        if(dealerHand.busted() || playerHand.blackjack()) {
            System.out.println("\nDealer Wins");
            reset = 1;
        }
    }

    public void dealerWins() {
        if(dealerHand.blackjack()) {
            System.out.println("\nDealer Wins");
            System.out.println("\nDealer Hand: ");
            dealerHand.printHand();

            reset = 1;
        }
        if(playerHand.busted()) {
            System.out.println("\nPlayer Busts");
            System.out.println("Dealer Hand: ");
            dealerHand.printHand();

            reset = 1;
        }
    }

    public void tie() {
        if(dealerHand.blackjack() && playerHand.blackjack()) {
            System.out.println("\nTie Game");
            reset = 1;
        }
    }

    public boolean playerHits() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Would you like to hit or stand? (1 or 0)");
        int selection = keyboardInput.nextInt();
        if (selection == 1)
            return true;
        else return false;
    }

    public void showResults() {

    }
}