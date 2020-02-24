package com.adaptionsoft.games;

public class Player {
    private String name;
    private int gold = 0;
    private int place = 0;

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

    public int getPlace() {
        return place;
    }

    public void move(int roll) {
        place = place + roll;
        if (place > 11) place = place - 12;
    }
}
