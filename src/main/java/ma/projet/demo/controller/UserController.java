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

import ma.projet.demo.entities.User;
import ma.projet.demo.service.UserService;

@RestController
@RequestMapping("User")


public class UserController {
	@Autowired
	private UserService UserServ;
	@PostMapping("/save")
	public void save(@RequestBody User user) {
		UserServ.save(user);
	}
	@GetMapping("/all")
	public List<User> findAll() {
		return UserServ.findAll();
	}
	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
	    return UserServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		User u = UserServ.findById(Integer.parseInt(id));
		UserServ.delete(u);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody User user){
		User u = UserServ.findById(Integer.parseInt(id));
	    u.setNom(user.getNom());
	    UserServ.update(u);
	}

}
