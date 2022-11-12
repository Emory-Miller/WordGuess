package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Random;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

     String[] wordArray = { "cat", "dog"};
     String currentWord = "";
     char currentGuess = ' ';

     int cGI = 0; // Current Guesses Integer
     boolean continuePlaying = true;
     char[] cGA; // Current Guesses Array
     char[] aWA; // Actual Word Array


    public String getRandomWord (){
        Random rand = new Random();
        int randIndex = rand.nextInt(this.wordArray.length);
        this.currentWord = this.wordArray[randIndex];
        return this.currentWord;
    }

    public void display (){
        System.out.println("Current Guesses:");
        System.out.println(this.cGA);
        System.out.println("You have " + this.cGI + " tries left.");
    }

    public void announceGame(){
        System.out.println("Let's Play WordGuess!");
    }

    public void initializeGameState (){
        gameOver();
        getRandomWord();
        wordToArray();
        wordToCurrentGuessArray();
        guessSetter();
    }
    public void wordToArray(){
        this.aWA = this.currentWord.toCharArray();
    }

    public void wordToCurrentGuessArray(){
        this.cGA = new char[this.aWA.length];
        for (int i = 0; i < this.aWA.length; i++) {
            this.cGA[i] = '_';
        }
    }

    public void getNextGuess(){
        this.currentGuess = Console.getCharInput("Enter a single Character:");
    }

    public void process(){
        for (int i = 0; i < this.cGA.length; i++){
            if ( this.aWA[i] == this.currentGuess ){
                this.cGA[i] = this.currentGuess;
            }
        }
        this.cGI -= 1;
    }

    public boolean checkIfOver(){
        if (Arrays.equals(this.aWA, this.cGA)){
            winningGame();
            return true;
        }
        if (this.cGI == 0) {
            losingGame();
            return true;
        }
        return false;
    }

    public void guessSetter(){
        this.cGI = this.aWA.length;
    }

    public void gameOver(){
        getRandomWord();
        wordToArray();
        wordToCurrentGuessArray();
    }

    public boolean continueGame(){
        if (checkIfOver() == true) return false;
        if (checkIfOver() == false) return true;
        return true;
    }

    public void winningGame(){
        System.out.println("**************************");
        System.out.println(this.cGA);
        System.out.println("Congratulations, You Won!");
        askToPlayAgain();
    }

    public void losingGame(){
        System.out.println("You lost! You ran out of guesses.");
        askToPlayAgain();
    }
    public void askToPlayAgain() {
        Character answer = Console.getCharInput("Would you like to play again? (y/n)");
        if (answer.equals('y')) this.continuePlaying = true;
        if (answer.equals('n')) this.continuePlaying = false;
    }

}
