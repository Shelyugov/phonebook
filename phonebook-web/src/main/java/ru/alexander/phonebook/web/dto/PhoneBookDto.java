package ru.alexander.phonebook.web.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO элемента телефонной книги.
 */
public class PhoneBookDto implements Serializable {

    private String name;

    private String surname;

    private Set<PhoneDto> phoneDtos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<PhoneDto> getPhoneDtos() {
        return phoneDtos;
    }

    public void setPhoneDtos(Set<PhoneDto> phoneDtos) {
        this.phoneDtos = phoneDtos;
    }
}
