package com.adaptionsoft.games;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList<Player> tempPlayer = new ArrayList();
    int[] places = new int[6];
    int[] gold = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

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

        tempPlayer.add(new Player(playerName));
	    places[howManyPlayers()] = 0;
	    gold[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;

	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + getPlayerSize());
		return true;
	}

    private int getPlayerSize() {
        return tempPlayer.size();
    }

    public int howManyPlayers() {
		return getPlayerSize();
	}

	public void roll(int roll) {
		System.out.println(getCurrenPlayer() + " is the current player");
		System.out.println("They have rolled a " + roll);

		if (isInPenaltyBox()) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(getCurrenPlayer() + " is getting out of the penalty box");
				movePlayerAndAskQuestion(roll);
			} else {
				System.out.println(getCurrenPlayer() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}

		} else {

			movePlayerAndAskQuestion(roll);
		}

	}

	private boolean isInPenaltyBox() {
		return inPenaltyBox[currentPlayer];
	}

	private String getCurrenPlayer() {
		return tempPlayer.get(currentPlayer).getName();
	}

	private void movePlayerAndAskQuestion(int roll) {
		places[currentPlayer] = getCurrentPlace() + roll;
		if (getCurrentPlace() > 11) places[currentPlayer] = getCurrentPlace() - 12;

		System.out.println(getCurrenPlayer()
                + "'s new location is "
                + getCurrentPlace());
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private int getCurrentPlace() {
		return places[currentPlayer];
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
		if (isInPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayer++;
				if (currentPlayer == getPlayerSize()) currentPlayer = 0;
				gold[currentPlayer]++;
				System.out.println(getCurrenPlayer()
						+ " now has "
						+ getCurrentGold()
						+ " Gold Coins.");

				return didPlayerWin();
			} else {
				currentPlayer++;
				if (currentPlayer == getPlayerSize()) currentPlayer = 0;
				return true;
			}



		} else {

			System.out.println("Answer was corrent!!!!");
			gold[currentPlayer]++;
			System.out.println(getCurrenPlayer()
					+ " now has "
					+ getCurrentGold()
					+ " Gold Coins.");

			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == getPlayerSize()) currentPlayer = 0;

			return winner;
		}
	}

	private int getCurrentGold() {
		return gold[currentPlayer];
	}

	boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(getCurrenPlayer() + " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;

		currentPlayer++;
		if (currentPlayer == getPlayerSize()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(getCurrentGold() == 6);
	}
}
