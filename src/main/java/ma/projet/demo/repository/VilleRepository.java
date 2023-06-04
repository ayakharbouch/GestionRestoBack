package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer>{
	Ville findById(int id);
}
