package com.adaptionsoft.games;

import java.util.LinkedList;

public class Deck {
    public  LinkedList popQuestions = new LinkedList();

    public Deck() {
        for (int i = 0; i < 50 ; i++) {
            popQuestions.addLast("Pop Question " + i);
        }
    }



}
