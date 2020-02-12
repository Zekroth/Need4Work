package com.need4work.models;

import java.util.ArrayList;
import java.util.Date;

public class Inserzionista extends User {
	
	ArrayList<Job> listaInserzione = new ArrayList<>();
	
	//FIELDS
	
	//CONSTRUCTORS
	
	//METHODS
	//Creazione di una nuova inserzione
	public void CreaInserzione(String titolo, String descrizione, Date data, float importoMax) {
		//Job lavoro=new Job(titolo, descrizione, data, importoMax);
		//listaInserzione.add(lavoro);
	}
	
	public void ScriviRecensione(String titolo, String recensione, int valore) {
		
	}

}
