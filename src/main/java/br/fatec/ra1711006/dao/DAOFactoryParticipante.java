package br.fatec.ra1711006.dao;

import br.fatec.ra1711006.util.HibernateUtil;

public class DAOFactoryParticipante {
	public static ParticipanteDAO criaParticipanteDAO() {
		ParticipanteDAOHibernate participanteDAO = new ParticipanteDAOHibernate();
		participanteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return participanteDAO;
	}
}
