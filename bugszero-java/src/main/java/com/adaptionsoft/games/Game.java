package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList<Player> players = new ArrayList();
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
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


	public void roll(int roll) {
		System.out.println(getCurrenPlayerName() + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (getCurrentPlayer().isInPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(getCurrenPlayerName() + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				System.out.println(getCurrenPlayerName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			movePlayerAndAskQuestion(roll);
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


		System.out.println("The category is " + currentCategory());
		askQuestion();
	}



	private int getCurrentPlace() {
		return getCurrentPlayer().getPlace();
	}

	private void askQuestion() {
		if (currentCategory().equals("Pop"))
			System.out.println(popQuestions.removeFirst());
		if (currentCategory().equals("Science"))
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory().equals("Sports"))
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory().equals("Rock"))
			System.out.println(rockQuestions.removeFirst());
	}


	private String currentCategory() {
		if (getCurrentPlace() == 0) return "Pop";
		if (getCurrentPlace() == 4) return "Pop";
		if (getCurrentPlace() == 8) return "Pop";
		if (getCurrentPlace() == 1) return "Science";
		if (getCurrentPlace() == 5) return "Science";
		if (getCurrentPlace() == 9) return "Science";
		if (getCurrentPlace() == 2) return "Sports";
		if (getCurrentPlace() == 6) return "Sports";
		if (getCurrentPlace() == 10) return "Sports";
		return "Rock";
	}

	boolean wasCorrectlyAnswered() {
		if (getCurrentPlayer().isInPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer++;
				if (currentPlayer == getPlayerSize()) currentPlayer = 0;
				getCurrentPlayer().increaseOneGold();

				return didPlayerWin();
			} else {
				currentPlayer++;
				if (currentPlayer == getPlayerSize()) currentPlayer = 0;
				return true;
			}



		} else {

			System.out.println("Answer was corrent!!!!");
			getCurrentPlayer().increaseOneGold();


			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == getPlayerSize()) currentPlayer = 0;

			return winner;
		}
	}


	boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(getCurrenPlayerName() + " was sent to the penalty box");

		getCurrentPlayer().moveToPenaltyBox();

		currentPlayer++;
		if (currentPlayer == getPlayerSize()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(getCurrentPlayer().getGold() == 6);
	}
}
