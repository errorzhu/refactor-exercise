package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList<Player> players = new ArrayList();
    private DeckManager dm = new DeckManager();


    int currentPlayer = 0;


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

        String question = dm.getNextQuestion(getCurrentPlace());
        System.out.println(question);

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
