package br.fatec.ra1711006.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fatec.ra1711006.model.Evento;
import br.fatec.ra1711006.util.HibernateUtil;

public class EventoDAOHibernate implements EventoDAO {
	private Session session;
	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Evento evento){
		// System.out.println(evento.getNomeEvento());
		
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(evento);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o evento. Erro: " + e.getMessage());
		}
		
	}

	public Evento carregar(Integer codigo) {
		Evento e = new Evento();
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(Evento.class);
		c.add(Restrictions.eq("IdEvento", codigo));
        e = (Evento)c.uniqueResult();
		return e;
	}

	public void atualizar(Evento evento) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(evento);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar o evento. Erro: " + e.getMessage());
		}
	}

	public void excluir(Evento evento) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(evento);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir o evento. Erro: " + e.getMessage());
		}
	}

	public List<Evento> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Evento";
		@SuppressWarnings("unchecked")
		List<Evento> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		} else {
			System.out.println("Não há eventos");
			return null;
		}
	}
}
