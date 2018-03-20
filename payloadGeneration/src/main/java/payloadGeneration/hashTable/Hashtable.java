package payloadGeneration.hashTable;

import java.util.ArrayList;

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
    
	public Hashtable(int size, int maxLength) {
		//TODO add parameter that chooses which hashfucntion to be used
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
		int value = getHash(element);
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
			getArray(pos).add(element);
		} catch(IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int getHash(String element){
		//TODO implement hashfunctions other than native
		
		
		int h;
		assert(element != null):"String is null";
		return ((size-1) &( (element == null) ? 0 : (h = element.hashCode()) ^ (h >>> 16)));
	}
	
	public ArrayList<String> getArray(int index) {
		return table.get(index);
	}
	
	public ArrayList<String> getArray(String element) {
		return table.get(getHash(element));
	}
	
	public int getSize() {
		return size;
	}
}
