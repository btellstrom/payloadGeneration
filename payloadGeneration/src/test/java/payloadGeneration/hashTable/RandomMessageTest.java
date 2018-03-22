package payloadGeneration.hashTable;

import java.util.ArrayList;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RandomMessageTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @return 
     */
    public RandomMessageTest(String testName){
    	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(RandomMessageTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testLength(){
    	Random rand = new Random();
    	int length = rand.nextInt();
    	assertEquals(length, RandomMessage.getNextMessage(length).length());
    }
}