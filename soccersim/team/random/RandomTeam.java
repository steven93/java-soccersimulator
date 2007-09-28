package soccersim.team.random;

import soccersim.team.Team;
import soccersim.team.Player;
import soccersim.base.DefendingSide;

import java.util.ArrayList;

/**
 * Random soccer. All four players move in random directions.
 * @author Tucker Balch	tucker@cc.gatech.edu, java port by frank hadder, frank.hadder@gmail.com
 * @version 1.0
 */
public class RandomTeam extends Team {

    /**
     * Creates a RandomTeam that defends the given side.
     * @param side the side the team is defending.
     */
    public RandomTeam(DefendingSide side) {
		super(side);
		this.players = initializePlayers();
	}

    /**
     * Initialize the players.
     * @return a list of all the players for this team.
     */
    private ArrayList<Player> initializePlayers() {
		ArrayList<Player> newPlayers = new ArrayList<Player>(NUMBER_OF_PLAYERS);

		for (int playerIndex = 0; playerIndex < NUMBER_OF_PLAYERS; playerIndex++) {
			newPlayers.add(new RandomPlayer(this, playerIndex + 1));
		}

		return newPlayers;
	}

    /**
     * Returns the team name.
     * @return the team name.
     */
    public String getName() {
		return "The Random Rangers";
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
