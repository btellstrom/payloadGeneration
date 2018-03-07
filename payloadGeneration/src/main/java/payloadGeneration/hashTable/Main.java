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
		int size = 1024;
		int maxLength = 100;
		String filename = "./payload.csv";
		
		int index = 0; 
		for(String arg: args) {
			if (arg.contains("--size")) {
				size = Integer.parseInt(args[index+1]);
			}
			if(arg.contains("--length")) {
				maxLength = Integer.parseInt(args[index+1]);
			}
			if(arg.contains("--file")) {
				filename = args[index+1];
			}
			if(arg.contains("--help")) {
				System.out.println("Usage java -jar target/... ["
						+ "<switches>...]");
				System.out.println();
				System.out.println("<Switches>");
				System.out.println("--help : display this help");
				System.out.println("--size : sets the size of the hashtable."
						+ " Default 1024");
				System.out.println("--length : sets the length of the payload. "
						+ "Default 100");
				System.out.println("--file : sets the file to write the payload to."
						+ " Default payload.csv");
				System.exit(0);
			}
			index++;
		}
		
		Hashtable table = new Hashtable(size, maxLength);
		
		int elementLength = 15;
		int length;
		Random rand = new Random();
		
		ArrayList<String> array;
		
		int iterations = 0;
		StringBuilder element;
		
		while (true){
			// If iterations > size*maxLength we've reached an infinite loop.
			iterations++;
			/*
			 * Sets the length of our string
			 */
			length = rand.nextInt(elementLength-5) + 5;
			element = new StringBuilder(length);
			/*
			 * Adds the next char to our element. 16^4 is the highest number for 
			 * char.
			 */
			for(int i = 0; i < length; i++) {
				String str = Character.toString((char) (rand.nextInt(93) + 33));
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
