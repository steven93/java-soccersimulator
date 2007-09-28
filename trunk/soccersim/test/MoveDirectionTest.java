package soccersim.test;

import soccersim.base.MoveDirection;
import junit.framework.TestCase;

public class MoveDirectionTest extends TestCase {

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
    	assert(MoveDirection.getDirection(0) != null);
    	assert(MoveDirection.getDirection(1) != null);
    	assert(MoveDirection.getDirection(2) != null);
    	assert(MoveDirection.getDirection(3) != null);
    	assert(MoveDirection.getDirection(4) != null);
    	assert(MoveDirection.getDirection(5) != null);
    	assert(MoveDirection.getDirection(6) != null);
    	assert(MoveDirection.getDirection(7) != null);
    	assert(MoveDirection.getDirection(8) != null);
    	assert(MoveDirection.getDirection(9) != null);
    	assert(MoveDirection.getDirection(100) != null);
    	assert(MoveDirection.getDirection(1351361361) != null);
    }
    
    public void testFlipDirection() {
    	assertEquals(MoveDirection.North, MoveDirection.North.flipDirectionHorizontal());
    	assertEquals(MoveDirection.NorthWest, MoveDirection.NorthEast.flipDirectionHorizontal());
    	assertEquals(MoveDirection.West, MoveDirection.East.flipDirectionHorizontal());
    	assertEquals(MoveDirection.SouthWest, MoveDirection.SouthEast.flipDirectionHorizontal());
    	assertEquals(MoveDirection.South, MoveDirection.South.flipDirectionHorizontal());
    	assertEquals(MoveDirection.SouthEast, MoveDirection.SouthWest.flipDirectionHorizontal());
    	assertEquals(MoveDirection.East, MoveDirection.West.flipDirectionHorizontal());
    	assertEquals(MoveDirection.NorthEast, MoveDirection.NorthWest.flipDirectionHorizontal());
    }
    
    public void testGetDirectionFromDegree() {
    	for (double i = -100.0; i < 1000.00; i += .01) {
    		double trueI = i % 360;
    		// east
    		if ((trueI > 0 && trueI < MoveDirection.East.getEndDegrees()) 
    				|| trueI > MoveDirection.East.getStartDegrees() && trueI < 360) {
    			assertEquals(MoveDirection.East, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.NorthEast.getStartDegrees() && trueI < MoveDirection.NorthEast.getEndDegrees()) {
    			assertEquals(MoveDirection.NorthEast, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.North.getStartDegrees() && trueI < MoveDirection.North.getEndDegrees()) {
    			assertEquals(MoveDirection.North, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.NorthWest.getStartDegrees() && trueI < MoveDirection.NorthWest.getEndDegrees()) {
    			assertEquals(MoveDirection.NorthWest, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.West.getStartDegrees() && trueI < MoveDirection.West.getEndDegrees()) {
    			assertEquals(MoveDirection.West, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.SouthWest.getStartDegrees() && trueI < MoveDirection.SouthWest.getEndDegrees()) {
    			assertEquals(MoveDirection.SouthWest, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.South.getStartDegrees() && trueI < MoveDirection.South.getEndDegrees()) {
    			assertEquals(MoveDirection.South, MoveDirection.getDirectionFromDegrees(i));
    		} else if (trueI > MoveDirection.SouthEast.getStartDegrees() && trueI < MoveDirection.SouthEast.getEndDegrees()) {
    			assertEquals(MoveDirection.SouthEast, MoveDirection.getDirectionFromDegrees(i));
    		}
    	}
    }
}
