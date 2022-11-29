package com.mypack.mypack.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "center")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String ville;
    private String rue;

    @ManyToOne
    private Admin admin;

    //forign key to manager
    @ManyToOne
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVille() {
        return ville;
    }

    public String getRue() {
        return rue;
    }




}