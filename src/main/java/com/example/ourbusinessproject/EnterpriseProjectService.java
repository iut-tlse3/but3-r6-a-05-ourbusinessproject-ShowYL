package com.example.ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Project newProject(String title, String description, Enterprise enterprise) {
        Project p = new Project();
        p.setTitle(title);
        p.setDescription(description);
        p.setEnterprise(enterprise);
        this.entityManager.persist(p);
        this.entityManager.flush();
        enterprise.addProject(p);
        return p;
    }

    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail) {
        Enterprise e = new Enterprise();
        e.setName(name);
        e.setDescription(description);
        e.setContactName(contactName);
        e.setContactEmail(contactEmail);
        this.entityManager.persist(e);
        this.entityManager.flush();
        return e;
    }

    public Project findProjectById(Long id) {
        return this.entityManager.find(Project.class, id);
    }

    public Enterprise findEnterpriseById(Long id) {
        return this.entityManager.find(Enterprise.class, id);
    }

    public List<Project> findAllProjects() {
        String q = "SELECT p FROM Project p ORDER BY p.title";
        TypedQuery<Project> res = this.entityManager.createQuery(q, Project.class);
        return res.getResultList();
    }
}
