package com.adaptionsoft.games;

public class DeckManager {

    private Deck popDeck = new Deck("Pop");
    private Deck scienceDeck = new Deck("Science");
    private Deck rockDeck = new Deck("Rock");
    private Deck sportsDeck = new Deck("Sports");

    public String getNextQuestion(int currentPlace) {
        String[] categories = {Category.pop.getName(), Category.science.getName(), Category.sports.getName(), Category.rock.getName()};
        String category = categories[currentPlace % categories.length];
        System.out.println("The category is " + category);

        if (category.equals(categories[0])) {
            return popDeck.getNextQuestion();
        }
        if (category.equals(categories[1])) {
            return scienceDeck.getNextQuestion();

        }
        if (category.equals(categories[2])) {
            return sportsDeck.getNextQuestion();

        }
        if (category.equals(categories[3])) {
            return rockDeck.getNextQuestion();
        }
        throw new Error("");
    }
}
