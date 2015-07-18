/*
 * @(#) Judge.java 2014. 9. 5 
 *
 * Copyright 2014 NHN Ent. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package dicegame;

import java.util.ArrayList;
import java.util.List;

import player.Player;

/**
 * 심판. 주사위게임을 진행하며 승자를 판정하는 역할을 한다.
 */
public class Judge {

	private List<Player> allPlayers = new ArrayList<Player>();
	private Recorder recorder;
	
	public Judge(Recorder recorder) {
		this.recorder = recorder;
	}
	
	/**
	 * 게임에 참가할 플레이어를 등록한다.
	 *
	 * @param 플레이어
	 */
	public void registerPlayer(Player player){
		allPlayers.add(player);
	}
	
	/**
	 * 주사위게임을 진행한다.
	 * 입력받은 라운드 수 만큼 게임을 플레이한다.
	 *
	 * @param roundCount : 라운드 수
	 */
	public void playGame(int roundCount){
		for (int i = 0; i < roundCount; i++) {
			playOneRound();
			recorder.printScores(allPlayers);
		}
		recorder.printWinner(getWinner());
	}

	/**
	 * 1라운드를 진행한다.
	 * 모든 플레이어가 각각 주사위를 던진다.
	 */
	private void playOneRound() {
		for (Player player : allPlayers) {
			player.prepare();
			player.play();
		}
	}
	
	/**
	 * 승자를 판정한다(무승부일 때의 반환값은 null)
	 *
	 * @return the winner
	 */
	public Player getWinner(){
		//가장 높은 점수의 플레이어를 선택한다
		List<Player> winners = getPlayers(getHighScore());
		
		//한 사람일 때는 승자를 리턴하고, 두 사람일 때는 무승부
		if (winners.size() == 1) {
			return winners.get(0);
		}else {
			return null;
		}
	}

	private int getHighScore() {
		int highScore = Integer.MIN_VALUE;
		
		for (int i = 0; i < allPlayers.size(); i++) {
			
			Player player = (Player) allPlayers.get(i);
			
			if (player.getTotalScore() > highScore) {
				
				highScore = player.getTotalScore();
			}
		}
		return highScore;
	}
	
	private List<Player> getPlayers(int highScore) {
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < allPlayers.size(); i++) {
			Player player = (Player) allPlayers.get(i);
			if (player.getTotalScore() == highScore) {
				players.add(player);
			}
		}
		return players;
	}
}
