package com.vivekchutke.reactive.ReactiveProgramming.sampleclasses;

import java.util.Arrays;
import java.util.List;

public class FunctionalProgrammingRunner {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple","Banana","Cat","Rat");
        System.out.println(list);
        list.stream().forEach(element ->System.out.println(element));
        List<Integer> listNumber = Arrays.asList(1,2,4,5,6,7,78,8,7);
        //Filtering and prinitng in process
        listNumber.stream().filter(number -> number > 5).forEach(number ->  System.out.println("Numbers more then 10 are:"+number));
        //Example two
        list.stream().filter(text -> text.contains("t")).forEach(text -> System.out.println("text is:"+text));
    }
}

