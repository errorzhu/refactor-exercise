package com.adaptionsoft.games;

import java.util.HashMap;
import java.util.Map;

public class DeckManager {


    private Map<Category, Deck> deckMap = new HashMap<Category, Deck>();

    public DeckManager() {
        for (Category category :Category.values()) {
            deckMap.put(category,new Deck(category));

        }
    }

    public String getNextQuestion(int currentPlace) {

        Category category = Category.getCategory(currentPlace);
        return deckMap.get(category).getNextQuestion();
    }

}
