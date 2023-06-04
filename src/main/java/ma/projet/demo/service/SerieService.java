package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Serie;
import ma.projet.demo.repository.SerieRepository;

@Service
public class SerieService implements IDAO <Serie> {

	@Autowired
	private SerieRepository Serierep;
	@Override
	public Serie save(Serie o) {
		
		return Serierep.save(o);
	}

	@Override
	public Serie findById(int id) {
		
		return Serierep.findById(id);
	}

	@Override
	public List<Serie> findAll() {
		
		return Serierep.findAll();
	}

	@Override
	public void delete(Serie o) {
		Serierep.delete(o);
		
	}

	@Override
	public void update(Serie o) {
		
		Serierep.save(o);
	}

}
