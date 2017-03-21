package ru.alexander.phonebook.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Номер телефона.
 */
@Entity
public class PhoneNumber extends AbstractEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private PhoneBookEntry entry;

    @Column(nullable = false)
    private String number;

    private PhoneNumberType phoneNumberType;

    public PhoneBookEntry getEntry() {
        return entry;
    }

    public void setEntry(PhoneBookEntry entry) {
        this.entry = entry;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }
}
