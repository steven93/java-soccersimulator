package soccersim.team.diagonal;

import soccersim.team.Player;
import soccersim.team.Team;
import soccersim.base.MoveDirection;

/**
 * Tries to kick the ball from the east.
 * @author Tucker Balch	tucker@cc.gatech.edu, java port by frank hadder, frank.hadder@gmail.com
 * @version 1.0
 */
public class KickEDiagonalPlayer extends Player {

    /**
     * Constructs a new Player
     * @param team the team the player plays for
     * @param playerNumber the number of the player
     */
    public KickEDiagonalPlayer(Team team, int playerNumber) {
        super(team, playerNumber);
    }

    /**
     * The strategy tries to move towards the ball and tries to kick the ball to the east.
     * @return the best move to make.
     */
    public MoveDirection chooseBestMove() {
        MoveDirection bestMove;

		// assume we're kicking the ball to the west and defending the east
		switch(this.getBallDirection()) {
		case North : bestMove = MoveDirection.NorthEast; break;
		case NorthEast : bestMove = MoveDirection.NorthEast; break;
		case NorthWest : bestMove = MoveDirection.North; break;
		case West : bestMove = MoveDirection.West; break;
		case East : bestMove = MoveDirection.NorthEast; break;
		case South : bestMove = MoveDirection.SouthEast; break;
		case SouthEast : bestMove = MoveDirection.SouthEast; break;
		case SouthWest : bestMove = MoveDirection.South; break;
		default : bestMove = MoveDirection.North; break;
		}

        return bestMove;
	}
}
