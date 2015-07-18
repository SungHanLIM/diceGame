package player;

import dice.Dice;

public class Player {

	private String name;		//이름
	private int totalScore = 0;	//합계득점
	private Dice dice;			//사용할 주사위
	
	
	public Player(String name, Dice dice) {
		this.name = name;
		this.dice = dice;
	}
	
	public String getName() {
		return name;
	}
	
	public Dice getDice() {
		return dice;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void prepare(){
		
	}
	
	public void play(){
		totalScore += dice.cast();
	}
}
