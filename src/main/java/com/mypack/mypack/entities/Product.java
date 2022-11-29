package com.mypack.mypack.entities;

import com.mypack.mypack.enums.CATEGORIE;
import com.mypack.mypack.enums.STATUS;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Named("product_bean")
@RequestScoped
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String referance;

    @Enumerated(EnumType.ORDINAL)
    private CATEGORIE categorie;

    private double weight;

    @Enumerated(EnumType.ORDINAL)
    private STATUS status;

    private String recieverAdress;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Manager_Product> managers;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Product_Driver> drivers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public CATEGORIE getCategorie() {
        return categorie;
    }

    public void setCategorie(CATEGORIE categorie) {
        this.categorie = categorie;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getRecieverAdress() {
        return recieverAdress;
    }

    public void setRecieverAdress(String recieverAdress) {
        this.recieverAdress = recieverAdress;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Manager_Product> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager_Product> managers) {
        this.managers = managers;
    }

    public List<Product_Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Product_Driver> drivers) {
        this.drivers = drivers;
    }
}
