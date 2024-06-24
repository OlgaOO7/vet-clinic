package main.java.com.magicvet.model;

public class Cat extends Pet{
    private Sex sex;
    private HealthState healthState;

    public Cat() {};

    public Cat(Sex sex) {
        super(sex);
    }

    public Cat(HealthState healthState) {
        super(healthState);
    }

}
