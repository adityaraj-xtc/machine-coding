package player;

import java.util.ArrayList;

public class SingleWinnerPlayerSelectionStrategy implements PlayerSelectionStrategy{

    private final ArrayList<Player> players;
    private Integer currentPlayerIndex;
    public SingleWinnerPlayerSelectionStrategy(ArrayList<Player> players){
        currentPlayerIndex = -1;
        this.players = players;
    }
    @Override
    public Player getNextPlayer() {
        currentPlayerIndex++;
        currentPlayerIndex %= players.size();
        return players.get(currentPlayerIndex);
    }
}
