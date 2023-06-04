package ma.projet.demo.dao;

import java.util.List;

public interface IDAO<T> {
	T save(T o);
	
	T findById(int id);
	
	List<T> findAll();
	
	 void delete(T o);
	 
	 void update(T o);
	 
	 
	

}
