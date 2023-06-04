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

import ma.projet.demo.entities.Photo;
import ma.projet.demo.service.PhotoService;

@RestController
@RequestMapping("Photo")
public class PhotoController {
	@Autowired
	private PhotoService PhotoServ;
	@PostMapping("/save")
	public void save(@RequestBody Photo photo) {
		PhotoServ.save(photo);
	}
	@GetMapping("/all")
	public List<Photo> findAll() {
		return PhotoServ.findAll();
	}
	@GetMapping("/{id}")
	public Photo findById(@PathVariable int id) {
	    return PhotoServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Photo p = PhotoServ.findById(Integer.parseInt(id));
		PhotoServ.delete(p);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Photo photo){
		Photo p = PhotoServ.findById(Integer.parseInt(id));
	    p.setId(photo.getId());
	    PhotoServ.update(p);
	}

}
