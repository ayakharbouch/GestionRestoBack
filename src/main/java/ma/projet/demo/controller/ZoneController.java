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

import ma.projet.demo.entities.Zone;
import ma.projet.demo.service.ZoneService;

@RestController
@RequestMapping("Zone")
@CrossOrigin(origins = "http://localhost:3000")
public class ZoneController {
	@Autowired
	private ZoneService ZoneServ;
	@PostMapping("/save")
	public void save(@RequestBody Zone zone) {
		ZoneServ.save(zone);
	}
	@GetMapping("/all")
	public List<Zone> findAll() {
		return ZoneServ.findAll();
	}
	@GetMapping("/{id}")
	public Zone findById(@PathVariable int id) {
	    return ZoneServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Zone z = ZoneServ.findById(Integer.parseInt(id));
		ZoneServ.delete(z);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Zone zone){
		Zone z = ZoneServ.findById(Integer.parseInt(id));
	    z.setNom(zone.getNom());
	    ZoneServ.update(z);
	}
}
