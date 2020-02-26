package com.adaptionsoft.games;

import java.util.LinkedList;

public class Deck {
    public  LinkedList questions = new LinkedList();

    public Deck(String category) {
        for (int i = 0; i < 50 ; i++) {
            questions.addLast(category + " Question " + i);
        }
    }

    public Object getNextQuestion(){
        return questions.removeFirst();
    }



}
