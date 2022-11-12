package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;
import com.github.zipcodewilmington.Hangman;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {

    @Test
    public void getRandomWordTest(){
        Hangman hm = new Hangman();
        System.out.println(hm.getRandomWord());
    }

//    @Test
//    public void displayTest(){
//        Hangman hm = new Hangman();
//        String expected = "Hello World";
//        String actual = hm.display(expected);
//        Assert.assertEquals(expected, actual);
//    }
}
