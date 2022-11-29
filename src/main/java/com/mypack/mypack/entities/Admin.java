package com.mypack.mypack.entities;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Named("admin_bean")
@RequestScoped
@Entity
@Table(name = "admin")
public class Admin extends Person{

    @OneToMany(mappedBy = "admin",fetch = FetchType.EAGER)
    private List<Manager> managers;

    @OneToMany(mappedBy = "admin",fetch = FetchType.EAGER)
    private List<Center> centers;

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }
}