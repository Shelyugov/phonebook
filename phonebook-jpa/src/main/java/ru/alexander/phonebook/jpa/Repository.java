package ru.alexander.phonebook.jpa;

import ru.alexander.phonebook.entity.PersonalData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * Базовый репозиторий.
 */
public class Repository {

    private static final String QUERY_SELECT_ALL_PERSONAL_DATA = "FROM PersonalData";

    public Collection<PersonalData> getAllPersonalData() {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PhonebookPersistence");
        final EntityManager em = factory.createEntityManager();
        final Collection<PersonalData> personalDataCollection = em.createQuery(QUERY_SELECT_ALL_PERSONAL_DATA, PersonalData.class).getResultList();
        em.close();
        return personalDataCollection;
    }

    public void save(PersonalData personalData) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PhonebookPersistence");
        final EntityManager em = factory.createEntityManager();
        em.persist(personalData);
        em.close();
    }
}
