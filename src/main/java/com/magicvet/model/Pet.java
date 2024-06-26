package main.java.com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {
    protected static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
//    private String sex;
    private Sex sex;
//    private Age age;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet() {};

    public Pet (Sex sex) {this.sex = sex;}
    public Pet (HealthState healthState) {this.healthState = healthState;}

    @Override
    public String toString() {
        return "\n\t\tPet { " + "\n\t\t\ttype = " + type
                + ", sex = " + sex.toString()
                + ", age = " + age
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ", healthState = " + healthState.toString()
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "\n\t\t}";
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

public void setSex(Sex sex) {
    this.sex = sex;
}
    public Sex getSex() {
        return sex;
    }

public String  getAge() {
        return age;
}

public void setAge (String age) {this.age = age;}
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

    public enum Sex {
        MALE("male"),
        FEMALE("female"),
        UNKNOWN("unknown"),
        ;

        private final String sexValue;

        @Override
        public String toString() {
            return String.valueOf(sexValue);
        }

        Sex(String sexValue) {this.sexValue = sexValue;}

        public String getSexValue() {return sexValue;}
    }

    public enum HealthState {
        HEALTHY("healthy"),
        RECOVERY("recovery"),
        CRITICAL("critical"),
        CHRONIC_ILLNESS("chronic illness"),
        MINOR_ILLNESS("minor illness"),
        SERIOUS_ILLNESS("serious illness"),
        UNKNOWN("unknown"),
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
