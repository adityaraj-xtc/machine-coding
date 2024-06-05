import dice.RollingStrategy;

public class Dice implements RollingStrategy {

    private final RollingStrategy rollingStrategy;

    Dice(RollingStrategy rollingStrategy){
        this.rollingStrategy = rollingStrategy;
    }
    @Override
    public Integer getNumber() {
        return rollingStrategy.getNumber();
    }
}
