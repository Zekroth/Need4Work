package it.itsrizzoli.Spring;

import java.util.*;

public class UserDAO {

	private List<LoginformProgetto> users = new ArrayList<>();
	
	public UserDAO() {
		
	}
	@Override
	public Optional<LoginformProgetto> get(long id){
		return Optional.ofNullable(users.get((int) id));
	}
	
	@Override
	public List<LoginformProgetto> getAll(){
		return users;
	}
	
	@Override
	public void save (LoginformProgetto User) {
		users.add(User);
	}
	@Override
	public void Update (LoginformProgetto User, String[] params) {
		User.setUsername(LoginformProgetto.username);
		User.setEmail(LoginformProgetto.email);
		
		users.add(User);
	}
	@Override
	public void delete (LoginformProgetto User) {
		users.remove(User);
	}
	
}

