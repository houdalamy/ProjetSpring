package com.example.projetBackend.service;


import com.example.projetBackend.mapper.ClientMoraleMapper;
import com.example.projetBackend.model.dto.ClientMoraleDTO;
import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.repository.ClientMoraleRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMoraleService {
    @Autowired
    private ClientMoraleRepository clientMoraleRepository;

    @Autowired
    private ClientMoraleMapper clientMoraleMapper;



    //methode save()
    public ClientMoraleDTO save(ClientMoraleDTO clientMoraleDTO){

        return clientMoraleMapper.toDto(clientMoraleRepository.
                            save(clientMoraleMapper.toEntity(clientMoraleDTO)));

    }
    //methode update()

    // methode delete()
}
