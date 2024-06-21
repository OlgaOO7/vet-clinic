package main.java.com.magicvet.model;

public class Cat extends Pet{
//    private Age age;
//    private String size;
    private Sex sex;
    private HealthState healthState;

    public Cat() {};

//    public Cat(Age age) {
//        super(age);
//    }

    public Cat(Sex sex) {
        super(sex);
    }

    public Cat(HealthState healthState) {
        super(healthState);
    }

}
