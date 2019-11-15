package com.vivekchutke.reactive.ReactiveProgramming.sampleclasses;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class FBNumberRunner {
    public static void main(String[] args) {

        List<Integer> intNumbers = Arrays.asList(3, 4, 35, 6, 63, 14, 23, 5, 24, 5, 3);

        // Adding the double number with FP without the initial number
        System.out.println(intNumbers.stream().reduce((d1, d2) -> d1 + d2));

        //Starting with the initial count of 100.00
        System.out.println(intNumbers.stream().reduce(100, (num1, num2) -> num1 + num2));

        //Another way of expressing the lamda function. Check the function part which is opened with a {}
        System.out.println(intNumbers.stream().reduce((d1, d2) -> {
            return sumoftwo(d1, d2);
        }));

        //Sorting using Streams
        intNumbers.stream().sorted().forEach(n1 -> System.out.println(n1));


        // Map Opertaiom
        intNumbers.stream().map(d1 -> d1 * 10).forEach(d2 -> System.out.println(d2));

        intNumbers.stream().filter(m1 -> m1 < 6).map(m2 -> m2 * m2).forEach(m3 -> System.out.println("Square of a number is:" + m3));

        Optional<Integer> reduceValue = intNumbers.stream().filter(m1 -> m1 < 6).map(m2 -> m2 * m2).reduce((m5, m6) -> m5 + m6);

        System.out.println(reduceValue.toString());
    }

    private static Integer sumoftwo(Integer d1, Integer d2) {
        System.out.println("Printing number d1 and d2:" + d1 + ":" + d2);
        return d1 + d2;
    }

}
