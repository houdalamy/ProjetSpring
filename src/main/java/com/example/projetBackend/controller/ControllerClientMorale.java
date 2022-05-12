package com.example.projetBackend.controller;

import com.example.projetBackend.model.dto.ClientMoraleDTO;
import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.service.ClientMoraleService;
import com.example.projetBackend.service.ClientPhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprise")
@CrossOrigin
public class ControllerClientMorale {
    @Autowired
    private ClientMoraleService entrepriseService;

    @GetMapping
    public List<ClientMoraleDTO> getEntreprise() {
        return entrepriseService.getEntreprises();
    }

    @GetMapping("{id}")
    public ClientMoraleDTO getClientMoraleById(@PathVariable int id) {
        return entrepriseService.getClientMoraleById(id);
    }

    @DeleteMapping
    public void deleteClientMoralById(@PathVariable int id){
         entrepriseService.deleteClientMoralById(id);

    }




    }

