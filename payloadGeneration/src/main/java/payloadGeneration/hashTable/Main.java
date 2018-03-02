package payloadGeneration.hashTable;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		/*
		 * size of table
		 * length of payload
		 * file for payload
		 */
		//TODO make flags to add the ability to choose these fields. 
		int size = 100;
		int maxLength = 10;
		String filename = "./payload.csv";
		
		Hashtable table = new Hashtable(size, maxLength);
		
		int elementLength = 15;
		int length;
		Random rand = new Random();
		
		ArrayList<String> array;
		
		int iterations = 0;
		StringBuilder element;
		
		while (true){
			iterations++;
			/*
			 * Sets the length of our string
			 */
			length = rand.nextInt(elementLength-1) + 1;
			element = new StringBuilder(length);
			/*
			 * Adds the next char to our element. 16^4 is the highest number for 
			 * char.
			 */
			for(int i = 0; i < length; i++) {
				String str = Character.toString((char) (rand.nextInt(207) + 48));
				element.append(str);
			}
			try {
				table.add(element.toString());
			} catch (IndexOutOfBoundsException e) {
				array = table.getArray(element.toString());
				break;
			}
			if(iterations > size*maxLength) {
				System.out.println("The program got stuck in an infinite loop.");
				System.exit(0);
			}
		}
		
		try{
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < maxLength; i++) {
				out.println(array.get(i));
				if (i< (length -1)) {
					out.write(",");
				}
			}
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("Something was wrong with the file");
		}	
	}

}
