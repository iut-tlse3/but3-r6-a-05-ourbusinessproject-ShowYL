package com.example.ourbusinessproject;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Partnership {

    @NotNull
    private Date creationDate;

    @NotNull
    private Enterprise enterprise;

    @NotNull
    private Project project;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
