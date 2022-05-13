package com.example.projetBackend.controller;


import com.example.projetBackend.model.dto.ClientMoraleDTO;
import com.example.projetBackend.model.dto.CompteBancaireDTO;
import com.example.projetBackend.service.ClientMoraleService;
import com.example.projetBackend.service.CompteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compteBancaire")
@CrossOrigin
public class ControllerCompteBancaire {

    @Autowired
    private CompteBancaireService compteBancaireService;


    @GetMapping
    public List<CompteBancaireDTO> getCompteBancaire() {
        return compteBancaireService.getCompteBancaire();
    }

  //  @PostMapping


    //@DeleteMapping

  //  @PutMapping

}
