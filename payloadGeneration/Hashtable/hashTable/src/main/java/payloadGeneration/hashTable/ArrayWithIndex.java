package payloadGeneration.hashTable;

public class ArrayWithIndex {
	private String[] array;
	private int index;
	private int length;
	
	public ArrayWithIndex(int length) {
		array = new String[length];
		index = 0;
		this.length = length;
	}
	
	public void add(String element) throws IndexOutOfBoundsException{
		if (index == length) {
			throw new IndexOutOfBoundsException();
		}
		else {
			array[index] = element;
			index ++;
		}
	}
	
	public int getIndex() {
		return index;
	}
	
	public String[] getArray() {
		return array;
	}
}
