package com.need4work.models;

public abstract class User {
	
	//FIELDS
	private String email; //PRIMARY_KEY
	private String username;
	private String password;
	private int id;
	
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
	
	
	//GLOBALS
	private static int globalId; //Global top id
	public static boolean Init() {
		//Retrieves data from DB in order to get things started
		return false;
	}
	//CONSTRUCTORS
	
	//METHODS
}
