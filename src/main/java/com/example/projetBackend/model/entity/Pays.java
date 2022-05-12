package com.example.projetBackend.model.entity;


import javax.persistence.*;

// @Entity
@Table
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paysId;

    @Column(name = "nom_pays" )
    private String nomPays;


}
