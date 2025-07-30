package strategypattern;

import strategypattern.strategy.DriveStrategy;
import strategypattern.strategy.NormalDriveStrategy;

public class Goodsvehicle extends Vehicle{

    Goodsvehicle() {
        super(new NormalDriveStrategy());
    }
}
