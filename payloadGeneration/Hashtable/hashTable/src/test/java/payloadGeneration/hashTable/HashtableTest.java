package payloadGeneration.hashTable;

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
    	String[] array = new String[length];
    	
    	for(int i = 0; i == 10; i++ ) {
    		System.out.println(i);
    		try {
    			table.add("test");
    		}catch (IndexOutOfBoundsException e) {
    			fail("Index out of bound");
    			break;
    		}
    		array[i] = "test";
    	}	
    	String[] arr = table.getArray("test");
    	for(int i = 0; i == 10; i++) {
    		assertTrue(array[i].equals(arr[i]));
    	}
    }
    
    public void testRetrieveArray() {
    	int size = 1;
    	int length = 1;
    	Hashtable table = new Hashtable(size, length);
    	table.add("test");
    	assertNotNull(table.getArray("test"));
    }
}
