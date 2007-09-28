package soccersim.team.diagonal;

import soccersim.base.DefendingSide;
import soccersim.team.Player;
import soccersim.team.Team;

import java.util.ArrayList;

/**
 * The Diagonal Demons - Two players try to kick only in diagonals.
 * @author Tucker Balch	tucker@cc.gatech.edu, java port by frank hadder, frank.hadder@gmail.com
 * @version 1.0
 */
public class DiagonalTeam extends Team {

    /**
     * Creates a DiagonalTeam that defends the given side.
     * @param side the side the team is defending.
     */
    public DiagonalTeam(DefendingSide side) {
		super(side);
		this.players = initializePlayers();
	}

    /**
     * Initialize the players. Two players try to kick the ball to the east and two others
     * try to kick the ball to the NorthEast and SouthEast.
     * @return a list of all the players for this team.
     */
    private ArrayList<Player> initializePlayers() {
		ArrayList<Player> newPlayers = new ArrayList<Player>(NUMBER_OF_PLAYERS);

		newPlayers.add(new KickEDiagonalPlayer(this, 1));
        newPlayers.add(new KickNEDiagonalPlayer(this, 2));
        newPlayers.add(new KickSEDiagonalPlayer(this, 3));
        newPlayers.add(new KickEDiagonalPlayer(this, 4));

        return newPlayers;
	}

    /**
     * Returns the team name.
     * @return the team name.
     */
    public String getName() {
		return "The Diagonal Demons";
	}

	@Override
	public void gameOver() {}

	@Override
	public void initializeGame() {}

	@Override
	public void afterPoint() {}

	@Override
	public void afterPointLost() {}

	@Override
	public void afterPointWon() {}
}
