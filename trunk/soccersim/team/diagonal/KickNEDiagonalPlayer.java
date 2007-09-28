package soccersim.team.diagonal;

import soccersim.team.Player;
import soccersim.team.Team;
import soccersim.team.PlayerNeighborState;
import soccersim.base.MoveDirection;

/**
 * Tries to kick the ball from the north-east
 * @author Tucker Balch	tucker@cc.gatech.edu, java port by frank hadder, frank.hadder@gmail.com
 * @version 1.0
 */
public class KickNEDiagonalPlayer extends Player {

    /**
     * Constructs a new Player
     * @param team the team the player plays for
     * @param playerNumber the number of the player
     */
    public KickNEDiagonalPlayer(Team team, int playerNumber) {
        super(team, playerNumber);
    }

    /**
     * The strategy tries to move towards the ball and tries to kick the ball to the 
     * from the NorthEast to the SouthWest.
     * @return the best move to make.
     */
    public MoveDirection chooseBestMove() {
        MoveDirection bestMove = null;

        if (localArea.get(MoveDirection.North) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.NorthEast) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.North;
        }
        if (localArea.get(MoveDirection.East) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.North;
        }
        if (localArea.get(MoveDirection.SouthEast) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.South) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.SouthWest) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.SouthWest;
        }
        if (localArea.get(MoveDirection.West) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.North;
        }
        if (localArea.get(MoveDirection.NorthWest) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.North;
        }

        if (bestMove == null) {
            bestMove = this.getBallDirection();
        }

        return bestMove;
	}
}
