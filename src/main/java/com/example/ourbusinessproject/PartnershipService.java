package com.example.ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PartnershipService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Partnership newPartnership(Project p, Enterprise partner) {
        var partnership = new Partnership();
        partnership.setProject(this.entityManager.merge(p));
        partnership.setEnterprise(this.entityManager.merge(partner));
        partnership.setCreationDate(new Date());
        this.entityManager.persist(partnership);
        this.entityManager.flush();
        return partnership;
    }

    @Transactional
    public void remove(Partnership partnership) {
        this.entityManager.remove(this.entityManager.merge(partnership));
        this.entityManager.flush();
    }

    public Partnership findPartnershipById(Long id) {
        String query = "SELECT p FROM Partnership p WHERE p.id = :id";
        TypedQuery<Partnership> typedQuery = this.entityManager.createQuery(query, Partnership.class);
        typedQuery.setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
