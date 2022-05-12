package com.example.projetBackend.model.repository;

import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientMoraleRepository extends JpaRepository<ClientMorale, Integer> {

    //List<ClientMorale> findByGerant(ClientPhysique gerantID);

    @Query(value = "SELECT * FROM  client_morale cm ,client_physique cp WHERE cp.nmr_registre_nationale = cm.nmr_Tva " +
            "AND cm.nmr_Tva = ?1",
            nativeQuery = true)
    List<ClientMorale> findByGerant(String nmrRegistreNationale);
    @Query(value = "SELECT * FROM  client_morale cm ,client_physique cp " +
            "WHERE cp.nmr_registre_nationale = cm.nmr_Tva " +
            "AND cp.id_client = ?1",
            nativeQuery = true)
    List<ClientMorale> findByIDgerant(int id);
    @Query(value = "SELECT * FROM  client_morale cm  cp WHERE   " +
            "cm.nmr_Tva = ?1",
            nativeQuery = true)
    List<ClientMorale> findByNmrTVA(String nmrTva);
}
