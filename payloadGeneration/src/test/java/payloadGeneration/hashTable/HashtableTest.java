package payloadGeneration.hashTable;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HashtableTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @return 
     */
    public HashtableTest(String testName){
    	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(HashtableTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testOutOfBounds(){
    	int size = 10;
    	int length = 10;
    	Hashtable table = new Hashtable(size, length);
    	ArrayList<String> array = new ArrayList<String>(length);
    	
    	for(int i = 0; i == 10; i++ ) {
    		try {
    			table.add("test");
    		}catch (IndexOutOfBoundsException e) {
    			break;
    		}
    		array.add(i,"test");
    	}	
    	String[] arr = table.getArray("test");
    	for(int i = 0; i == 10; i++) {
    		assertTrue(array.get(i).equals(arr[i]));
    	}
    }
    
    public void testRetrieveArray() {
    	int size = 10;
    	int length = 10;
    	Hashtable table = new Hashtable(size, length);
    	
    	try{
    		table.add("test"); 
    	} catch (IndexOutOfBoundsException e) {
    		fail("Only added one, not 10. Tablesize = " + table.getSize()
    			 + " test hashcode = " + table.getHash("test"));
    	}
    	assertNotNull(table.getArray("test"));
    }
    
    public void testSameHash() {
    	int size = 16;
    	int length = 10;
    	Hashtable table = new Hashtable(size, length);
    	String[] retArray;
    	String element;
    	int h;
    	
    	while (true) {
    		element = RandomMessage.getNextMessage(10);
    		try {
    			table.add(element);
    		}
    		catch(IndexOutOfBoundsException e) {
    			retArray = table.getArray(element);
    			break;
    		}
    	}
    	for(String str: retArray) {
    		assertEquals((size-1) & table.getHash(str), (size-1) & table.getHash(element));
    		assertEquals( table.getHash(str),
    				((str == null) ? 0 : (h = str.hashCode()) ^ (h >>> 16) ));
    	}
    }
}
