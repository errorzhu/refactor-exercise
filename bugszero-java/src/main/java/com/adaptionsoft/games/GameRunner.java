
package com.adaptionsoft.games;

import java.util.Random;


public class GameRunner {

	private static boolean notAWinner = true;

	public static void main(String[] args) {
		Random rand = new Random();
		playGame(rand);

	}

	public static void playGame(Random rand) {
		Game aGame = new Game();

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");


		do {

			boolean inPenaltyBox = aGame.roll(rand.nextInt(5) + 1);

			boolean wrong = rand.nextInt(9) == 7;
			if(!inPenaltyBox){
				if (wrong) {
					notAWinner = aGame.wrongAnswer();
				} else {
					notAWinner = aGame.wasCorrectlyAnswered();
				}
			}

			aGame.nextPlayer();




		} while (notAWinner);
	}
}
