package ru.alexander.phonebook.web.rest;

import javax.ejb.Stateless;
import java.util.UUID;

/**
 * Сервис телефонной книги. Создан для учебных целей.
 */
@Stateless
public class PhonebookService {
    public String getRandomPhoneNumber() {
        return "+7 (915)" + UUID.randomUUID().toString();
    }
}
