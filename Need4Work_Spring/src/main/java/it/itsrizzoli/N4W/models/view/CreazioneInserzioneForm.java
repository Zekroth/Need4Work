package it.itsrizzoli.N4W.models.view;

import java.sql.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreazioneInserzioneForm {
	
	@Size(min=5,max=100)
	String titolo;
	
	@Size(min=30,max=500)
	String commento;
	
	@DecimalMax(value = "9999.99")
	double importoMax;
	
	@NotNull
	String professioneRichiesta;
	
	@NotNull
	Date dataFine;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public double getImportoMax() {
		return importoMax;
	}

	public void setImportoMax(double importoMax) {
		this.importoMax = importoMax;
	}

	public String getProfessioneRichiesta() {
		return professioneRichiesta;
	}

	public void setProfessioneRichiesta(String professioneRichiesta) {
		this.professioneRichiesta = professioneRichiesta;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
