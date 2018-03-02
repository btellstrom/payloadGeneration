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
    	ArrayList<String> arr = table.getArray("test");
    	for(int i = 0; i == 10; i++) {
    		assertTrue(array.get(i).equals(arr.get(i)));
    	}
    }
    
    public void testRetrieveArray() {
    	int size = 10;
    	int length = 10;
    	Hashtable table = new Hashtable(size, length);
    	
    	try{
    		table.add("test"); // Seems to be a problem with add
    	} catch (IndexOutOfBoundsException e) {
    		fail("Only added one, not 10. Tablesize = " + table.getSize()
    			 + " test hashcode = " + table.getHash("test"));
    	}
    	assertNotNull(table.getArray("test"));
    }
}
