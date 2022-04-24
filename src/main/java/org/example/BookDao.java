package org.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.merge(book);
    }

    public Book get(BigInteger id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        Query query = entityManager
                .createQuery("SELECT b from Book b");
        return query.getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager
                .createQuery("SELECT b from Book b where b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findAll(Integer rating) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);

        List<Predicate> allPredicates = new ArrayList<>();
        if (rating != null) {
            Predicate ratingPredicate = criteriaBuilder.equal(root.get("rating"), rating);
            allPredicates.add(ratingPredicate);
        }
        criteriaQuery.where(criteriaBuilder.and(allPredicates.toArray(new Predicate[0])));

        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
