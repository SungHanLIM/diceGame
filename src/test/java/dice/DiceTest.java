package dice;

import java.util.Random;

import org.junit.Test;

public class DiceTest {
private static Random random = new Random();
	@Test
	public int cast(){
		return random.nextInt(6) + 1;
	}

}
