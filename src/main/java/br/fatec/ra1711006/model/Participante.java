package br.fatec.ra1711006.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "participante")
public class Participante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParticipante;

	private String nomeParticipante;
	private String dtNascParticipante;
	private String emailParticipante;
	private String CPFParticipante;
	private boolean ativo;

	@ManyToOne
	@JoinColumn(name="codigoEvento", referencedColumnName="idEvento", nullable=false, insertable=false, updatable=false)
	private Evento evento;

	private int codigoEvento;

	public int getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(int codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public Integer getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Integer idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public String getDtNascParticipante() {
		return dtNascParticipante;
	}

	public void setDtNascParticipante(String dtNascParticipante) {
		this.dtNascParticipante = dtNascParticipante;
	}

	public String getEmailParticipante() {
		return emailParticipante;
	}

	public void setEmailParticipante(String emailParticipante) {
		this.emailParticipante = emailParticipante;
	}

	public String getCPFParticipante() {
		return CPFParticipante;
	}

	public void setCPFParticipante(String cPFParticipante) {
		CPFParticipante = cPFParticipante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
