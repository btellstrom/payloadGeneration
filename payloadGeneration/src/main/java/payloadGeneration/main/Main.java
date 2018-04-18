package payloadGeneration.main;

import payloadGeneration.hashTable.HashTableMain;
import payloadGeneration.quickSort.QuickSortMain;

public class Main {
	
	public static void main(String[] args) {
		for (String arg: args) {
			System.out.println(arg);
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
			if(arg.contains("--qs")) {
				QuickSortMain.QSmain(args);
				break;
			}
			else if(arg.contains("--ht")) {
				HashTableMain.HTmain(args);
				break;
			}
		}
	}

}
