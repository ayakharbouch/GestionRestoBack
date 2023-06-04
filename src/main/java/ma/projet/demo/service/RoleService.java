package ma.projet.demo.service;

import java.util.List;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.repository.RoleRepository;

@Service
public class RoleService implements IDAO <Role>{
	@Autowired
	private RoleRepository Rolerep;
	
	public Role save(Role o) {
		
		
		return Rolerep.save(o);
	}

	
	public Role findById(int id) {
		
		return Rolerep.findById(id);
	}

	
	public List<Role> findAll() {
		
		return Rolerep.findAll();
	}

	
	public void delete(Role o) {
		Rolerep.delete(o);
		
	}

	
	public void update(Role o) {
		Rolerep.save(o);
		
	}

}
