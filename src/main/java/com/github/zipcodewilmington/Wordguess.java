package com.github.zipcodewilmington;
import com.github.zipcodewilmington.Hangman;
public class Wordguess {

    public static void main(String[] args) {

        Hangman game = new Hangman();
        game.announceGame();

        while(game.continuePlaying){
            game.announceGame();
            game.initializeGameState();
            while(game.checkIfOver()==false){
                game.display();
                game.getNextGuess();
                game.process();
                if (game.checkIfOver() == true){
                    break;
                }
            }
        }
    }
}
