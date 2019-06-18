package br.fatec.ra1711006.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
// import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

// import antlr.collections.List;
import br.fatec.ra1711006.dao.EventoDAO;
import br.fatec.ra1711006.dao.EventoDAOHibernate;
import br.fatec.ra1711006.model.Evento;

import br.fatec.ra1711006.controller.EventoRN;

@ManagedBean(name = "eventoBean")
@RequestScoped

public class EventoBean {
	private Evento evento = new Evento();
	
	private DataModel<Evento> listaEventos;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	// @SuppressWarnings("unchecked")
	public DataModel<Evento> getListaEventos() {
		if (listaEventos == null) {
			EventoDAO dao = new EventoDAOHibernate();
			listaEventos = new ListDataModel<Evento>(dao.listar());
		}
		return listaEventos;
	}

	public void setListaEventos(DataModel<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	public String novo() {
		this.evento = new Evento();
		this.evento.setAtivo(true);
		return "publico/novo_evento";
	}

	public String listagem() {
		this.evento = new Evento();
		return "publico/evento_lista";
	}

	public String salvar() {
		System.out.println("Salvar");

		EventoRN e = new EventoRN();
		e.salvar(this.evento);

		return "/index";
	}
	
	public List<SelectItem> getEventos() {
		List<SelectItem> eventos = new ArrayList<SelectItem>();

		EventoRN eRN = new EventoRN();
		List<Evento> evento2 = eRN.listar();

		for (Evento e : evento2) {
			SelectItem selecao = new SelectItem(e.getIdEvento(), e.getNomeEvento());
			eventos.add(selecao);
		}

		return eventos;
	}
}
