package payloadGeneration.hashTable;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
import payloadGeneration.hashTable.HashTableMain.HashOrder;

/**
 * Unit test for simple App.
 */
public class MainTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @return 
     */
    public MainTest(String testName){
    	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(MainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSort() {
    	HashOrder order = new HashOrder();
    	if(order.compare("hej", "då") != ("hej".hashCode() - "då".hashCode())) {
    		fail("Wrong order in compare");
    	}
    	String[] strings1 = {"hej", "då"};
    	String[] strings2 = {"då", "hej"};
    	
    	Arrays.sort(strings1, order);
    	Arrays.sort(strings2, order);
    	
    	assertEquals(strings1[0], strings2[0]);
    }
}