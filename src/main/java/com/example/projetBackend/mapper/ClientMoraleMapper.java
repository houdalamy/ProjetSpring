package com.example.projetBackend.mapper;


import com.example.projetBackend.model.dto.ClientMoraleDTO;
import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ClientMoraleMapper {

    @Autowired
    private ClientPhysiqueMapper clientPhysiqueMapper;


    private ClientMoraleDTO.ClientPhysiqueDTO toInnerDto(ClientPhysique clientPhysique) {

        if (clientPhysique == null) {

            return null;
        }

        ClientMoraleDTO.ClientPhysiqueDTO dto = new ClientMoraleDTO.ClientPhysiqueDTO();
        dto.setNationalite(clientPhysique.getNationalite());
        dto.setNumeroClient(clientPhysique.getNumeroClient());
        dto.setPrenom(clientPhysique.getPrenom());
        dto.setNmrRegistreNationale(clientPhysique.getNmrRegistreNationale());
        dto.setDate_Naissance(clientPhysique.getDate_Naissance());

        return dto;
    }



    //transformez entité a DTO
   public ClientMoraleDTO toDto(ClientMorale clientMorale){
       if (clientMorale == null){
           return null;
                  }
       ClientMoraleDTO clientMoraleDTO = new ClientMoraleDTO();
       clientMoraleDTO.setNmrTva(clientMorale.getNmrTva());
       clientMoraleDTO.setNomSiege(clientMorale.getNomSiege());
       clientMoraleDTO.setLieu_siege(clientMorale.getLieu_siege());
       clientMoraleDTO.setTypeEntreprise(clientMorale.getTypeEntreprise());
       clientMoraleDTO.setDateCreation(clientMorale.getDateCreation());
       clientMoraleDTO.setDate_fermeture(clientMorale.getDate_fermeture());
       clientMoraleDTO.setCapital(clientMorale.getCapital());

       if (clientMorale.getListedesGerants() != null)
       {
           clientMoraleDTO.setClientPhysique(
                   clientMorale.getListedesGerants()
                           .stream()
                           .map(this::toInnerDto)
                           .collect(Collectors.toList())
           );



       }       return clientMoraleDTO;
   }

    //transformez entité a DTO

    public ClientMorale toEntity(ClientMoraleDTO clientMoraleDto){
        if (clientMoraleDto == null){
            return null;
        }
        ClientMorale clientMorale = new ClientMorale();
        clientMorale.setNmrTva(clientMoraleDto.getNmrTva());
        clientMorale.setNomSiege(clientMoraleDto.getNomSiege());
        clientMorale.setLieu_siege(clientMoraleDto.getLieu_siege());
        clientMorale.setTypeEntreprise(clientMoraleDto.getTypeEntreprise());
        clientMorale.setDateCreation(clientMoraleDto.getDateCreation());
        clientMorale.setDate_fermeture(clientMoraleDto.getDate_fermeture());
        clientMorale.setCapital(clientMoraleDto.getCapital());
        return clientMorale;
    }

}
