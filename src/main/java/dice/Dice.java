package dice;

import java.util.Random;

public class Dice {

	private static Random random = new Random();
	
	public int cast(){
		return random.nextInt(6) + 1;
	}
}
