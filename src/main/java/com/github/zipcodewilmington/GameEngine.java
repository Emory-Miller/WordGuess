package com.github.zipcodewilmington;

public class GameEngine {

    public static void main(String[] args) {

        Hangman game = new Hangman();

        while(game.continuePlaying){
            game.announceGame();
            game.initializeGameState();
            while(!game.checkIfOver()){
                game.display();
                game.getNextGuess();
                game.process();
                if (game.checkIfOver()){
                    break;
                }
            }
        }
    }
}
