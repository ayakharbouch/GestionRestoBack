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

import ma.projet.demo.entities.Specialite;
import ma.projet.demo.service.SpecialiteService;

@RestController
@RequestMapping("Specialite")
public class SpecialiteController {
	@Autowired
	private SpecialiteService SpecialServ;
	@PostMapping("/save")
	public void save(@RequestBody Specialite specialite) {
		SpecialServ.save(specialite);
	}
	@GetMapping("/all")
	public List<Specialite> findAll() {
		return SpecialServ.findAll();
	}
	@GetMapping("/{id}")
	public Specialite findById(@PathVariable int id) {
	    return SpecialServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Specialite sp = SpecialServ.findById(Integer.parseInt(id));
		SpecialServ.delete(sp);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Specialite specialite){
		Specialite sp = SpecialServ.findById(Integer.parseInt(id));
	    sp.setNom(specialite.getNom());
	    SpecialServ.update(sp);
	}

}
