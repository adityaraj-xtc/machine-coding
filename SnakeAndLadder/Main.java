import player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> snake_start = new ArrayList<>(Arrays.asList(62,33,49,88,41,56,98,93,95));
        ArrayList<Integer> snake_end = new ArrayList<>(Arrays.asList(5,6,9,16,20,53,64,73,75));
        ArrayList<Integer> ladder_start = new ArrayList<>(Arrays.asList(2,27,10,51,61,65,71,81));
        ArrayList<Integer> ladder_end = new ArrayList<>(Arrays.asList(37,46,32,68,79,84,91,100));
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(
                new Player("Gaurav"),
                new Player("Sagar")
        ));
        Game game = new Game(snake_start, snake_end, ladder_start, ladder_end, players);
        game.start_game();
    }
}
