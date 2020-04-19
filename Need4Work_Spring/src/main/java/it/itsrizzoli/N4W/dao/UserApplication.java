package it.itsrizzoli.N4W.dao;

import java.util.Optional;

import org.apache.tomcat.jni.User;

public class UserApplication implements DAO<LoginformProgetto>{

	private static UserDAO userDAO;
	
	public static void main(String[] args) {
		userDAO = new UserDAO();
		
		LoginformProgetto user1 = getUser(0);
		
		UserDAO.Update(user1, new String[] {});
		
		LoginformProgetto user2 = getUser(0);
		
		UserDAO.delete(user2);
		
		UserDAO.save(new User ());
		
		UserDAO.getAll().forEach(user -> System.out.pritnln(user.getUsername()));
		
	}

	private static LoginformProgetto getUser(int i) {
		Optional<LoginformProgetto> user = userDAO.get(id);
		
		return user.orElseGet(()-> new User("non-existing user","no-email"));
		
	}
	
	}
	
