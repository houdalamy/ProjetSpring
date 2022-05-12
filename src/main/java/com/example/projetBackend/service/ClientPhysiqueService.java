package com.example.projetBackend.service;


import com.example.projetBackend.mapper.ClientPhysiqueMapper;
import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.repository.ClientPhysiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientPhysiqueService {

    @Autowired
    private ClientPhysiqueRepository clientPhysiqueRepository;

    @Autowired
    private ClientPhysiqueMapper clientPhysiqueMapper;
//methode save()
    public ClientPhysiqueDTO save(ClientPhysiqueDTO clientPhysiqueDTO){

        return clientPhysiqueMapper.toDto(
                clientPhysiqueRepository.save(clientPhysiqueMapper.toEntity(clientPhysiqueDTO))
        );
    }
    //methode getClientPhysique()
      public List<ClientPhysiqueDTO> getClientPhysique(){
              return   clientPhysiqueRepository.findAll()
                      .stream()
                      .map(clientPhysiqueMapper::toDto)
                      .collect(Collectors.toList());

        }

      public ClientPhysiqueDTO getClientPhysiqueByNumeroRegistre(String numeroRegistreNationale){
              return  clientPhysiqueMapper.toDto(
                      clientPhysiqueRepository.findByNmrRegistreNationale(numeroRegistreNationale)
              );

     }
    public ClientPhysiqueDTO getClientPhysiqueById(int id){
        return  clientPhysiqueMapper.toDto( clientPhysiqueRepository.findById(id).orElse(null));

    }


    public String deleteClient(int id){
        clientPhysiqueRepository.deleteById(id);
        return "Client supprimé";

    }

    public ClientPhysiqueDTO updateClient(ClientPhysiqueDTO clientPhysiqueDTO){
        if(clientPhysiqueDTO.getId()>0){
            ClientPhysique  clientPhysiqueEntity =
                    clientPhysiqueRepository.findById(clientPhysiqueDTO.getId()).orElse(null) ;

      return   clientPhysiqueMapper.toDto(clientPhysiqueRepository.save(clientPhysiqueEntity));
      }
        else{
            return null;
        }

    }




}
