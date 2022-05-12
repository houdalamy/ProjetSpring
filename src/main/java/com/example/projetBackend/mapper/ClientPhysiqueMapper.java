package com.example.projetBackend.mapper;

import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.dto.CompteBancaireDTO;
import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.CompteBancaire;
import com.example.projetBackend.model.entity.TypeCompteBancaire;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class ClientPhysiqueMapper {


    public ClientPhysiqueDTO.ClientMoraleDTO clientMoraleDTO(ClientMorale clientMorale){
        return new ClientPhysiqueDTO.ClientMoraleDTO(
                clientMorale.getNmrTva(),
                clientMorale.getNomSiege(),
                clientMorale.getTypeEntreprise(),
                clientMorale.getCapital()
        );

    }

    public ClientPhysiqueDTO.CompteBancaireDTO compteBancaireDTO(CompteBancaire compteBancaire){
        return new ClientPhysiqueDTO.CompteBancaireDTO(
                compteBancaire.getCompteBancaireId(),
                compteBancaire.getIban(),
                compteBancaire.getSolde(),
                compteBancaire.getDateCreationCompteBancaire(),
                compteBancaire.getDateFermetureCompteBancaire(),
                compteBancaire.getTypeCompteBancaire()
        );

    }

    public ClientPhysiqueDTO toDto(ClientPhysique clientPhysique){
        if(clientPhysique == null){
            return null;
        }
        ClientPhysiqueDTO cltPhysiqueDTO =new ClientPhysiqueDTO();
        /*String nmrRegistreNationale,
        String prenom, long numeroClient,
        LocalDate date_Naissance)*/
        cltPhysiqueDTO.setNmrRegistreNationale(clientPhysique.getNmrRegistreNationale());
        cltPhysiqueDTO.setPrenom(clientPhysique.getPrenom());
        cltPhysiqueDTO.setNumeroClient(clientPhysique.getNumeroClient());
        cltPhysiqueDTO.setDate_Naissance(clientPhysique.getDate_Naissance());

        if (clientPhysique.getListeDesEntreprises() != null){
            cltPhysiqueDTO.setEntreprises(clientPhysique.getListeDesEntreprises()
                    .stream()
                    .map(this::clientMoraleDTO)
                    .collect(Collectors.toList()));
        }

        return cltPhysiqueDTO;

    }

    public ClientPhysique  toEntity(ClientPhysiqueDTO clientPhysiquedto){
        if(clientPhysiquedto == null)
        { return null;    }

        ClientPhysique cltPhysiqueEntity = new ClientPhysique();
        cltPhysiqueEntity.setNmrRegistreNationale(clientPhysiquedto.getNmrRegistreNationale());
        cltPhysiqueEntity.setPrenom(clientPhysiquedto.getPrenom());
        cltPhysiqueEntity.setDate_Naissance(clientPhysiquedto.getDate_Naissance());
        cltPhysiqueEntity.setNumeroClient(clientPhysiquedto.getNumeroClient());


    return cltPhysiqueEntity;
    }






}
