package com.need4work.models;

import java.util.EnumSet;

public abstract class User {
	
	//FIELDS
	private String email; //PRIMARY_KEY
	private String username;
	private String password;
	private int id;
	
	private static enum Competences{
		Elettricista,
		Idraulico,
		Giardiniere
	}
	/*
	 * Nome
	 * Cognome
	 * Data di nascita
	 * Via
	 * CAP
	 * Paese
	 * Provincia
	 * Cellulare
	 */
	private String[] profile;
	private EnumSet<User.Competences> competences;
	
	//GLOBALS
	private static int globalId; //Global top id
	public static boolean Init() {
		//Retrieves data from DB in order to get things started
		
		return false;
	}
	//CONSTRUCTORS
	
	//METHODS
	
}
