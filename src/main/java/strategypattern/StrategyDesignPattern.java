package strategypattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyDesignPattern {
    public static void main(String[] args) {

        SpringApplication.run(StrategyDesignPattern.class, args);
    Vehicle vehicle = new OffRoadVehicle();
        vehicle.drive();
    }

}
