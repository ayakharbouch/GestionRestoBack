package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Restaurant;
import ma.projet.demo.repository.RestaurantRepository;


@Service
public class RestaurantService implements IDAO <Restaurant> {

	@Autowired
	private RestaurantRepository Restorep;
	public Restaurant save(Restaurant o) {
		return Restorep.save(o);
	}

	
	public Restaurant findById(int id) {
		return Restorep.findById(id);
	}


	public List<Restaurant> findAll() {
		
		return Restorep.findAll();
	}

	
	public void delete(Restaurant o) {
		Restorep.delete(o);
		
	}

	public void update(Restaurant o) {
		Restorep.save(o);
		
	}

}
