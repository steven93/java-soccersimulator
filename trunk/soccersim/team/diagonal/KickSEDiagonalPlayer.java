package soccersim.team.diagonal;

import soccersim.team.Player;
import soccersim.team.Team;
import soccersim.team.PlayerNeighborState;
import soccersim.base.MoveDirection;

/**
 * Tries to kick the ball from the south-east
 * @author Tucker Balch	tucker@cc.gatech.edu, java port by frank hadder
 * @version 1.0
 */
public class KickSEDiagonalPlayer extends Player {

    /**
     * Constructs a new Player
     * @param team the team the player plays for
     * @param playerNumber the number of the player
     */
    public KickSEDiagonalPlayer(Team team, int playerNumber) {
        super(team, playerNumber);
    }

    /**
     * The strategy tries to move towards the ball and tries to kick the ball to the
     * from the SouthEast to the NorthWest.
     * @return the best move to make.
     */
    public MoveDirection chooseBestMove() {
        MoveDirection bestMove = null;

        if (localArea.get(MoveDirection.North) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.NorthEast) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.East) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.South;
        }
        if (localArea.get(MoveDirection.SouthEast) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.South;
        }
        if (localArea.get(MoveDirection.South) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.SouthWest) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.East;
        }
        if (localArea.get(MoveDirection.West) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.South;
        }
        if (localArea.get(MoveDirection.NorthWest) == PlayerNeighborState.Ball) {
            bestMove = MoveDirection.NorthWest;
        }

        if (bestMove == null) {
            bestMove = this.getBallDirection();
        }

        return bestMove;
	}
}
