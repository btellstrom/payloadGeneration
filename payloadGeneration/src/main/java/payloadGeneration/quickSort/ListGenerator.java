package payloadGeneration.quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class ListGenerator {
	
	private static DescendingOrder order = new DescendingOrder();
	
	public static int[] generateList(int length, int index) {
		int[] list = new int[length];
		int[] ret = new int[length];
		Random rand = new Random();
		
		for(int i = 0;i < length; i++) {
			list[i] = rand.nextInt();
		}
		ret = sortList(list, index);
		return ret;
	}
	
	private static int[] sortList(int[] list, int i) {
		int[] ret;
		if (i == 0) {
			ret = sortListDescendingOrder(list);
		}
		else if(i == 1) {
			ret = sortWorstCaseMiddle(list);
		}
		else {
			ret = list;
		}
		return ret;
	}
	
	
	public static class DescendingOrder implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b.compareTo(a);
		}
	}
	private static int[] sortListDescendingOrder(int[] list) {
		int[] ret = new int[list.length];
		Integer[] sorted = Arrays.stream(list).boxed().toArray( Integer[]::new );
		Arrays.sort(sorted, order);
		for (int i = 0; i<list.length; i++) {
			ret[i] = sorted[i].intValue();
		}
		return ret;
	}
	private static int[] sortWorstCaseMiddle (int[] list) {
		int[] ret = new int[list.length];
		ArrayList<Integer> sorted = new ArrayList<Integer>(list.length);
		for (int i = 0; i < list.length; i++) {
			sorted.add(list[i]);
		}
		Collections.sort(sorted, order);

		float index = (list.length-1)/2;
		ret[Math.round(index)] = sorted.get(sorted.size() -1).intValue();
		sorted.remove(sorted.size() -1);
		index = index/2;
		placeAtHalf(index + index/2, ret, sorted);
		placeAtHalf(index/2, ret, sorted);
		return ret;
	}
	private static void placeAtHalf(float index, int[] ret, ArrayList<Integer> sorted) {
		if (Math.round(index) == 0) {
			
		}
		else {
			ret[Math.round(index) + Math.round(index/2)] = sorted.get(sorted.size() -1).intValue();
			sorted.remove(sorted.size() -1);
			ret[Math.round(index) - Math.round(index/2)] = sorted.get(sorted.size() -1).intValue();
			sorted.remove(sorted.size() -1);
			placeAtHalf(index/2, ret, sorted);
			placeAtHalf(index/2 + index, ret, sorted);
		}
	}
}
