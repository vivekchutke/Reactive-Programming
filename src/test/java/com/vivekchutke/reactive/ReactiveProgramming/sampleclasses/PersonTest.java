package com.vivekchutke.reactive.ReactiveProgramming.sampleclasses;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class PersonTest {
    Person vc = new Person("Vivek", "Chutke");
    Person mb = new Person("Michael", "Bass");
    Person em = new Person("Elon", "Musk");

    @Test
    public void monoTest() {
        Mono<Person> monoPerson = Mono.just(vc);
        // Grabbing the Person Object from Mono Publisher
        Person p1 = monoPerson.block();
        log.info(p1.sayMyName());
    }

    @Test
    public void monoTrasform() {
        Mono<Person> monoPerson = Mono.just(mb);
        PersonCommand pc = monoPerson.map(p1 -> {return new PersonCommand(p1);}).block();
        log.info(pc.sayMyName());
    }

    //Validating for the NPE with filter
    @Test
    public void monoFilterTest() {
        Mono<Person> personMono = Mono.just(em);
        // Filter Example
        Person samAxe = personMono.filter(person -> person.getFirstName().equalsIgnoreCase("someDiffName")).block();
        Assertions.assertThrows(NullPointerException.class, ()->samAxe.sayMyName());
    }

    @Test
    public void fluxText() {
        Flux<Person> persons = Flux.just(vc,mb,em);
        persons.subscribe(person -> log.info(person.sayMyName()));
    }

    @Test
    public void fluxFilterTest() {
        Flux<Person> persons = Flux.just(vc,mb,em);
        persons.filter(person -> {return person.getFirstName().equalsIgnoreCase("Vivek");}).subscribe(p1 -> log.info(p1.sayMyName()));
    }

    @Test
    public void fluxTestDelay() {
        Flux<Person> persons = Flux.just(mb,vc,em);
        persons.delayElements(Duration.ofSeconds(2)).subscribe(p1 -> {log.info(p1.sayMyName());});
    }
//
//    public void fluxTestDelaybyPrintingOutput() {
//        Flux<Person> persons = Flux.just(em,mb,vc);
//        persons.delayElements(Duration.ofSeconds(1)).doOnComplete(countDownLatch::countDown).subscribe(p1 -> {log.info(p1.sayMyName());});
//
//    }

}
