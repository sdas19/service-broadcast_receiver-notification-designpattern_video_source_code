package ittoolstraining.com.sampleproject.Builder;

public class CarBuilder {

    String engine;
    int wheel;
    String ac;

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setWheel(int wheel) {
        this.wheel = wheel;
        return this;

    }

    public CarBuilder setAc(String ac) {
        this.ac = ac;
        return this;

    }

    public Car build()
    {
        return new Car(engine,wheel,ac);
    }
}
