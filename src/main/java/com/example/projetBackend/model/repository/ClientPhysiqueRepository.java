package com.example.projetBackend.model.repository;

import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientPhysiqueRepository  extends JpaRepository<ClientPhysique, Integer> {
    ClientPhysique findByNmrRegistreNationale(String nmrRegistreNationale);
}
