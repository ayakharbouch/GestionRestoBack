package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDAO;
import ma.projet.demo.entities.User;
import ma.projet.demo.repository.UserRepository;

@Service
public class UserService implements IDAO <User>{

	@Autowired
	private UserRepository Userrep;
	public User save(User o) {
	
		return Userrep.save(o) ;
	}

	public User findById(int id) {
		return Userrep.findById(id);
	}

	@Override
	public List<User> findAll() {
		
		return Userrep.findAll();
	}

	@Override
	public void delete(User o) {
		Userrep.delete(o);
		
	}

	@Override
	public void update(User o) {
		Userrep.save(o);
		
	}

}
