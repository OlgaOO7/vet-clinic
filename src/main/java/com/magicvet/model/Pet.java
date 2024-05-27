package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {
    protected static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private Age age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet() {};

    public Pet(Age age) {
        this.age = age;
    }

    public Pet (HealthState healthState) {this.healthState = healthState;}

    @Override
    public String toString() {
        return "Pet { " + "\n\t\ttype = " + type
                + ", sex = " + sex
                + ", age = " + age.toString()
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ", healthState = " + healthState.toString()
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "\n\t}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName, healthState, registrationDate);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }
    public HealthState getHealthState() {
        return healthState;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public enum Age {
        AGE1(1),
        AGE2(2),
        AGE3(3),
        AGE4(4),
        AGE5(5),
        AGE6(6),
        AGE7(7),
        AGE8(8),
        AGE9(9),
        AGE10(10),
        AGE11(11),
        AGE12(12),
        ;

        private final int ageValue;

        Age(int ageValue) {
            this.ageValue = ageValue;
        }

        public int getAgeValue() {
            return ageValue;
        }

        @Override
        public String toString() {
            return String.valueOf(ageValue);
        }

        public static Age fromValue(int value) {
            for (Age age : values()) {
                if (age.ageValue == value) {
                    return age;
                }
            }
            return null;
        }
    }

    public enum HealthState {
        HEALTHY("healthy"),
        RECOVERY("recovery"),
        CRITICAL("critical"),
        CHRONIC_ILLNESS("chronic illness"),
        MINOR_ILLNESS("minor illness"),
        SERIOUS_ILLNESS("serious illness")
        ;

        private final String healthValue;

        @Override
        public String toString() {
            return String.valueOf(healthValue);
        }

        HealthState(String healthValue) {
            this.healthValue = healthValue;
        }

        public String getHealthValue() {
            return healthValue;
        }
    }
}
