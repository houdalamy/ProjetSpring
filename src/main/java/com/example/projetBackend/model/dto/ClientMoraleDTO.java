package com.example.projetBackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ClientMoraleDTO {

    private String nmrTva;
    private String nomSiege;
    private String typeEntreprise;
    private LocalDateTime dateCreation;
    private LocalDate date_fermeture;
    private String lieu_siege;
    private double capital;

    @JsonIgnore
    private List<ClientMoraleDTO.ClientPhysiqueDTO> clientPhysique;

    public ClientMoraleDTO() {

    }

    public  static class ClientPhysiqueDTO{
    private int id;

    private String nmrRegistreNationale;

    private String prenom;

    private long numeroClient;

    private LocalDate date_Naissance;

    private String nationalite;

    public ClientPhysiqueDTO() {
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

        public ClientPhysiqueDTO(String nmrRegistreNationale,
                                 String prenom, long numeroClient,
                                 LocalDate date_Naissance) {
        this.nmrRegistreNationale = nmrRegistreNationale;
        this.prenom = prenom;
        this.numeroClient = numeroClient;
        this.date_Naissance = date_Naissance;
        }

    }






    public ClientMoraleDTO(String nmrTva, String nomSiege, String typeEntreprise,
                           LocalDateTime dateCreation,
                           LocalDate date_fermeture, String lieu_siege, double capital
                           ) {
        this.nmrTva = nmrTva;
        this.nomSiege = nomSiege;
        this.typeEntreprise = typeEntreprise;
        this.dateCreation = dateCreation;
        this.date_fermeture = date_fermeture;
        this.lieu_siege = lieu_siege;
        this.capital = capital;

    }

    public ClientMoraleDTO(String nmrTva, String nomSiege, String typeEntreprise) {
        this.nmrTva = nmrTva;
        this.nomSiege = nomSiege;
        this.typeEntreprise = typeEntreprise;
    }



    public String getNmrTva() {
        return nmrTva;
    }

    public void setNmrTva(String nmrTva) {
        this.nmrTva = nmrTva;
    }

    public String getNomSiege() {
        return nomSiege;
    }

    public void setNomSiege(String nomSiege) {
        this.nomSiege = nomSiege;
    }

    public String getTypeEntreprise() {
        return typeEntreprise;
    }

    public void setTypeEntreprise(String typeEntreprise) {
        this.typeEntreprise = typeEntreprise;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDate_fermeture() {
        return date_fermeture;
    }

    public void setDate_fermeture(LocalDate date_fermeture) {
        this.date_fermeture = date_fermeture;
    }

    public String getLieu_siege() {
        return lieu_siege;
    }

    public void setLieu_siege(String lieu_siege) {
        this.lieu_siege = lieu_siege;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public List<ClientPhysiqueDTO> getClientPhysique() {
        return clientPhysique;
    }

    public void setClientPhysique(List<ClientMoraleDTO.ClientPhysiqueDTO> clientPhysique) {
        this.clientPhysique = clientPhysique;
    }

   /* public String getClientPhysiqueNom_NumeroRegistre() {
        return clientPhysique.getPrenom() + " " + clientPhysique.getNmrRegistreNationale();
    }*/
}
