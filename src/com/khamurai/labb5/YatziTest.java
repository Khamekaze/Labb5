package com.khamurai.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {

    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] dice = new Die[5];
        for(int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
            dice[i].setValue(6);
        }
        assertTrue(YatziMain.isYatzi(dice));
    }

    @Test
    void isNotYatziWhenDiceAreNotMatching() {
        Die[] dice = new Die[5];
        for(int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
            dice[i].setValue(i);
        }
        assertFalse(YatziMain.isYatzi(dice));
    }
}
