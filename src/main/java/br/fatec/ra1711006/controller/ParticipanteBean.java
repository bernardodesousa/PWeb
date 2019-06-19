package br.fatec.ra1711006.controller;

// import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
// import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fatec.ra1711006.dao.ParticipanteDAO;
import br.fatec.ra1711006.dao.ParticipanteDAOHibernate;
import br.fatec.ra1711006.model.Participante;
import br.fatec.ra1711006.model.Evento;

@ManagedBean(name = "participanteBean")
@RequestScoped

public class ParticipanteBean {
	private Participante participante = new Participante();
	
	private DataModel<Participante> listaParticipantes;
	private Evento evento;

	// @SuppressWarnings("unchecked")
	public DataModel<Participante> getListaParticipantes() {
		if (listaParticipantes == null) {
			ParticipanteDAO dao = new ParticipanteDAOHibernate();
			listaParticipantes = new ListDataModel<Participante>(dao.listar());
		}
		return listaParticipantes;
	}

	public void setListaParticipante(DataModel<Participante> listaParticipante) {
		this.listaParticipantes = listaParticipante;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
	public void setEvento(Evento e) {
		evento = e;
	}
	
	public Evento getEvento() {
		return evento;
	}
	
	public String novo() {
		this.participante = new Participante();
		this.participante.setAtivo(true);
		return "publico/novo_participante";
	}

	public String listagem() {
		this.participante = new Participante();
		return "publico/participante_lista";
	}

	public String salvar() {
		ParticipanteRN p = new ParticipanteRN();
		p.salvar(this.participante);
		return "novo_participante_sucesso";
	}
}
