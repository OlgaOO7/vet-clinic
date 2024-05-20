package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "XL";

    public static final String age1 = "1";
    public static final String age2 = "2";
    public static final String age3 = "1";
    public static final String age4 = "4";
    public static final String age5 = "5";

    private String size;

    public Dog() {
        setType("dog");
    }

    public Dog(String size, String age) {
        this.size = size;
    }

    public Dog(String age) {
        super(age);
    }

    @Override
    public String toString() {
        return "Pet { " +
                "\n\t\t" +
                "type = " + getType() +
                ", sex = " + getSex() +
                ", age = " + getAge() +
                ", name = " + getName() +
                ", ownerName = " + getOwnerName() +
                ", size=" + size +
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

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

}
