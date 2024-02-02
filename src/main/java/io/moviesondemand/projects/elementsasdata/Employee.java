package io.moviesondemand.projects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends Person {
    private String employer;
    private String job;
    private String workEmail;

    public Employee(String employer, String job, String workEmail) {
        super();

        this.employer = employer;
        this.job = job;
        this.workEmail = workEmail;
    }

    public Employee(String firstName, String lastName, int age, Address address, String personalEmail, String employer, String job, String workEmail) {
        super(firstName, lastName, age, address, personalEmail);

        this.employer = employer;
        this.job = job;
        this.workEmail = workEmail;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                ", employer='" + employer + '\'' +
                ", job='" + job + '\'' +
                ", workEmail='" + workEmail + '\'' +
                '}';
    }
}
