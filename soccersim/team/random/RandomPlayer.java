package soccersim.team.random;

import soccersim.team.Player;
import soccersim.team.Team;
import soccersim.base.MoveDirection;

import java.util.Random;

/**
 * Just wanders around randomly. A very poor strategy.
 * @author Tucker Balch	tucker@cc.gatech.edu, java port by frank hadder, frank.hadder@gmail.com
 * @version 1.0
 */
public class RandomPlayer extends Player {

    /**
     * Constructs a RandomPlayer
     * @param team the team the RandomPlayer plays with.
     * @param playerNumber the Number of the player.
     */
    public RandomPlayer(Team team, int playerNumber) {
		super(team, playerNumber);
	}

    /**
     * Get a random direction to move.
     * @return the direction to move.
     */
    public MoveDirection chooseBestMove() {
		return randomDirection();
	}

    /**
     * Just gets a random direction to move.
     * @return a random direction
     */
    private MoveDirection randomDirection() {
		Random generator = new Random();
		int randomNumber = generator.nextInt(8);

		return MoveDirection.getDirection(randomNumber);
	}

}
