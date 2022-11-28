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
    private int managerId;
    private int adminId;

    //forign key to manager
    @ManyToOne
    @JoinColumn(name = "managerId", insertable = false, updatable = false)
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public Center(String name, String ville, String rue, int managerId, int adminId) {
        this.name = name;
        this.ville = ville;
        this.rue = rue;
        this.managerId = managerId;
        this.adminId = adminId;
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

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public int getManagerId() {
        return managerId;
    }

    public int getAdminId() {
        return adminId;
    }



}