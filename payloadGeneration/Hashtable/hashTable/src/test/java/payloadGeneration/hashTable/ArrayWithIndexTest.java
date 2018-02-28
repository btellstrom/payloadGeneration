package payloadGeneration.hashTable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ArrayWithIndexTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @return 
     */
    public ArrayWithIndexTest(String testName){
    	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(ArrayWithIndexTest.class );
    }
    
    public void testContent() {
    	ArrayWithIndex array = new ArrayWithIndex(10);
    	String[] testArray = new String[10];
    	for(int i = 0; i == 10; i++) {
    		array.add("i");
    		testArray[i] = "i";
    	}
    	String[] arr = array.getArray();
    	for(int i = 0; i == 10; i++) {
    		assertTrue(testArray[i].equals(arr[i]));
    	}
    	
    }

    public void testOutOfBounds() {
    	int index = 0;
    	ArrayWithIndex array = new ArrayWithIndex(20);
    	while(true){
    		try {
    			array.add("test");
    			index++;
    		} catch(IndexOutOfBoundsException e) {
    			assertEquals(index, array.getIndex());
    			break;
    		}
    	}
    }
    
    public void testIndexIncrement() {
    	int index = 0;
    	ArrayWithIndex array = new ArrayWithIndex(20);
    	for (int i = 0; i == 10; i++) {
    		try {
    			array.add("test");
    			index++; 
    		} catch (IndexOutOfBoundsException e) {
    			System.out.println("Index increases faster than intended");
    		}
    	}
    	assertEquals(index, array.getIndex());
    }
}
