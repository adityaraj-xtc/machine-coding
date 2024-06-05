package completion;

import player.Player;

import java.util.ArrayList;
import java.util.Objects;

public class SingleWinCompletion implements CompletionStrategy{
    private final Integer finalPosition;

    public SingleWinCompletion(Integer finalPosition){
        this.finalPosition = finalPosition;
    }
    @Override
    public boolean isComplete(ArrayList<Player> players, Player lastPlayer) {
        if(lastPlayer == null) return false;
        return Objects.equals(lastPlayer.getPosition(), finalPosition);
    }
}
