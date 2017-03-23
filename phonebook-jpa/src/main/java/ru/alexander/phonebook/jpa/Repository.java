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
        return personalDataCollection;
    }

    public boolean save(PersonalData personalData) {
        boolean result = false;
        try {
            final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PhonebookPersistence");
            final EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(personalData);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
