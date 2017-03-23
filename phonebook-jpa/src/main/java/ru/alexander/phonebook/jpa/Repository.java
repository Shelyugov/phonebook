package ru.alexander.phonebook.jpa;

import ru.alexander.phonebook.entity.PhonebookEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * Базовый репозиторий.
 */
public class Repository {

    private static final String QUERY_SELECT_PHONEBOOK_ENTRIES = "SELECT DISTINCT e FROM PhonebookEntry e"
            + " JOIN FETCH e.person"
            + " JOIN FETCH e.phoneNumbers";

    private static final String QUERY_SELECT_PHONEBOOK_ENTRY_BY_PERSON = "SELECT DISTINCT e FROM PhonebookEntry e"
            + " JOIN FETCH e.person person"
            + " WHERE person.name = :name AND person.surname = :surname";

    private static final String BY_ID = " WHERE e.id = :id";

    private static final String QUERY_REMOVE_BY_ID = "FROM PhonebookEntry WHERE id = :id";

    private static final String PERSISTENCE_NAME = "PhonebookPersistence";

    public Collection<PhonebookEntry> getAllPhoneEntries() {
        final EntityManager em = getEntityManager();
        final Collection<PhonebookEntry> phones = em.createQuery(QUERY_SELECT_PHONEBOOK_ENTRIES, PhonebookEntry.class).getResultList();
        em.close();
        return phones;
    }

    public PhonebookEntry getPhoneEntryById(final Long id) {
        final EntityManager em = getEntityManager();
        final PhonebookEntry entry = em
                .createQuery(QUERY_SELECT_PHONEBOOK_ENTRIES, PhonebookEntry.class)
                .setParameter("id", id)
                .getSingleResult();
        em.close();
        return entry;
    }

    public void delete(long id) {
        final EntityManager em = getEntityManager();
        em.createQuery(QUERY_REMOVE_BY_ID).setParameter("id", id);
        em.close();
    }

    public EntityManager getEntityManager() {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        return factory.createEntityManager();
    }

    public PhonebookEntry findByPersonalData(final EntityManager em, String name, String surname) {
        return em
                .createQuery(QUERY_SELECT_PHONEBOOK_ENTRY_BY_PERSON, PhonebookEntry.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getSingleResult();
    }
}
