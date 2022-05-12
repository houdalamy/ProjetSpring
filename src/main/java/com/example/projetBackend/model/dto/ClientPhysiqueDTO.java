package com.example.projetBackend.model.dto;

import com.example.projetBackend.model.entity.TypeCompteBancaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientPhysiqueDTO {

    private int id;

    private String nmrRegistreNationale;

    private String prenom;

    private long numeroClient;

    private LocalDate date_Naissance;

    private String nationalite;

    @JsonIgnore
    private List<ClientMoraleDTO> entreprises = new ArrayList<>();
    private List<String> entreprisesNmrTva;

    @JsonIgnore
    private List<CompteBancaireDTO> compteBancairesList = new ArrayList<>();
    private List<Integer> compteBancaireId ;

    public ClientPhysiqueDTO(String nmrRegistreNationale, String prenom, long numeroClient) {
        this.nmrRegistreNationale = nmrRegistreNationale;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
    }

    public static class ClientMoraleDTO {
        private String nmrTva;
        private String nomSiege;
        private String typeEntreprise;
        private LocalDateTime dateCreation;
        private LocalDate date_fermeture;
        private String lieu_siege;
        private double capital;

    public ClientMoraleDTO(String nmrTva, String nomSiege, String typeEntreprise, double capital) {
        this.nmrTva = nmrTva;
        this.nomSiege = nomSiege;
        this.typeEntreprise =typeEntreprise;

        }


    }


    public ClientPhysiqueDTO() {
    }

    public ClientPhysiqueDTO(String nmrRegistreNationale,
                             String prenom, long numeroClient,
                             LocalDate date_Naissance) {
        this.nmrRegistreNationale = nmrRegistreNationale;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
        this.date_Naissance = date_Naissance;
    }

    public static class CompteBancaireDTO{
        private int compteBancaireId;
        private String iban;
        private double solde;
        private LocalDate dateCreationCompteBancaire;
        private LocalDate dateFermetureCompteBancaire;
        private TypeCompteBancaire typeCompteBancaire;


        public CompteBancaireDTO(int compteBancaireId, String iban, double solde,
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

    public List<ClientMoraleDTO> getEntreprises() {

        return entreprises;
    }

    public void setEntreprises(List<ClientMoraleDTO> entreprises) {

        this.entreprises = entreprises;
    }

    public List<CompteBancaireDTO> getCompteBancaireDTOS() {

        return compteBancairesList;
    }

    public void setCompteBancaireDTOS(List<CompteBancaireDTO> compteBancairesList) {
        this.compteBancairesList = compteBancairesList;
    }

    public List<String> getEntreprisesNmrTva() {
        return this.entreprises.stream()
                .map(elem -> elem.nmrTva)
                .collect(Collectors.toList());
    }


    public List<Integer> getCompteBancaireId() {
        return this.compteBancairesList.stream()
                .map(elem -> elem.compteBancaireId)
                .collect(Collectors.toList());
    }



    @Override
    public String toString() {
        return "ClientPhysiqueDTO{" +
                "id=" + id +
                ", Numero registre nationale='" + nmrRegistreNationale + '\'' +
                ", nom ='" + prenom + '\'' +
                ", entreprise=" + entreprises +
                '}';
    }


}
