package ru.alexander.phonebook.jpa;

import ru.alexander.phonebook.entity.PersonalData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Базовый репозиторий.
 */
public class Repository {

    public void save(PersonalData personalData) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PhonebookPersistence");
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(personalData);
        em.getTransaction().commit();
    }
}
