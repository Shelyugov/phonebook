package ru.alexander.phonebook.web.dto;

import java.io.Serializable;

/**
 * DTO, содержащая информацию о некотором номере телефона.
 */
public class PhoneDto implements Serializable {

    private String number;

    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
