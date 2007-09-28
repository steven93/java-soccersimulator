package soccersim.test;

import java.util.ArrayList;

import soccersim.base.DefendingSide;
import soccersim.base.Field;
import soccersim.base.GameHandler;
import soccersim.base.MoveDirection;
import soccersim.team.Player;
import soccersim.team.Team;
import soccersim.team.brute.BruteTeam;
import junit.framework.TestCase;

public class FieldTest extends TestCase {
	
	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() {
    	team1 = new BruteTeam(DefendingSide.East);
    	team2 = new BruteTeam(DefendingSide.West);
    	
    	ArrayList<Player> players = new ArrayList<Player>();
		players.addAll(team1.getPlayers());
		players.addAll(team2.getPlayers());
		
    	field = new Field(GameHandler.FIELD_WIDTH, GameHandler.FIELD_HEIGHT, players);
    	assert(field != null);
    }

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() {
    	field = null;
    }

    private Team team1;
	private Team team2;
	private Field field;
	
	public void testConstructor() {
		System.out.println(field.toString());
		assert(field != null);
	}
	
	public void testResetFieldOfPlay() {
		field.resetFieldOfPlay();
	}
	
	public void testUpdatePlayerInformation() {
		field.updatePlayerInformation();
	}
	
	public void testGetPlayer() {
		field.updatePlayerInformation();
		assertEquals(8, field.getPlayers().size());
		System.out.println("Test GetPlayer\n");
		for (Player player : field.getPlayers()) {
			System.out.print(player);
		}
		System.out.print("\n");
	}
	
	public void testMovePlayer() {
		System.out.println("Test MovePlayer");
		for (Player player : field.getPlayers()) {
			for (int i = 0; i < 50; i++) {
				field.movePlayer(MoveDirection.North, player);
			}
			System.out.print("(" + player.getXCoordinate() + "," + player.getYCoordinate() + ") ");
		}
		System.out.print("\n");
	}
}
