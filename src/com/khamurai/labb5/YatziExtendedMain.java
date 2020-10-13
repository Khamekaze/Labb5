package com.khamurai.labb5;

import java.util.Scanner;

public class YatziExtendedMain {

    private static Die[] dice;
    private static boolean gameHasStarted = true;
    private static Scanner playerInput;
    private static int turnNumber = 0;
    private static int maxTurns = 3;
    private static int savedDice = 0;

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
            boolean saveDice = false;
            if(savedDice != 0) {
                if (savedDice == dice[i].getValue()) {
                    saveDice = true;
                }
            }
            if(!saveDice) {
                dice[i].rollDie();
            }
            System.out.println((i + 1) + ": " + dice[i].getRollResult());
        }
    }

    private static void checkTurnResult() {
        if(isYatzi(dice)) {
            System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
            endGame();
        } else {
            if(turnNumber != maxTurns - 1) {
                System.out.println("Type the value of any dice you want to save,");
                System.out.println("type y to re-roll all dice or press anything else to exit.");
                if(playerInput.hasNextInt()) {
                    System.out.println("SAVING DICE");
                    saveDice(playerInput.nextInt());
                    ++turnNumber;
                } else if(playerInput.next().equals("y")) {
                    ++turnNumber;
                } else {
                    endGame();
                }
            } else {
                System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
                if(playerInput.next().equals("y")) {
                    resetGame();
                } else {
                    endGame();
                }
            }
        }
    }

    private static void saveDice(int diceToSave) {
        savedDice = diceToSave;
    }

    private static void resetGame() {
        savedDice = 0;
        turnNumber = 0;
    }

    private static void endGame() {
        System.out.println("Thank you for playing!");
        gameHasStarted = !gameHasStarted;
        turnNumber = maxTurns;
    }

    static boolean isYatzi(Die[] dice) {
        for(int i = 1; i < dice.length; i++) {
            if(dice[i].getValue() != dice[i-1].getValue()) {
                return false;
            }
        }
        return true;
    }
}
