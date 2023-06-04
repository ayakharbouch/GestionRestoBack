package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Specialite;
import ma.projet.demo.repository.SpecialiteRepository;

@Service
public class SpecialiteService implements IDAO<Specialite> {

	@Autowired
	private SpecialiteRepository Specialrep;
	
	public Specialite save(Specialite o) {
		
		return Specialrep.save(o) ;
	}

	
	public Specialite findById(int id) {
		
		return Specialrep.findById(id);
	}

	
	public List<Specialite> findAll() {
		return Specialrep.findAll();
	}

	
	public void delete(Specialite o) {
		Specialrep.delete(o);
		
	}

	
	public void update(Specialite o) {
		Specialrep.save(o);
		
	}

}
