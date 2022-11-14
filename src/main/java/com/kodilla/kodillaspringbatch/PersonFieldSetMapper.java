package com.kodilla.kodillaspringbatch;

import net.bytebuddy.asm.Advice;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonFieldSetMapper implements FieldSetMapper {
    @Override
    public Object mapFieldSet(FieldSet fieldSet) throws BindException {
        PersonInput personInput = new PersonInput();
        personInput.setFirstname(fieldSet.readString("firstname"));
        personInput.setLastname(fieldSet.readString("lastname"));

        String dateString = fieldSet.readString("dateOfBirth");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);

        personInput.setDateOfBirth(date);

        return personInput;
    }
}
