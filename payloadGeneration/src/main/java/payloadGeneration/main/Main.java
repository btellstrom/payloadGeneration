package payloadGeneration.main;

import payloadGeneration.hashTable.HashTableMain;
import payloadGeneration.quickSort.QuickSortMain;

public class Main {
	
	public static void main(String[] args) {
		for (String arg: args) {
			System.out.println(arg);
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
