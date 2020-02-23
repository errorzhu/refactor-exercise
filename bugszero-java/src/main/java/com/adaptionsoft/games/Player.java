package com.adaptionsoft.games;

public class Player {
    private String name;
    private int gold = 0;

    public Player(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public void increaseOneGold() {
        this.gold++;
    }
}
