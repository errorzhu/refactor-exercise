package com.adaptionsoft.games;

public enum Category {
    pop("Pop"),science("Science"),sports("Sports"),rock("Rock");
    private String name;

    Category(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
