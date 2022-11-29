package com.mypack.mypack.entities;

import com.mypack.mypack.enums.TYPE;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private TYPE type;

    private String matricule;

    @OneToOne
    private Driver driver;
}
