package com.mypack.mypack.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person{


    @OneToMany(mappedBy ="client",fetch = FetchType.EAGER)
    private List<Product> products;


}
