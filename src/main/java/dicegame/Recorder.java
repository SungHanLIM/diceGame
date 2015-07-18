/*
 * @(#) Recorder.java 2014. 9. 5 
 *
 * Copyright 2014 NHN Ent. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package dicegame;

import java.util.List;

import player.Player;
import dice.Dice;
import dice.FraudDice;

public class Recorder {

	/**
	 * 모든 플레이어의 스코어를 기록한다
	 *
	 * @param 플레이어 목록
	 */
	public void printScores(List<Player> players) {
		StringBuffer message = new StringBuffer();
		
		message.append("[ ");
		for (Player player : players) {
			message.append(player.getName() + ":" + player.getTotalScore() + getDiceMode(player.getDice()) + " ");
		}
		message.append("]");
		
		System.out.println(message);
	}

	/**
	 * 주사위의 상태를 표현하는 문자열을 반환한다
	 *
	 * @param dice the dice
	 * @return the dice mode
	 */
	private String getDiceMode(Dice dice) {
		if (!(dice instanceof FraudDice)) {
			return "";
		}
		
		FraudDice fraudDice = (FraudDice) dice;
		switch (fraudDice.getMode()) {
			case NORMAL:
				return "[NORMAL]";
				
			case STRONG:
				return "[STRONG]";

			default:
				return "[WEAK]";
		}
	}
	
	/**
	 * 승자를 기록한다
	 *
	 * @param 우승자
	 */
	public void printWinner(Player winner){
		if (winner != null) {
			System.out.println(winner.getName() + "의 승리!");
		}else {
			System.out.println("무승부!");
		}
	}
}
