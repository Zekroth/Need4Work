package it.itsrizzoli.N4W.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.itsrizzoli.N4W.models.db.Lavoro;

public class LavoroDao implements DAO<Lavoro>{
	
	

	@Override
	public Optional<Lavoro> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lavoro> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Lavoro d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Lavoro d, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Lavoro d) {
		// TODO Auto-generated method stub
		
	}

}
