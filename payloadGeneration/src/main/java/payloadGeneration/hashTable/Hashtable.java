package payloadGeneration.hashTable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A hashtable that merely stores whatever element is put in at it's given
 * hashlocation. No collection detection, just list. Throws error if 
 * the inner list becomes too large.
 *
 */
public class Hashtable {
	private int size;
    private int maxLength;
    private ArrayList<ArrayList<String>> table; 
	static final int MAXIMUM_CAPACITY = 1 << 30;
    
	public Hashtable(int size, int maxLength) {
		//TODO add parameter that chooses which hashfucntion to be used
		// set size
		int n = size-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        size = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        this.size = size;
		this.maxLength = maxLength;
		table = new ArrayList<ArrayList<String>>(size);
		
		ArrayList<String> list;
		
		for(int i = 0; i < size; i++) {
			list = new ArrayList<String>(maxLength);
			table.add(list);
		}
	}
	
	public void add(String element) throws IndexOutOfBoundsException{
		//TODO fix this method. Seems to not add to array properly1
		int value = (size-1) & getHash(element);
		ArrayList<String> list = table.get(value);
		if(list.size() +1 == maxLength) {
			list.add(element);
			throw new IndexOutOfBoundsException();
		}
		else {
			list.add(element);
		}
	}
	
	public void add(int pos, String element) throws IndexOutOfBoundsException {
		try {
			table.get(pos).add(element);
		} catch(IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int getHash(String element){
		//TODO implement hashfunctions other than native
		
		
		int h;
		assert(element != null):"String is null";
		return (element == null) ? 0 : (h = element.hashCode()) ^ (h >>> 16);
	}
	
	public String[] getArray(int index) {
		String[] retArray = Arrays.copyOf(table.get(index).toArray(), 
				table.get(index).size(), String[].class);
		return retArray;
	}
	
	public String[] getArray(String element) {
		String[] retArray = Arrays.copyOf(table.get((size-1) & getHash(element)).toArray(), 
				table.get((size-1) & getHash(element)).size(), String[].class);
		return retArray;
	}
	
	public int getSize() {
		return size;
	}
}
