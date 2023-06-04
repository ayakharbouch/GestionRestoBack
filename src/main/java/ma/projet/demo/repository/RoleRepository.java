package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer>{
	Role findById(int id);
}
