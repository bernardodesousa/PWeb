package br.fatec.ra1711006.controller;

import java.util.List;

import br.fatec.ra1711006.dao.DAOFactoryParticipante;
import br.fatec.ra1711006.dao.ParticipanteDAO;
import br.fatec.ra1711006.model.Participante;

public class ParticipanteRN {
	private ParticipanteDAO participanteDAO;

	public ParticipanteRN() {
		this.participanteDAO = DAOFactoryParticipante.criaParticipanteDAO();
	}

	public Participante carregar(Integer codigo, String opcao) {
		return this.participanteDAO.carregar(codigo);
	}

	public void salvar(Participante participante) {
		this.participanteDAO.salvar(participante);
	}

	// @SuppressWarnings("unchecked")
	public List<Participante> listar() {
		return this.participanteDAO.listar();
	}
}
