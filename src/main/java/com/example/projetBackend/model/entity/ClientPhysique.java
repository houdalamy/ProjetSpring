package com.example.projetBackend.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "client_physique")
public class ClientPhysique extends Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id;

    @Column(name = "nmr_registre_nationale"  , unique = true)
    private String nmrRegistreNationale ;

    @Column(name = "prenom_client" )
    private String prenom ;


    @Column (name="numero_client")
    private long numeroClient ;

    @Column (name="date_naissance")
    private LocalDate date_Naissance ;

    @Column (name="date_deces" )
    private LocalDate date_deces ;

    @Column(name = "nationalite_client"  )
    private String nationalite;



  @ManyToMany
    @JoinTable(
            name = "Table_Entreprise_Gerants_Associations",
            joinColumns = @JoinColumn( name = "nmr_registre_nationale" ),
            inverseJoinColumns = @JoinColumn( name = "nmr_Tva" ))
    List<ClientMorale> listeDesEntreprises = new ArrayList<>();




  @ManyToMany
  @JoinTable(
          name = "Table_Client_comptesBancaire_Associations",
          joinColumns = @JoinColumn( name = "nmr_registre_nationale" ),
          inverseJoinColumns = @JoinColumn( name = "compte_bancaire_id" ))
  List<CompteBancaire> listeComptes = new ArrayList<>();


    public ClientPhysique() {

    }

    public ClientPhysique(String nmrRegistreNationale) {
        this.nmrRegistreNationale = nmrRegistreNationale;
    }

    public ClientPhysique(String nmrRegistreNationale, String prenom) {

        this.nmrRegistreNationale = nmrRegistreNationale;
        this.prenom = prenom;
    }

    public ClientPhysique(String nmrRegistreNationale, String prenom,
                          long numeroClient, LocalDate date_Naissance,
                          LocalDate date_deces, String nationalite)
    {
        this.nmrRegistreNationale = nmrRegistreNationale;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
        this.date_Naissance = date_Naissance;
        this.date_deces = date_deces;
        this.nationalite = nationalite;
    }

    public ClientPhysique(String nom, String adresseClient, String nmrRegistreNationale) {
        super(nom, adresseClient);
        this.nmrRegistreNationale = nmrRegistreNationale;
    }

    public String getNmrRegistreNationale() {
        return nmrRegistreNationale;
    }

    public void setNmrRegistreNationale(String nmrRegistreNationale) {
        this.nmrRegistreNationale = nmrRegistreNationale;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_Naissance() {
        return date_Naissance;
    }

    public void setDate_Naissance(LocalDate date_Naissance) {
        this.date_Naissance = date_Naissance;
    }

    public LocalDate getDate_deces() {
        return date_deces;
    }

    public void setDate_deces(LocalDate date_deces) {
        this.date_deces = date_deces;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public long getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(long numeroClient) {
        this.numeroClient = numeroClient;
    }

    public List<ClientMorale> getListeDesEntreprises() {
        return listeDesEntreprises;
    }

    public void setListeDesEntreprises(List<ClientMorale> listeDesEntreprises) {
        this.listeDesEntreprises = listeDesEntreprises;
    }

    public List<CompteBancaire> getListeComptes() {
        return listeComptes;
    }

    public void setListeComptes(List<CompteBancaire> listeComptes) {
        this.listeComptes = listeComptes;
    }
}
