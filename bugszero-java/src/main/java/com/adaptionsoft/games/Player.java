package com.adaptionsoft.games;

public class Player {
    private String name;
    private int gold = 0;
    private int place = 0;
    private boolean inPenaltyBox = false;

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
        System.out.println(name
                + " now has "
                + gold
                + " Gold Coins.");
    }

    public int getPlace() {
        return place;
    }

    public void move(int roll) {
        place = place + roll;
        if (place > 11) place = place - 12;

        System.out.println(name
                + "'s new location is "
                + place);
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void moveToPenaltyBox() {
        inPenaltyBox = true;

    }
}
