package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.repository.VilleRepository;

@Service
public class VilleService implements IDAO<Ville> {

	@Autowired
	private VilleRepository Villerep;
	
	public Ville save(Ville o) {
		return Villerep.save(o);
	}

	
	public Ville findById(int id) {
		return Villerep.findById(id);
	}

	
	public List<Ville> findAll() {
		
		return Villerep.findAll();
	}

	
	public void delete(Ville o) {
		Villerep.delete(o);
		
	}

	
	public void update(Ville o) {
		Villerep.save(o);
		
	}

}
