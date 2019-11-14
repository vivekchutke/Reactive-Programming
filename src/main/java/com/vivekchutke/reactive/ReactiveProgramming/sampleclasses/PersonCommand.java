package com.vivekchutke.reactive.ReactiveProgramming.sampleclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonCommand {
    private String firstName;
    private String lastName;
    public PersonCommand(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    public String sayMyName() {
        return "My Name is: "+this.getFirstName() + " " +this.lastName;
    }

    public static void main(String[] args) {
        PersonCommand pc = new PersonCommand();
        pc.setLastName("Chutke");
        pc.setFirstName("Vivek");
        System.out.println(pc.sayMyName());
    }

}
