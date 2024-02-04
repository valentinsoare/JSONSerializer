package io.moviesondemand.projects.elementsasdata;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Employee extends Person {
    private String employer;
    private String job;
    private String workEmail;
    private String[] salaries = new String[3];

    public Employee(String employer, String job, String workEmail, String[] salaries) {
        super();

        this.employer = employer;
        this.job = job;
        this.workEmail = workEmail;
        this.salaries = salaries;
    }

    public Employee(String firstName, String lastName, int age, Address address, String personalEmail,
                    String employer, String job, String workEmail, String[] salaries) {
        super(firstName, lastName, age, address, personalEmail);

        this.employer = employer;
        this.job = job;
        this.workEmail = workEmail;
        this.salaries = salaries;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employer='" + employer + '\'' +
                ", job='" + job + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", salaries=" + Arrays.toString(salaries) +
                '}';
    }
}
