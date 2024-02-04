package io.moviesondemand.projects;

import io.moviesondemand.projects.elementsasdata.Address;
import io.moviesondemand.projects.elementsasdata.Employee;

public class Main {
    public static void main(String[] args) {

        Address vAddress = new Address("Lucretiu Patrascanu", 9,
                "21", 030504, "Bucuresti"
        );

        Employee vEmployee = new Employee("Valentin", "Soare", 36,
                vAddress,"soarevalentinn@gmail.com","Orange Services",
                "Software Engineer", "vsoare@orange.fr", new String[] {"4", "20", "100"}
        );

        try {
            String s = new Conversion().objectToJson(vEmployee, 0);
            System.out.printf("%n%s", s);
        } catch (IllegalAccessException ignored) {}
    }
}
