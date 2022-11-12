package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Random;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

     String[] wordArray = { "cat", "godzilla", "mothra", "apache", "dog"};
     String currentWord = "";
     char currentGuess = ' ';

     int cGI = 0; // Current Guesses Integer
     boolean continuePlaying = true;
     char[] cGA; // Current Guesses Array
     char[] aWA; // Actual Word Array


    public String getRandomWord (){
        Random rand = new Random();
        int randIndex = rand.nextInt(this.wordArray.length-1);
        this.currentWord = this.wordArray[randIndex];
        return this.currentWord;
    }

    public void display (){
        System.out.println("Current Guesses:");
        System.out.println(this.cGA);
        System.out.println("You have " + this.cGI + " tries left.");
    }

    public void displayInt (int display){
        System.out.println(display);
    }

    public void announce_game(){
        System.out.println("Let's Play WordGuess!");
    }

    public void initializeGameState (){
        getRandomWord();
        wordToArray();
        wordToCurrentGuessArray();
        guessSetter();
    }
    public char[] wordToArray(){
        this.aWA = this.currentWord.toCharArray();
        return this.aWA;
    }

    public char[] wordToCurrentGuessArray(){
        this.cGA = new char[this.aWA.length];
        for (int i = 0; i < this.aWA.length; i++) {
            this.cGA[i] = '_';
        }
        return this.cGA;
    }

    public char getNextGuess(){
        Character chGuess = Console.getCharInput("Enter a single Character:");
        this.currentGuess = chGuess;
        return this.currentGuess;
    }

    public char[] process(){
        for (int i = 0; i < this.cGA.length; i++){
            if ( this.aWA[i] == this.currentGuess ){
                this.cGA[i] = this.currentGuess;
            }
        }
        return this.cGA;
    }

    public boolean checkIfOver(){
        if (Arrays.equals(this.aWA, this.cGA)){
            winningGame();
            return true;
        }
        if (this.cGI == 0 && Arrays.equals(this.aWA, this.cGA)) {
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

    public void game_over(){
        this.currentWord = "";
        this.aWA = null;
        this.cGA = null;
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
        game_over();
        ask_to_play_again();
    }

    public void losingGame(){
        System.out.println("You lost! You ran out of guesses.");
        game_over();
        ask_to_play_again();
    }
    public boolean ask_to_play_again() {
        Character answer = Console.getCharInput("Would you like to play again? (y/n)");
        if (answer.equals('y')) this.continuePlaying = true;
        if (answer.equals('n')) this.continuePlaying = false;
        return false;
    }


}
