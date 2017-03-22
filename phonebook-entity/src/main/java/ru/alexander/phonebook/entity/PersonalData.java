package ru.alexander.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Персональные данные.
 */
@Entity
public class PersonalData extends AbstractEntity implements Serializable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

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

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
