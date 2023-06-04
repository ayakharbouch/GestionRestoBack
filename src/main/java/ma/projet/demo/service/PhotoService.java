package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Photo;
import ma.projet.demo.repository.PhotoRepository;

@Service
public class PhotoService implements IDAO <Photo> {

	@Autowired
	private PhotoRepository Photorep;

	public Photo save(Photo o) {
		
		return Photorep.save(o);
	}

	
	public Photo findById(int id) {
		
		return Photorep.findById(id);
	}

	
	public List<Photo> findAll() {
		
		return Photorep.findAll();
	}

	@Override
	public void delete(Photo o) {
		Photorep.delete(o);
		
	}

	
	public void update(Photo o) {
		Photorep.save(o);
		
	}

}
