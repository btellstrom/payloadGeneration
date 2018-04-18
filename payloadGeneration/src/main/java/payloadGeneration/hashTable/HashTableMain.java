package payloadGeneration.hashTable;

import java.io.*;
import java.util.*;

public class HashTableMain {

	public static class HashOrder implements Comparator<String>{
		public HashOrder() {
		}
		public int compare(String str1, String str2) {
			int hash1 = str1.hashCode();
			int hash2 = str2.hashCode();
			return hash1-hash2;
		}
	}
	
	public static void HTmain(String[] args) {
		/*
		 * size of table
		 * length of payload
		 * file for payload
		 */
		//TODO make flags to add the ability to choose these fields. 
		int size = 1024;
		int maxLength = 100;
		String filename = "./payload.csv";
		boolean naive = false;
		
		HashOrder order = new HashOrder();
		
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
			if (arg.contains("--naive")) {
				naive = true;
			}
				
			index++;
		}
		if (naive) {
			specificNaiveHashGeneration(size, maxLength, filename, order);
		}
		else {
			concurrentAndDesignedHashGeneration(size, maxLength, filename, order);
		}
		
	}
	
	private static void concurrentAndDesignedHashGeneration(int size, int maxLength, String filename, HashOrder order) {
	
		Hashtable table = new Hashtable(size, maxLength);
		
		int elementLength = 15;
		int length;
		Random rand = new Random();
		
		String[] array;
		
		int iterations = 0;
		String element;
		
		while (true){
			// If iterations > size*maxLength we've reached an infinite loop.
			iterations++;
			/*
			 * Sets the length of our string
			 */
			length = rand.nextInt(elementLength-5) + 5;
			element = RandomMessage.getNextMessage(length);
		
			try {
				table.add(element);
			} catch (IndexOutOfBoundsException e) {
				array = table.getArray(element);
				break;
			}
			if(iterations > size*maxLength) {
				System.out.println("The program got stuck in an infinite loop.");
				System.exit(0);
			}
		}
		
		Arrays.sort(array, order);
		
		try{
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < maxLength; i++) {
				out.print(array[i]);
				if (i< (maxLength -1)) {
					out.print(",");
				}
			}
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("Something was wrong with the file");
		}	
	}
	
	public static void specificNaiveHashGeneration(int size, int maxLength, String filename, HashOrder order) {
		
		int elementLength = 15;
		int length;
		Random rand = new Random();
		String element;
		
		ArrayList<String> list = new ArrayList<String>(maxLength);
		length = rand.nextInt(elementLength-5) + 5;
		element = RandomMessage.getNextMessage(length);
		int hash = element.hashCode();
		
		while (list.size() < maxLength) {
			length = rand.nextInt(elementLength-5) + 5;
			element = RandomMessage.getNextMessage(length);
			if (hash == element.hashCode()) {
				list.add(element);
			}
			
		}
		String[] array = (String[])list.toArray();
		
		
		Arrays.sort(array, order);
		
		try{
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < maxLength; i++) {
				out.print(array[i]);
				if (i< (maxLength -1)) {
					out.print(",");
				}
			}
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("Something was wrong with the file");
		}	
	}
}
