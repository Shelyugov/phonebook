package ru.alexander.phonebook.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Элемент телефонной книги.
 */
@Entity
public class PhoneBookEntry extends AbstractEntity implements Serializable {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private PersonalData person;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entry")
    private Set<PhoneNumber> phoneNumbers;

    public PersonalData getPerson() {
        return person;
    }

    public void setPerson(PersonalData person) {
        this.person = person;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
