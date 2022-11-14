package com.kodilla.kodillaspringbatch;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class PersonProcessor implements ItemProcessor<PersonInput, PersonOutput> {
    @Override
    public PersonOutput process(PersonInput item) throws Exception {
        return new PersonOutput(item.getFirstname(), item.getLastname(), LocalDate.now().getYear()-item.getDateOfBirth().getYear());
    }
}
