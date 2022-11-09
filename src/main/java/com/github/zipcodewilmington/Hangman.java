package com.github.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    String[] wordArray = { "cat", "dog", "bog", "cut"};
    String currentWord = "";

    int cGI = 0; // Current Guesses Integer
    ArrayList<String> cGA = new ArrayList<>(); // Current Guesses Array
    ArrayList<String> aWA = new ArrayList<>(); // Actual Word Array

    public String getRandomWord (){
        Random rand = new Random();
        int randIndex = rand.nextInt(wordArray.length-1);
        currentWord = wordArray[randIndex];
        return currentWord;
    }

    public String display (String display){
        System.out.println(display.toString());
        return display;
    }


    public ArrayList<String> wordToArray(){
        String[] aWS = currentWord.split("");
        aWA = (ArrayList<String>) Arrays.asList(aWS);
        return aWA;
    }

    public ArrayList<String> wordToGuessArray(){

    }

    public boolean checkGuess(){

    }

    public int countGuesses(){
        return 0;
    }
    public void winningGame(){
        currentWord = "";
        aWA.clear();
        cGA.clear();
        System.out.println("Congratulations, You Won!");
        Console.getStringInput("Would you like to play again? (yes/no)");
    }

    public void losingGame(){
        currentWord = "";
        aWA.clear();
        cGA.clear();
        System.out.println("You lost! You ran out of guesses.");
        Console.getStringInput("Would you like to play again? (yes/no)");
    }
    public void exitGame(){

    }


}
