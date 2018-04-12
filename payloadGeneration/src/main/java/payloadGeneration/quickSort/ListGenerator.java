package payloadGeneration.quickSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ListGenerator {
	
	public static class DescendingOrder implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b.compareTo(a);
		}
	}
	
	private static DescendingOrder order = new DescendingOrder();
	
	public static int[] generateList(int length) {
		int[] list = new int[length];
		int[] ret = new int[length];
		Random rand = new Random();
		
		for(int i = 0;i < length; i++) {
			list[i] = rand.nextInt();
		}
		ret = sortList(list);
		return ret;
	}
	
	private static int[] sortList(int[] list) {
		int[] ret = new int[list.length];
		Integer[] sorted = Arrays.stream(list).boxed().toArray( Integer[]::new );
		Arrays.sort(sorted, order);
		for (int i = 0; i<list.length; i++) {
			ret[i] = sorted[i].intValue();
		}
		return ret;
	}
}
