package soccersim.test;

import junit.framework.TestCase;
import soccersim.base.DefendingSide;
import soccersim.base.Score;

public class ScoreTest extends TestCase {

	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() {
    	basicScore = new Score();
    } 

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() {
    	basicScore = null;
    }
    
	private Score basicScore; 
    
    public void testConstructorPass() {
    	assert(basicScore != null);
    }
    
    public void testIncrementScore() {
    	basicScore.incrementScore(DefendingSide.East);
    	assertEquals(1, basicScore.getScore(DefendingSide.East));
    	assertEquals(0, basicScore.getScore(DefendingSide.West));
    }
    
    public void testGetScore() {
    	assertEquals(0, basicScore.getScore(DefendingSide.East));
    }
    
}
