package com.example.projetBackend.model.entity;

import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
@Entity
@Table(name="client_morale")
public class ClientMorale extends Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nmr_Tva"  , unique = true)
    private String nmrTva ;

    @Column(name = "nom_siege" ,nullable = false)
    private String nomSiege ;

    @Column(name = "type",nullable = false )
    private String typeEntreprise ;


    @CreationTimestamp
    @Column (name="date_creation", nullable = false)
    private LocalDateTime dateCreation ;

    @Column (name="date_fermeture" )
    private LocalDate date_fermeture ;

    @Column(name = "lieu_siege",nullable = false )
    private String lieu_siege;

    @Column(name = "capital" , columnDefinition = "DECIMAL" ,nullable = false)
    private double capital;



    @ManyToMany
    @JoinTable(
                name = "Table_Entreprise_Gerants_Associations",
                joinColumns = @JoinColumn( name = "nmr_Tva" ),
                inverseJoinColumns = @JoinColumn( name = "nmr_registre_nationale" ))
    private List<ClientPhysique> listedesGerants = new ArrayList<>();

    public ClientMorale(String nmrTva, String nomSiege, String typeEntreprise, String lieu_siege, double capital) {
        this.nmrTva = nmrTva;
        this.nomSiege = nomSiege;
        this.typeEntreprise = typeEntreprise;
        this.lieu_siege = lieu_siege;
        this.capital = capital;
    }

    public ClientMorale() {

    }

    public ClientMorale(String nom, String adresseClient ) {
        super(nom, adresseClient);

    }





    public ClientMorale(String nmrTva, String nomSiege, String typeEntreprise, LocalDateTime dateCreation,
                        LocalDate date_fermeture, String lieu_siege, double capital,
                        List<ClientPhysique> listedesGerants) {
        this.nmrTva = nmrTva;
        this.nomSiege = nomSiege;
        this.typeEntreprise = typeEntreprise;
        this.dateCreation = dateCreation;
        this.date_fermeture = date_fermeture;
        this.lieu_siege = lieu_siege;
        this.capital = capital;
        this.listedesGerants = listedesGerants;
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

    public List<ClientPhysique> getListedesGerants() {

        return listedesGerants;
    }

    public void setListedesGerants(List<ClientPhysique> listedesGerants) {

        this.listedesGerants = listedesGerants;
    }
}
