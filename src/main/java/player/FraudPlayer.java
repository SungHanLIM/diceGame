package player;

import dice.FraudDice;
import dicegame.Mode;

public class FraudPlayer extends Player {

	private FraudDice fraudDice;
	private Player rival;
	
	public FraudPlayer(String name, FraudDice fraudDice, Player rival) {
		super(name, fraudDice);
		this.fraudDice = fraudDice;
		this.rival = rival;
	}
	
	public void prepare(){
		if (rival.getTotalScore() - this.getTotalScore() > 0) {
			//지고 있을 경우 주사위 레벨을 높인다
			fraudDice.setMode(Mode.STRONG);
		}else if (rival.getTotalScore() - this.getTotalScore() >= 6) {
			//6점이상 차이가 나면 주사위 레벨을 높인다
			fraudDice.setMode(Mode.WEAK);
		}else {
			fraudDice.setMode(Mode.NORMAL);
		}
	}

}
