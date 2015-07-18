package main;

import player.FraudPlayer;
import player.Player;
import dice.Dice;
import dice.FraudDice;
import dicegame.Judge;
import dicegame.Recorder;

public class DiceGame {
	
	private static final int ROUND_COUNT = 5; //한 게임의 라운드 수

	public static void main(String[] args) {

		Judge judge = new Judge(new Recorder());
		Player player= createPlayer(args);
		FraudPlayer computer = new FraudPlayer("컴퓨터", new FraudDice(), player);
		
		judge.registerPlayer(computer);
		judge.registerPlayer(player);
		judge.playGame(ROUND_COUNT);
	}

	private static Player createPlayer(String[] args) {
		
		String playerName = (args.length == 0)? "임승한" : args[0];
		
		return new Player(playerName, new Dice());
	}

}
