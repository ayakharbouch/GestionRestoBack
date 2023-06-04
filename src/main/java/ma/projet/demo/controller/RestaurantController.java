package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.demo.entities.Restaurant;
import ma.projet.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")

public class RestaurantController {
	@Autowired
	private RestaurantService RestoServ;
	@PostMapping("/save")
	public void save(@RequestBody Restaurant restaurant) {
		RestoServ.save(restaurant);
	}
	@GetMapping("/all")
	public List<Restaurant> findAll() {
		return RestoServ.findAll();
	}
	@GetMapping("/{id}")
	public Restaurant findById(@PathVariable int id) {
	    return RestoServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Restaurant r = RestoServ.findById(Integer.parseInt(id));
		RestoServ.delete(r);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Restaurant restaurant){
		Restaurant r = RestoServ.findById(Integer.parseInt(id));
	    r.setNom(restaurant.getNom());
	    RestoServ.update(r);
	}

}
