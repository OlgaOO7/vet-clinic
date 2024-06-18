package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    private Age age;
    private Size size;

    public Dog() {};

//    public Dog(Size m) {
//        setType("dog");
//    }

    public Dog(Size size) {
        this.size = size;
    }

    public Dog(Age age) {
        super(age);
    }

    public Dog(HealthState healthState) {
        super(healthState);
    }

    @Override
    public String toString() {
        return "\n\t\tPet { " +
                "\n\t\t\t" +
                "type = " + getType() +
                ", sex = " + getSex() +
                ", age = " + getAge().toString() +
                ", name = " + getName() +
                ", ownerName = " + getOwnerName() +
                ", size=" + getSize() +
                ", healthState = " + getHealthState().toString() +
                ", registrationDate = " + getRegistrationDate().format(FORMATTER) +
                "\n\t}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0)
        ;
        private final int value;

        Size (int value) {
            this.value = value;
        }

        public static Size fromString(String value) {
            for(Size size: values()) {
                if (size.toString().equals(value)) {
                    return size;
                }
            }
            System.out.println("Unknown to parse value '" + value
                    + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }

        public int getValue() {
            return value;
        }
    }



}
