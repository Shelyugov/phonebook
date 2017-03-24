package ru.alexander.phonebook.services;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.jdbc.PersonalDataRepository;

import java.util.Collection;

/**
 * Класс, содержащий бизнес-логику работы с персональными данными людей в телефонной книге.
 *
 */
public class PersonalDataService {

    private final PersonalDataRepository repository = new PersonalDataRepository();

    public Collection<PersonalData> get() {
        return repository.getAllPersonalData();
    }

    public PersonalData get(final Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException();
        return repository.getPersonalData(id);
    }

    public boolean create(final String name, final String surname) {
        final PersonalData pd = new PersonalData(name, surname);
        return repository.create(pd);
    }

    public boolean update(final Long id, final String name, final String surname) {
        final PersonalData pd = new PersonalData(id, name, surname);
        return repository.update(pd);
    }

    public boolean delete(final Long id) {
        return id != null && id > 0 && repository.delete(id);
    }
}
