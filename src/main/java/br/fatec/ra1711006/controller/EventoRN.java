package br.fatec.ra1711006.controller;

import java.util.List;

import br.fatec.ra1711006.dao.DAOFactoryEvento;
import br.fatec.ra1711006.dao.EventoDAO;
import br.fatec.ra1711006.model.Evento;

public class EventoRN {
	private EventoDAO eventoDAO;

	public EventoRN() {
		this.eventoDAO = DAOFactoryEvento.criaEventoDAO();
	}

	public Evento carregar(Integer codigo, String opcao) {
		return this.eventoDAO.carregar(codigo);
	}

	public void salvar(Evento evento) {
		Integer codigo = evento.getIdEvento();
		if (codigo == null || codigo == 0) {
			this.eventoDAO.salvar(evento);
		} else {
			this.eventoDAO.atualizar(evento);
		}
	}

	// @SuppressWarnings("unchecked")
	public List<Evento> listar() {
		return this.eventoDAO.listar();
	}
}
