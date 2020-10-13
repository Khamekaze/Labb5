package com.khamurai.labb5;

public class Die {

    private int value = 0;

    public Die() {
        rollDie();
    }

    public void rollDie() {
        value = (int)(Math.random() * 6 + 1);
    }

    public String getRollResult() {
        return "Dice shows " + value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
