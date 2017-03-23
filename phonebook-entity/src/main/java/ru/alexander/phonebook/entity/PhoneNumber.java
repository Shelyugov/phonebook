package ru.alexander.phonebook.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Номер телефона.
 */
@Entity
@Table(name = "phone_number")
public class PhoneNumber extends AbstractEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private PhonebookEntry entry;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(name = "phone_number_type")
    @Enumerated(EnumType.STRING)
    private PhoneNumberType phoneNumberType;

    public PhonebookEntry getEntry() {
        return entry;
    }

    public void setEntry(PhonebookEntry entry) {
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
