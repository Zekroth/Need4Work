package it.itsrizzoli.N4W.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<da> {

	Optional<da> get(long id);
	
	List<da> getAll();
	
	void save (da d);
	
	void update(da d, String[] params);
	
	void delete(da d);
	
	
}
