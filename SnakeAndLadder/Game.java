import completion.CompletionStrategy;
import completion.SingleWinCompletion;
import dice.SimpleRolling;
import exceptions.OutOfBoundException;
import player.Player;
import player.PlayerSelectionStrategy;
import player.SingleWinnerPlayerSelectionStrategy;

import java.util.ArrayList;

public class Game {
    private final Board board;
    private final Integer size;
    private final ArrayList<Player> players;
    private final Dice dice;
    private final CompletionStrategy completionStrategy;
    private final PlayerSelectionStrategy playerSelectionStrategy;
    Game(ArrayList<Integer> snake_start, ArrayList<Integer> snake_end, ArrayList<Integer> ladder_start, ArrayList<Integer> ladder_end, ArrayList<Player> players){
        this.players = players;
        this.size = 100;
        board = new Board(size, snake_start, snake_end, ladder_start, ladder_end);
        dice = new Dice(new SimpleRolling());
        completionStrategy = new SingleWinCompletion(size);
        playerSelectionStrategy = new SingleWinnerPlayerSelectionStrategy(players);
    }

    public void start_game(){
        Player lastPlayer = null;
        while(!completionStrategy.isComplete(players, lastPlayer)){
            Player currentPlayer = playerSelectionStrategy.getNextPlayer();
            Integer currentPosition = currentPlayer.getPosition();
            Integer steps = dice.getNumber();
            try {
                Integer newPosition = board.movePlayer(currentPlayer, steps);
                System.out.println(currentPlayer.getName() + " rolled a " + steps + " and moved from " + currentPosition + " to " + currentPlayer.getPosition());
                if(newPosition.equals(size)){
                    System.out.println(currentPlayer.getName() + " wins the game");
                }
            } catch (OutOfBoundException e) {
                System.out.println("Player " + currentPlayer.getName() + " cannot move " + steps + " steps");
            }

            lastPlayer = currentPlayer;
        }
    }

}
