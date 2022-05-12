package com.example.projetBackend.model.repository;

import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.CompteBancaire;
import com.example.projetBackend.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompteBancaireRepository  extends JpaRepository<CompteBancaire, Integer> {

    @Query(value = "SELECT * FROM  compte_bancaire cb ,client_physique cp " +
            "WHERE cp. = cm.id_client " +
            "AND cb.compte_bancaire_id = ?1",
            nativeQuery = true)
    List<ClientPhysique> findByClient(int id);
}
