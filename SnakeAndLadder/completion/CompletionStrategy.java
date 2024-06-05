package completion;

import player.Player;

import java.util.ArrayList;

public interface CompletionStrategy {
    boolean isComplete(ArrayList<Player> players, Player lastPlayer);

}
