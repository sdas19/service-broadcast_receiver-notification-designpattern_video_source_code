package ittoolstraining.com.sampleproject.Builder;

public class BuilderClientApp {

    Car car1 = new Car("normal",4,"normal ac"); // Normal constructor way (we should avoid it when arguments are more )

    // This is our builder pattern
    Car car2 = new CarBuilder()
            .setEngine("normal")
            .setWheel(4)
            .setAc("normal ac")
            .build();
}
