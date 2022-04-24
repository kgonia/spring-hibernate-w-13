package org.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Publisher getById(Integer id){
        return entityManager.find(Publisher.class, id);
    }

    public List<Publisher> findAll(){
        return entityManager
                .createQuery("SELECT p from Publisher p")
                .getResultList();
    }
}
