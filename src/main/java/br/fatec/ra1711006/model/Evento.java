package br.fatec.ra1711006.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "evento")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvento;
	private boolean ativo;

	@NaturalId
	private String nomeEvento;
	private String dtHrEvento;
	private String localEvento;

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getDtHrEvento() {
		return dtHrEvento;
	}

	public void setDtHrEvento(String dtHrEvento) {
		this.dtHrEvento = dtHrEvento;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}
	
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
