package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList<Player> players = new ArrayList();
    private Deck deck = new Deck();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;

    public Game() {
        for (int i = 0; i < 50; i++) {

            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }



    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean add(String playerName) {

        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + getPlayerSize());
        return true;
    }

    private int getPlayerSize() {
        return players.size();
    }


    public boolean roll(int roll) {
        System.out.println(getCurrenPlayerName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (getCurrentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {
                getCurrentPlayer().getOutOfPenaltyBox();

                movePlayerAndAskQuestion(roll);
                return false;
            } else {
                System.out.println(getCurrenPlayerName() + " is not getting out of the penalty box");
                return true;

            }

        } else {

            movePlayerAndAskQuestion(roll);
            return false;

        }

    }


    private String getCurrenPlayerName() {
        return getCurrentPlayer().getName();
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private void movePlayerAndAskQuestion(int roll) {
        getCurrentPlayer().move(roll);
        askQuestion();
    }


    private int getCurrentPlace() {
        return getCurrentPlayer().getPlace();
    }

    private void askQuestion() {

        String[] categories = {"Pop", "Science", "Sports", "Rock"};
        String category = categories[getCurrentPlace() % categories.length];
        System.out.println("The category is " + category);

        if (category.equals(categories[0]))
            System.out.println(deck.popQuestions.removeFirst());
        if (category.equals(categories[1]))
            System.out.println(scienceQuestions.removeFirst());
        if (category.equals(categories[2]))
            System.out.println(sportsQuestions.removeFirst());
        if (category.equals(categories[3]))
            System.out.println(rockQuestions.removeFirst());
    }


    boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isInPenaltyBox()) {
            return true;
        }
        answerCorrect();
        return didPlayerWin();

    }

    private void answerCorrect() {
        System.out.println("Answer was correct!!!!");
        getCurrentPlayer().increaseOneGold();

    }

    public void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == getPlayerSize()) currentPlayer = 0;
    }


    boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrenPlayerName() + " was sent to the penalty box");

        getCurrentPlayer().moveToPenaltyBox();

        return true;
    }


    private boolean didPlayerWin() {
        return getCurrentPlayer().getGold() != 6;
    }
}
