package org.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book){
        entityManager.persist(book);
    }

    public Book get(BigInteger id){
        //
        return entityManager.find(Book.class, id);
        //
    }
}
