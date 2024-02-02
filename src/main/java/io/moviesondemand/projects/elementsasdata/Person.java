package io.moviesondemand.projects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private String personalEmail;

    protected Person() {}

    protected Person(String firstName, String lastName, int age, Address address, String personalEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.personalEmail = personalEmail;
    }

    @Override
    public String toString() {
        return"firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", personalEmail='" + personalEmail + '\'';
    }
}
