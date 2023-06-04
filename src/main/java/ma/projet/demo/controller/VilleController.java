package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.projet.demo.entities.Ville;
import ma.projet.demo.service.VilleService;

@RestController
@CrossOrigin
@RequestMapping("ville")
public class VilleController {
	@Autowired
	private VilleService VilleServ;
	@PostMapping("/save")
	public void save(@RequestBody Ville ville) {
		VilleServ.save(ville);
	}
	@GetMapping("/all")
	public List<Ville> findAll() {
		return VilleServ.findAll();
	}
	@GetMapping("/{id}")
	public Ville findById(@PathVariable int id) {
	    return VilleServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Ville v = VilleServ.findById(Integer.parseInt(id));
		VilleServ.delete(v);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Ville ville){
		Ville v = VilleServ.findById(Integer.parseInt(id));
	    v.setNom(ville.getNom());
	    VilleServ.update(v);
	}


}
