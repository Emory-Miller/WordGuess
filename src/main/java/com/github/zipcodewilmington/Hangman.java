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
    String currentGuess = Console.getStringInput("Enter a single Character:");

    int cGI = 0; // Current Guesses Integer
    boolean continuePlaying = true;
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

    public ArrayList<String> wordToCurrentGuessArray(){
        for (int i = 0; i <aWA.size(); i++){
            cGA.add("_");
        }
        return cGA;
    }

    public ArrayList<String> checkGuess(String currentGuess){
        for (int i = 0; i < aWA.size(); i++){
            if ( aWA.get(i).equals(currentGuess)){
                cGA.add(i, currentGuess);
            }
        }
        return cGA;
    }

    public void guessSetter(){
        cGI = aWA.size();
    }
    public void winningGame(){
        currentWord = "";
        aWA.clear();
        cGA.clear();
        System.out.println("Congratulations, You Won!");
;
    }

    public void losingGame(){
        currentWord = "";
        aWA.clear();
        cGA.clear();
        System.out.println("You lost! You ran out of guesses.");;
    }
    public boolean exitGame(){
        String answer = Console.getStringInput("Would you like to play again? (yes/no)");
        if (answer.equals("yes")){
            continuePlaying = true;
        } else {
            continuePlaying = false;
        }
        return continuePlaying;
    }


}
