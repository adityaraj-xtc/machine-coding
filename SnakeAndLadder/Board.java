import exceptions.OutOfBoundException;
import player.Player;

import java.util.*;

public class Board {
    private final int size;
    private final HashMap<Integer, Integer> snakes;
    private final HashMap<Integer, Integer> ladders;

    Board(int size, ArrayList<Integer> snake_start, ArrayList<Integer> snake_end, ArrayList<Integer> ladder_start, ArrayList<Integer> ladder_end){
        this.size = size;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        for(int i=0;i<snake_start.size();i++){
            snakes.put(snake_start.get(i), snake_end.get(i));
        }
        for(int i=0;i<ladder_start.size();i++){
            ladders.put(ladder_start.get(i), ladder_end.get(i));
        }
    }

    public Integer movePlayer(Player player, Integer steps) throws OutOfBoundException {
        int current_position = player.getPosition();
        if(current_position + steps > size){
            throw new OutOfBoundException();
        }
        current_position += steps;
        while(snakes.containsKey(current_position) || ladders.containsKey(current_position)){
            if(snakes.containsKey(current_position)){
                current_position = snakes.get(current_position);
            }
            else if(ladders.containsKey(current_position)){
                current_position = ladders.get(current_position);
            }
        }
        player.setPosition(current_position);
        return current_position;
    }
}
