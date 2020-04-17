package it.itsrizzoli.N4W.models.db;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recensione implements Serializable{
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max=500)
	private String commento;
	
	private int voto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	/**
	 * @param id
	 * @param commento
	 * @param voto
	 */
	public Recensione(@NotNull Long id, @Size(max = 500) String commento, int voto) {
		this.id = id;
		this.commento = commento;
		this.voto = voto;
	}

	/**
	 * 
	 */
	public Recensione() {
	}

}
