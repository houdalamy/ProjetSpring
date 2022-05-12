package com.example.projetBackend.model.entity;


import javax.persistence.*;
import java.time.LocalDate;

/*@Entity
@Table(name = "clients")*/
@MappedSuperclass
public class Client {


   /* @Id
    private long personId;*/
    private String nom;
    private String adresseClient;


    public Client() {

    }

    public Client( String nom,  String adresseClient) {

      // this.personId = personId;
        this.nom = nom;
        this.adresseClient = adresseClient;

    }


    /*public long getPersonId() {
       return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
*/
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }


    // @Column(name = "nom_client" )

/*
    @Column(name = "nmr_registre_nationale"  , unique = true)
    private String nmrRegistreNationale ;

    @Column(name = "prenom_client" )
    private String prenom ;

    @Column(name = "date_naissance_client" )
    private LocalDate dateNaissance ;

    @Column(name = "nationalite_client" )
    private String nationalite;

    */







}
