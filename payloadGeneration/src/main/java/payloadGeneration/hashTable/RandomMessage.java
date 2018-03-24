package payloadGeneration.hashTable;

import java.util.Random;

public class RandomMessage {
	private static Random rand = new Random();
	
	public static String getNextMessage(int length) {
		StringBuilder sb = new StringBuilder(length);
		for(int i=0; i<length; i++) {
			sb.append(Character.toString((char) (rand.nextInt(25) + 65)));
		}
		
		return sb.toString();
	}
}
