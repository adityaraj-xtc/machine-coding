package dice;

import java.util.Random;

public class SimpleRolling implements RollingStrategy{
    private static final Integer DICE_SIZE = 6;
    private final Random random;

    public SimpleRolling(){
        random = new Random();
    }
    @Override
    public Integer getNumber() {
        return random.nextInt(1,DICE_SIZE + 1);
    }
}
