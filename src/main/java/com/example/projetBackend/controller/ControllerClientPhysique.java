package com.example.projetBackend.controller;


import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.service.ClientPhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clientPhysique")
@CrossOrigin
public class ControllerClientPhysique {
    @Autowired
    private ClientPhysiqueService clientPhysiqueService;

    @GetMapping
    public List<ClientPhysiqueDTO> getClientsPhysique() {
        return  clientPhysiqueService.getClientPhysique();

    }

    @GetMapping("{id}")
    public ClientPhysiqueDTO ClientPhysiqueById(@PathVariable int id) {
        return clientPhysiqueService.getClientPhysiqueById(id);
    }

    @PostMapping
    public ClientPhysiqueDTO save(ClientPhysiqueDTO clientPhysiqueDTO){
        return clientPhysiqueService.save(clientPhysiqueDTO);
    }

    @DeleteMapping
    public String deleteClient(@PathVariable int id){
        return clientPhysiqueService.deleteClient(id);
    }

    @PutMapping
    public ClientPhysiqueDTO updateClientPhysique(@RequestBody ClientPhysiqueDTO clientPhysiqueDTO) {
        return clientPhysiqueService.updateClient(clientPhysiqueDTO);
    }
}
