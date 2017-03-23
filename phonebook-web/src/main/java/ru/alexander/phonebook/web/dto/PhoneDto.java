package ru.alexander.phonebook.web.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * DTO, содержащая информацию о некотором номере телефона.
 */
@XmlRootElement
public class PhoneDto implements Serializable {

    public PhoneDto() {
    }

    public PhoneDto(String number, String type) {
        this.number = number;
        this.type = type;
    }

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
