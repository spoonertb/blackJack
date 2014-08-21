package com.spoonertb;

//import java.io.DataInputStream;
import java.util.*;
class CardGames {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Welcome to the card games app. Please enter which game you would like to play: ");
        System.out.println("BlackJack: 1");
        System.out.println("Texas Holdem Poker: 2");
        int selection = keyboardInput.nextInt();

        if (selection == 1) {
            BlackJackGame game = new BlackJackGame();
            game.play();
        }

    }
}