package com.example.ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Project newProject(String title, String description){
        Project p = new Project();
        p.setTitle(title);
        p.setDescription(description);
        this.entityManager.persist(p);
        this.entityManager.flush();
        return p;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail){
        Enterprise e = new Enterprise();
        e.setName(name);
        e.setDescription(description);
        e.setContactName(contactName);
        e.setContactEmail(contactEmail);
        this.entityManager.persist(e);
        this.entityManager.flush();
        return e;
    }

    public Project findProjectById(Long id){
        return this.entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id){
        return this.entityManager.find(Enterprise.class, id);
    }
}
