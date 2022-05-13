package com.example.projetBackend.service;

import com.example.projetBackend.mapper.CompteBancaireMapper;
import com.example.projetBackend.model.dto.CompteBancaireDTO;
import com.example.projetBackend.model.entity.CompteBancaire;
import com.example.projetBackend.model.repository.ClientPhysiqueRepository;
import com.example.projetBackend.model.repository.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteBancaireService {

    @Autowired
    private CompteBancaireRepository compteBancaireRepository;
    @Autowired
    private CompteBancaireMapper compteBancaireMapper;
//method findAll() => une liste des comptes bancaire sans parametres
    public List<CompteBancaireDTO> getCompteBancaire(){
       return compteBancaireRepository
               .findAll()
               .stream()
               .map(compteBancaireMapper::toDTO)
               .collect(Collectors.toList());

    }
//methode save()
    public CompteBancaireDTO save(CompteBancaireDTO compteBancaireDTO){

        return compteBancaireMapper.toDTO(
                compteBancaireRepository
                        .save( compteBancaireMapper
                                .ToEntity(compteBancaireDTO)));
                   }


//methode delete()
public String delete(int idCompteBancaire){
        compteBancaireRepository.deleteById(idCompteBancaire);
        return "compte bancaire supprimé";

}

    public CompteBancaireDTO update(CompteBancaireDTO compteBancaireDTO){

        if(compteBancaireDTO.getCompteBancaireId()>0) {

           CompteBancaire cpEntity = compteBancaireRepository.findById(compteBancaireDTO.getCompteBancaireId()).orElse(null);

           return compteBancaireMapper.toDTO( compteBancaireRepository.save(cpEntity) );
       }
        else {
            return null ;
        }

    }

}
