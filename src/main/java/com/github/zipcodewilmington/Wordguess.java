package com.github.zipcodewilmington;
import com.github.zipcodewilmington.Hangman;
public class Wordguess {

    public static void main(String[] args) {

        Hangman game = new Hangman();
        game.announce_game();

        while(game.continuePlaying){
            game.initializeGameState();
            while(game.continueGame()){
                game.display();
                game.getNextGuess();
                game.process();
                game.checkIfOver();
                game.cGI -= 1 ;
            }
        }
    }

}
