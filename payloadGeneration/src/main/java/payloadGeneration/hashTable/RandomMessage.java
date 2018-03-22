package payloadGeneration.hashTable;

import java.util.Random;

public class RandomMessage {
	public static Random rand = new Random();
	
	public static String getNextMessage(int length) {
		StringBuilder str = new StringBuilder(length);
		for(int i=0; i<length; i++) {
			str.append(Character.toString((char) (rand.nextInt(78) + 47)));
		}
		return str.toString();
	}
}
