package payloadGeneration.quickSort;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class QuickSortMain {
	
	public static void QSmain(String[] args) {
		int length = 1000;
		int[] list;
		String filename = "~/output.csv";
		
		int index = 0;
		for(String arg: args) {
			if (arg.contains("--length")) {
				length = Integer.parseInt(args[index+1]);
			}
			if (arg.contains("--file")) {
				filename = args[index+1];
			}
			index++;
		}
		list = ListGenerator.generateList(length);
		
		try{
			PrintWriter out = new PrintWriter(filename);
			for (int i = 0; i < length; i++) {
				out.print(list[i]);
				if (i< (length -1)) {
					out.print(",");
				}
			}
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println("Something was wrong with the file");
		}		
	}
}
