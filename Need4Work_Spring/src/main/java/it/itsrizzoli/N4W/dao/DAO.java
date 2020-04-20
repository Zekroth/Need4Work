package it.itsrizzoli.N4W.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

	Optional<T> get(long id);
	
	List<T> getAll();
	
	void save (T d);
	
	void update(T d, String[] params);
	
	void delete(T d);
	
	
}
