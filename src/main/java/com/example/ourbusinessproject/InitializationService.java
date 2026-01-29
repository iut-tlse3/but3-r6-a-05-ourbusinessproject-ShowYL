package com.example.ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    private Project project1E1;
    private Project project2E1;
    private Project project1E2;

    @Transactional
    public void initProjects() {
        /*
        Cette méthode donne une transaction au sens sql ce qui fait que si une erreur se produit, un rollback a lieu.
         */
        enterprise1 = enterpriseProjectService.newEnterprise("Marc", "Ceci est une entreprise", "Marc", "faregrg@gmail.com");
        enterprise2 = enterpriseProjectService.newEnterprise("Bruno", "Ceci est une entreprise", "Bruno", "faregrg@gmail.com");

        project1E1 = enterpriseProjectService.newProject("title", "description", enterprise1);
        project1E2 = enterpriseProjectService.newProject("title", "description", enterprise2);
        project2E1 = enterpriseProjectService.newProject("title", "description", enterprise1);
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }
}
