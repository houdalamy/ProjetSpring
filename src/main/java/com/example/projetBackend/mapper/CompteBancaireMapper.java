package com.example.projetBackend.mapper;

import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.dto.CompteBancaireDTO;
import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.CompteBancaire;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompteBancaireMapper {

public CompteBancaireDTO toDTO(CompteBancaire compteBancaire){
    if(compteBancaire == null){
        return null;
    }

    CompteBancaireDTO compteBancaireDTO=new CompteBancaireDTO();
    compteBancaireDTO.setCompteBancaireId(compteBancaire.getCompteBancaireId());
    compteBancaireDTO.setIban(compteBancaire.getIban());
    compteBancaireDTO.setTypeCompteBancaire(compteBancaire.getTypeCompteBancaire());
    compteBancaireDTO.setSolde(compteBancaire.getSolde());
    compteBancaireDTO.setDateCreationCompteBancaire(compteBancaire.getDateCreationCompteBancaire());
    compteBancaireDTO.setDateFermetureCompteBancaire(compteBancaire.getDateFermetureCompteBancaire());



    return compteBancaireDTO;

}



    public CompteBancaire ToEntity(CompteBancaireDTO compteBancaireDTO){
    if(compteBancaireDTO == null ){
        return null;
    }

        CompteBancaire compteBancaire=new CompteBancaire();
        compteBancaire.setCompteBancaireId(compteBancaireDTO.getCompteBancaireId());
        compteBancaire.setIban(compteBancaireDTO.getIban());
        compteBancaire.setTypeCompteBancaire(compteBancaireDTO.getTypeCompteBancaire());
        compteBancaire.setSolde(compteBancaireDTO.getSolde());
        compteBancaire.setDateCreationCompteBancaire(compteBancaireDTO.getDateCreationCompteBancaire());
        compteBancaire.setDateFermetureCompteBancaire(compteBancaireDTO.getDateFermetureCompteBancaire());



        return compteBancaire;

    }




    public CompteBancaireDTO.ClientPhysiqueDTO clientPhysiqueDTO(ClientPhysique clientPhysique){
        return new CompteBancaireDTO.ClientPhysiqueDTO(

                clientPhysique.getNmrRegistreNationale(),
                clientPhysique.getPrenom(),
                clientPhysique.getNumeroClient(),
                clientPhysique.getDate_Naissance(),
                clientPhysique.getNationalite()
        );


    }

}
