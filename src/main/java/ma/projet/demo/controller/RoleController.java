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

import ma.projet.demo.entities.Role;
import ma.projet.demo.service.RoleService;

@RestController
@RequestMapping("Role")
public class RoleController {
	@Autowired
	private RoleService RoleServ;
	@PostMapping("/save")
	public void save(@RequestBody Role role) {
		RoleServ.save(role);
	}
	@GetMapping("/all")
	public List<Role > findAll() {
		return RoleServ.findAll();
	}
	@GetMapping("/{id}")
	public Role  findById(@PathVariable int id) {
	    return RoleServ.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Role  ro = RoleServ.findById(Integer.parseInt(id));
		RoleServ.delete(ro);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Role  role){
		Role  ro = RoleServ.findById(Integer.parseInt(id));
	    ro.setId(role.getId());
	    RoleServ.update(ro);
	}


}
