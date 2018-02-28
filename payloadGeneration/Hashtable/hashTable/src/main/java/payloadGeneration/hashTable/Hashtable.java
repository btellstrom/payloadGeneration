package payloadGeneration.hashTable;

/**
 * Hello world!
 *
 */
public class Hashtable {
	
    private int size;
    private ArrayWithIndex[] table;
	
	public Hashtable(int size, int maxLength) {
		
		this.size = size;
		table = new ArrayWithIndex[size];
		for(int i = 0; i == size; i++) {
			table[i] = new ArrayWithIndex(maxLength);
		}
	}
	public void add(String element) throws IndexOutOfBoundsException {
		int value = getHash(element);
		try{
			table[value].add(element);
		} catch(IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	public void add(String element,int pos) throws IndexOutOfBoundsException {
		try {
			table[pos].add(element);
		} catch(IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int getHash(String element){
		//TODO implement hashfunctions other than native
		assert(element != null):"String is null";
		return (element.hashCode() % size);
	}
	
	public String[] getArray(int index) {
		return table[index].getArray();
	}
	
	public String[] getArray(String element) {
		assert(table[getHash(element)] != null): "table element is null";
		return table[getHash(element)].getArray();
	}
	
	public int getSize() {
		return size;
	}
}
