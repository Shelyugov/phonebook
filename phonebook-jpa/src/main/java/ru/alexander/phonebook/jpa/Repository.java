package ru.alexander.phonebook.jpa;

import ru.alexander.phonebook.entity.PersonalData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Базовый репозиторий.
 */
public class Repository {

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
