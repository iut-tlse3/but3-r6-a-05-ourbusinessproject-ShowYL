package com.example.ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @Size(min = 10)
    private String description;

    @NotNull
    @NotEmpty
    private String contactName;

    @NotNull
    @NotEmpty
    @Email
    private String contactEmail;

    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void addProject(Project p){
        if (this.projects == null){
            this.projects = new ArrayList<Project>();
        }
        this.projects.add(p);
    }

    public Collection<Project> getProjects() {
        return projects;
    }
}
