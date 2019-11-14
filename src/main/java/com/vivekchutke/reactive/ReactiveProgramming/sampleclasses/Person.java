package com.vivekchutke.reactive.ReactiveProgramming.sampleclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private @Getter String firstName;
    private @Getter String lastName;

    public String sayMyName() {
        return "My Name is: "+this.firstName+ " "+this.lastName;
    }
}
