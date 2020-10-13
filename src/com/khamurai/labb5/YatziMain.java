package com.khamurai.labb5;

import java.util.Scanner;

/**
 * A game of classic Yatzi (Yahtzee)
 *
 * The player rolls the dice three times
 *
 * If all dice match the player wins!
 */
public class YatziMain {

    private static Die[] dice;
    private static boolean gameHasStarted = true;
    private static Scanner playerInput;
    private static int turnNumber = 0;
    private static final int maxTurns = 3;

    public static void main(String[] args) {
        instantiateGame();
        while(gameHasStarted) {
            System.out.println("Welcome to Yatzi!");
            while(turnNumber < maxTurns) {
                takeTurn();
                checkTurnResult();
            }
        }
    }

    private static void instantiateGame() {
        playerInput = new Scanner(System.in);
        dice = new Die[5];
        for(int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
        }
    }

    private static void takeTurn() {
        System.out.println("Starting turn " + (turnNumber+1) + " of 3, rolling dice.");
        for(int i = 0; i < dice.length; i++) {
            dice[i].rollDie();
            System.out.println((i + 1) + ": " + dice[i].getRollResult());
        }
    }

    private static void checkTurnResult() {
        if(isYatzi(dice)) {
            System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
            endGame();
        } else {
            if(turnNumber != maxTurns - 1) {
                System.out.println("Want to throw again? (y for yes, anything else for no)");
                if(playerInput.next().equals("y")) {
                    ++turnNumber;
                } else {
                    endGame();
                }
            } else {
                System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
                if(playerInput.next().equals("y")) {
                    turnNumber = 0;
                } else {
                    endGame();
                }
            }
        }
    }

    private static void endGame() {
        System.out.println("Thank you for playing!");
        gameHasStarted = !gameHasStarted;
        turnNumber = maxTurns;
    }

    /**
     * Compares the values of elements in an array of dice and returns whether their values are equal or not
     *
     * @param dice The array to be compared
     * @return true if all values of the array are equal, otherwise false
     */
    static boolean isYatzi(Die[] dice) {
        for(int i = 1; i < dice.length; i++) {
            if(dice[i].getValue() != dice[i-1].getValue()) {
                return false;
            }
        }
        return true;
    }
}
