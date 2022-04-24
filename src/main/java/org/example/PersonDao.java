package org.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person){
        entityManager.persist(person);
    }
}
