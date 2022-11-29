package com.mypack.mypack.entities;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.List;

@Named("manager_bean")
@RequestScoped
@Entity
@Table(name = "managers")
public class Manager extends Person{

     @ManyToOne
     private Admin admin;

    @OneToMany(mappedBy = "manager")
    private List<Center> centers;

    @OneToMany(mappedBy="manager",fetch = FetchType.EAGER)
    private List<Driver> drivers;

    @OneToMany(mappedBy = "manager",fetch = FetchType.EAGER)
    private List<Manager_Product> products;

    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Center> getCenters() {

        return centers;
    }

    public void setCenters(List<Center> centers) {
        this.centers = centers;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public List<Manager_Product> getProducts() {
        return products;
    }

    public void setProducts(List<Manager_Product> products) {
        this.products = products;
    }


}