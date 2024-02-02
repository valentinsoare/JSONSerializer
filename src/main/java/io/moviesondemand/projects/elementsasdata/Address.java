package io.moviesondemand.projects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private int number;
    private String apartment;
    private int zipCode;
    private String city;

    public Address() {}

    public Address(String street, int number, String apartment, int zipCode, String city) {
        this.street = street;
        this.number = number;
        this.apartment = apartment;
        this.zipCode = zipCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", apartment='" + apartment + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                '}';
    }
}
