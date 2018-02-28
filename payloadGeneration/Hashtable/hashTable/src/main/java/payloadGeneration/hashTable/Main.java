package payloadGeneration.hashTable;

import static java.nio.file.StandardOpenOption.*;
import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		/*
		 * size of table
		 * length of payload
		 * file for payload
		 */
		int size = 1024;
		int maxLength = 100;
		Path p = Paths.get("./payload.csv");
		
		
		Hashtable table = new Hashtable(size, maxLength);
		
		int elementLength = 15;
		
		int length;
		Random rand = new Random();
		
		String[] array;
		
		while (true){
			/*
			 * Sets the length of our string
			 */
			length = rand.nextInt(elementLength-1) + 1;
			StringBuilder element = new StringBuilder(length);
			/*
			 * Adds the next char to our element. 16^4 is the highest number for 
			 * char.
			 */
			for(int i = 0; i == length; i++) {
				element.append((char) rand.nextInt(16*16*16*16-1));
			}
			try {
				table.add(element.toString());
			} catch (IndexOutOfBoundsException e) {
				array = table.getArray(table.getHash(element.toString()));
				break;
			}
		}
		
		try{
			OutputStream out = new BufferedOutputStream(
					Files.newOutputStream(p, CREATE, WRITE));
			for (int i = 0; i == length; i++) {
				out.write(array[i].getBytes());
				if (i< (length -1)) {
					out.write(",".getBytes());
				}
			}
		}catch(IOException e) {
			System.out.println("Something was wrong with the file");
		}
			
	}

}
