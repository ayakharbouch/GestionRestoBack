package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repository.ZoneRepository;

@Service
public class ZoneService implements IDAO<Zone>{

	@Autowired
	private ZoneRepository Zonerep;
	public Zone save(Zone o) {
		
		return Zonerep.save(o);
	}

	
	public Zone findById(int id) {
		
		return Zonerep.findById(id);
	}

	
	public List<Zone> findAll() {
		
		return Zonerep.findAll();
	}

	
	public void delete(Zone o) {
		Zonerep.delete(o);
		
	}

	
	public void update(Zone o) {
		
		Zonerep.save(o);
	}

}
