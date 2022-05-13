package com.example.projetBackend.service;
import com.example.projetBackend.mapper.ClientMoraleMapper;
import com.example.projetBackend.model.dto.ClientMoraleDTO;
import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.repository.ClientMoraleRepository;
import com.example.projetBackend.model.repository.ClientPhysiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;




@Service
public class ClientMoraleService {
    @Autowired
    private ClientMoraleRepository clientMoraleRepository;
    @Autowired
    private ClientPhysiqueRepository clientPhysiqueRepository;
    @Autowired
    private ClientMoraleMapper clientMoraleMapper;

    //methode save()
    public ClientMoraleDTO save(ClientMoraleDTO clientMoraleDTO){

        return clientMoraleMapper.toDto(clientMoraleRepository.
                            save(clientMoraleMapper.toEntity(clientMoraleDTO)));

    }

    //methode delete()
    public void delete(ClientMorale clientMorale ){
           clientMoraleRepository.delete(clientMorale);
    }
    //methode update()

    public ClientMoraleDTO updateEntreprise(ClientMoraleDTO clientMoraleDTO){
        if (clientMoraleDTO.getId() > 0){
            ClientMorale clientAmodifier =
                clientMoraleRepository.findById(clientMoraleDTO.getId())
                        .orElseThrow(() -> new EntityNotFoundException(" Entité client morale non trouvé !"));
                        //orElse(null);
            if(clientMoraleDTO.getNmrTva() != null)
                clientMoraleDTO.setNmrTva(clientAmodifier.getNmrTva());
            if(clientMoraleDTO.getNomSiege() != null)
                clientMoraleDTO.setNmrTva(clientAmodifier.getNomSiege());
            if(clientMoraleDTO.getLieu_siege() != null)
                clientMoraleDTO.setLieu_siege(clientAmodifier.getLieu_siege());
            if(clientMoraleDTO.getDateCreation() != null)
                clientMoraleDTO.setDateCreation(clientAmodifier.getDateCreation());
            if(clientMoraleDTO.getDate_fermeture() != null)
                clientMoraleDTO.setDate_fermeture(clientAmodifier.getDate_fermeture());
            if(clientMoraleDTO.getCapital() != 0)
                clientMoraleDTO.setCapital(clientAmodifier.getCapital());
            if(clientMoraleDTO.getTypeEntreprise() != null)
                clientMoraleDTO.setTypeEntreprise(clientAmodifier.getTypeEntreprise());


        }
        return clientMoraleMapper.toDto(
                clientMoraleRepository.save(
                        clientMoraleMapper.toEntity(clientMoraleDTO)
                ));
    }

    public ClientMoraleDTO addGerantsEntreprise(int idEntreprise, int idGerant) {
        ClientMorale entreprise = clientMoraleRepository.findById(idEntreprise).orElse(null);
        ClientPhysique gerantAajouter = clientPhysiqueRepository.findById(idGerant).orElse(null);
        entreprise.getListedesGerants().add(gerantAajouter);
        return clientMoraleMapper.toDto(
                clientMoraleRepository.save(entreprise)
        );
    }
    public ClientMoraleDTO deleteGerantsEntreprise(int idEntreprise, int idGerant) {
        ClientMorale entreprise = clientMoraleRepository.findById(idEntreprise).orElse(null);
        ClientPhysique gerantAajouter = clientPhysiqueRepository.findById(idGerant).orElse(null);
        entreprise.getListedesGerants().add(gerantAajouter);
        return clientMoraleMapper.toDto(
                clientMoraleRepository.save(entreprise)
        );
    }
        public List<ClientMoraleDTO> getEntreprises(){
            return   clientMoraleRepository
                                    .findAll()
                                    .stream()
                                    .map(clientMoraleMapper :: toDto )
                                    .collect(Collectors.toList());

        }


        public ClientMoraleDTO getClientMoraleById(int id){

            ClientMorale entreprise = clientMoraleRepository.findById(id).orElse(null);

            return clientMoraleMapper.toDto(entreprise);


        }

        public void deleteClientMoralById(int id){
           ClientMorale entreprise = clientMoraleRepository.findById(id).orElse(null);
           clientMoraleRepository.delete(entreprise);
            System.out.println(" entreprise deleted by id");

        }


 }


