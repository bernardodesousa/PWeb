package br.fatec.ra1711006.dao;

import br.fatec.ra1711006.util.HibernateUtil;

public class DAOFactoryEvento {
	public static EventoDAO criaEventoDAO() {
		EventoDAOHibernate eventoDAO = new EventoDAOHibernate();
		eventoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return eventoDAO;
	}
}
