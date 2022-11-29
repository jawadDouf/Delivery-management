package com.mypack.mypack.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver extends Person{

    @ManyToOne
    private Manager manager;

    @OneToMany(mappedBy="driver",fetch = FetchType.EAGER)
    List<Product_Driver> products;


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Product_Driver> getProducts() {
        return products;
    }

    public void setProducts(List<Product_Driver> products) {
        this.products = products;
    }
}
