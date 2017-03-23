package ru.alexander.phonebook.services;

import ru.alexander.phonebook.entity.PersonalData;
import ru.alexander.phonebook.entity.PhoneNumber;
import ru.alexander.phonebook.entity.PhoneNumberType;
import ru.alexander.phonebook.entity.PhonebookEntry;
import ru.alexander.phonebook.jpa.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * Класс, содержащий бизнес-логику добавления и удаления записей в телефонную книгу.
 */
public class PhonebookEntryService {

    private final Repository repository = new Repository();

    public Collection<PhonebookEntry> get() {
        return repository.getAllPhoneEntries();
    }

    public PhonebookEntry get(final Long id) {
        if (id == null || id < 0) throw new IllegalArgumentException();
        return repository.getPhoneEntryById(id);
    }

    public void create(
            final String name,
            final String surname,
            final String phone,
            final PhoneNumberType type
    ) {
        processModification(name, surname, phone, type, true);
    }

    public void update(
            final String name,
            final String surname,
            final String phone,
            final PhoneNumberType type
    ) {
        processModification(name, surname, phone, type, false);
    }

    private void processModification(
            final String name,
            final String surname,
            final String phone,
            final PhoneNumberType type,
            final boolean addWhenNone) {
        final EntityManager em = repository.getEntityManager();
        em.getTransaction().begin();
        PhonebookEntry entry = repository.findByPersonalData(em, name, surname);

        if (entry == null && addWhenNone) {
            PersonalData pd;
            pd = new PersonalData();
            pd.setName(name);
            pd.setSurname(surname);
            pd = em.merge(pd);

            entry = new PhonebookEntry();
            entry.setPerson(pd);
            entry = em.merge(entry);
        }
        if ((entry == null) == addWhenNone) {
            final PhoneNumber number = new PhoneNumber();
            number.setNumber(phone);
            number.setPhoneNumberType(type);
            number.setEntry(entry);
            em.merge(number);
        }

        em.getTransaction().commit();
        em.close();
    }

    public void delete(final Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException();
        repository.delete(id);
    }
}
