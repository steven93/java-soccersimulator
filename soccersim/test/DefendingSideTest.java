package soccersim.test;

import soccersim.base.DefendingSide;
import junit.framework.TestCase;

public class DefendingSideTest extends TestCase {

	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() {} 

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() {} 
	
    public void testGetOppositeSide() {
    	assertEquals(DefendingSide.East, DefendingSide.West.getOppositeSide());
    	assertEquals(DefendingSide.West, DefendingSide.East.getOppositeSide());
    }
}
