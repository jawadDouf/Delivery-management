package com.mypack.mypack.entities;

import com.mypack.mypack.enums.CATEGORIE;
import com.mypack.mypack.enums.STATUS;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    List<Manager_Product> managers;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    List<Product_Driver> drivers;

}
