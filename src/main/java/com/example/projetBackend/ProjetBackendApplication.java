package com.example.projetBackend;

import com.example.projetBackend.mapper.ClientPhysiqueMapper;
import com.example.projetBackend.model.dto.ClientPhysiqueDTO;
import com.example.projetBackend.model.entity.ClientMorale;
import com.example.projetBackend.model.entity.ClientPhysique;
import com.example.projetBackend.model.entity.Post;
import com.example.projetBackend.model.repository.ClientMoraleRepository;
import com.example.projetBackend.model.repository.ClientPhysiqueRepository;
import com.example.projetBackend.model.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProjetBackendApplication implements CommandLineRunner {


@Autowired
public PostRepository postRepository;

@Autowired
public ClientMoraleRepository clientMoraleRepository;

@Autowired
public ClientPhysiqueRepository clientPhysiqueRepository;

@Autowired
public ClientPhysiqueMapper clientPhysiqueMapper;

	public static void main(String[] args) {

		SpringApplication.run(ProjetBackendApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Post newPost =new Post("AU REVOIR TOUT LE MONDE");
		postRepository.save(newPost);

		Post newPost1 =new Post("HI");
		postRepository.save(newPost1);

		//
		ClientMorale entreprise = new ClientMorale();

		System.out.println("\n Find all : ");

		List<Post> posts = postRepository.findAll();

		for (Post post : posts) {
			System.out.println(post.getMessage());
		}

		System.out.println("\n Find by message : ");

		Post postFoundByMessage = postRepository.findByMessage("Hi").get(0);
		System.out.println(postFoundByMessage.getIdPost());

		System.out.println("\n Find long posts : ");

		List<Post> longPosts = postRepository.findLongPosts();

		for (Post post : longPosts) {
			System.out.println(post.getMessage());
		}

		ClientMorale clientMorale = new ClientMorale();
		clientMorale.setNmrTva("80050688088");
		clientMorale.setCapital(150000);
		clientMorale.setLieu_siege("Bruxelles");
		clientMorale.setNomSiege("Houda & Co");
		clientMorale.setTypeEntreprise("S.A.R.L");

		ClientPhysique clientPhysique= new ClientPhysique();
		clientPhysique.setNmrRegistreNationale("80050688088");
		clientPhysique.setPrenom("Houda");
		clientPhysique.setNom("Lamkahkah");
		clientPhysiqueRepository.save(clientPhysique);

		clientMorale.getListedesGerants().add(clientPhysique);

		clientMoraleRepository.save(clientMorale);


		ClientMorale postFoundByGerant = clientMoraleRepository.findByIDgerant(1).get(0);

		System.out.println(postFoundByGerant.getNomSiege());


		// 2. Utilisation du mapper (sera fait dans les services)

		// Pour insérer une donnée
		// On récupère un AuthorDTO
		ClientPhysiqueDTO clientP_DTO = new ClientPhysiqueDTO();
		clientP_DTO.setNmrRegistreNationale("80050666039");
		clientP_DTO.setNumeroClient(12345333333L);
		clientP_DTO.setDate_Naissance(LocalDate.of(1980, 9, 5));

		ClientPhysique newClientPhysique = clientPhysiqueMapper.toEntity(clientP_DTO);

		clientPhysiqueRepository.save(newClientPhysique);










}
}
