package com.example.projetBackend.model.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "compte_bancaire")
public class CompteBancaire {

    @Id
    @Column (name = "compte_bancaire_id" ,unique = true)
    private int compteBancaireId;

    @Column (name = "compte_bancaire_IBAN" ,nullable = false)
    private String iban;

    @Column (name = "solde_compte" ,columnDefinition = "DECIMAL",nullable = false)
    private double solde;

    @Column(name = "date_creation_compteBancaire" ,nullable = false)
    private LocalDate dateCreationCompteBancaire;

    @Column(name = "date_fermeture_compteBancaire" ,nullable = true)
    private LocalDate dateFermetureCompteBancaire;

    /*public enum TypeCompteBancaire {
        COURANT,
        EPARGNE,
        TITRES,
        EPARGNE_A_LONG_TERME}

    private TypeCompteBancaire typeCompteBancaire;*/

    @Enumerated(EnumType.STRING)
    @Column(name="type_compteBancaire")
    private TypeCompteBancaire typeCompteBancaire;

@ManyToMany
@JoinTable(
        name = "Table_Client_comptesBancaire_Associations",
        joinColumns = @JoinColumn( name = "compte_bancaire_id" ),
        inverseJoinColumns = @JoinColumn( name = "id_client" ))
List<ClientPhysique> listeClients = new ArrayList<>();



    public CompteBancaire() {
    }

    public CompteBancaire(int compteBancaireId, String iban, double solde,
                          LocalDate dateCreationCompteBancaire,
                          LocalDate dateFermetureCompteBancaire,
                          TypeCompteBancaire typeCompteBancaire) {
        this.compteBancaireId = compteBancaireId;
        this.iban = iban;
        this.solde = solde;
        this.dateCreationCompteBancaire = dateCreationCompteBancaire;
        this.dateFermetureCompteBancaire = dateFermetureCompteBancaire;
        this.typeCompteBancaire = typeCompteBancaire;
    }

    public int getCompteBancaireId() {
        return compteBancaireId;
    }

    public void setCompteBancaireId(int compteBancaireId) {
        this.compteBancaireId = compteBancaireId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public LocalDate getDateCreationCompteBancaire() {
        return dateCreationCompteBancaire;
    }

    public void setDateCreationCompteBancaire(LocalDate dateCreationCompteBancaire) {
        this.dateCreationCompteBancaire = dateCreationCompteBancaire;
    }

    public LocalDate getDateFermetureCompteBancaire() {
        return dateFermetureCompteBancaire;
    }

    public void setDateFermetureCompteBancaire(LocalDate dateFermetureCompteBancaire) {
        this.dateFermetureCompteBancaire = dateFermetureCompteBancaire;
    }

    public TypeCompteBancaire getTypeCompteBancaire() {
        return typeCompteBancaire;
    }

    public void setTypeCompteBancaire(TypeCompteBancaire typeCompteBancaire) {
        this.typeCompteBancaire = typeCompteBancaire;
    }

    public List<ClientPhysique> getListeClients() {
        return listeClients;
    }

    public void setListeClients(List<ClientPhysique> listeClients) {
        this.listeClients = listeClients;
    }
}
