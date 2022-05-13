package com.example.projetBackend.model.dto;

import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.TypeCompteBancaire;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompteBancaireDTO {

    private int compteBancaireId;
    private String iban;
    private double solde;
    private LocalDate dateCreationCompteBancaire;
    private LocalDate dateFermetureCompteBancaire;
    private TypeCompteBancaire typeCompteBancaire;

    @JsonIgnore
    private List<CompteBancaireDTO.ClientPhysiqueDTO> listeClients;
    private List<String> numeroRegistreClient;


    public CompteBancaireDTO() {

    }

    public CompteBancaireDTO(int compteBancaireId, String iban, double solde,
                             LocalDate dateCreationCompteBancaire,
                             LocalDate dateFermetureCompteBancaire,
                             TypeCompteBancaire typeCompteBancaire,
                             List<ClientPhysiqueDTO> listeClients) {
        this.compteBancaireId = compteBancaireId;
        this.iban = iban;
        this.solde = solde;
        this.dateCreationCompteBancaire = dateCreationCompteBancaire;
        this.dateFermetureCompteBancaire = dateFermetureCompteBancaire;
        this.typeCompteBancaire = typeCompteBancaire;
        this.listeClients = listeClients;
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





    public static class ClientPhysiqueDTO {

        private int id;

        private String nmrRegistreNationale;

        private String prenom;

        private long numeroClient;

        private LocalDate date_Naissance;

        private String nationalite;

        public ClientPhysiqueDTO( String nmrRegistreNationale,
                                 String prenom, long numeroClient,
                                  LocalDate date_Naissance,
                                  String nationalite) {

            this.nmrRegistreNationale = nmrRegistreNationale;
            this.prenom = prenom;
            this.numeroClient = numeroClient;
            this.date_Naissance = date_Naissance;
            this.nationalite = nationalite;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public long getNumeroClient() {
            return numeroClient;
        }

        public void setNumeroClient(long numeroClient) {
            this.numeroClient = numeroClient;
        }

        public LocalDate getDate_Naissance() {
            return date_Naissance;
        }

        public void setDate_Naissance(LocalDate date_Naissance) {
            this.date_Naissance = date_Naissance;
        }

        public String getNationalite() {
            return nationalite;
        }

        public void setNationalite(String nationalite) {
            this.nationalite = nationalite;
        }
    }

    public List<ClientPhysiqueDTO> getListeClients() {
        return listeClients;
    }

    public void setListeClients(List<ClientPhysiqueDTO> listeClients) {
        this.listeClients = listeClients;
    }

    public List<String> getNumeroRegistreClient() {
        return this.listeClients.stream()
                .map(elem -> elem.nmrRegistreNationale)
                .collect(Collectors.toList());
    }

    }
