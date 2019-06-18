package br.fatec.ra1711006.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
// import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fatec.ra1711006.util.HibernateUtil;
import br.fatec.ra1711006.model.Participante;

public class ParticipanteDAOHibernate implements ParticipanteDAO {
	private Session session;
	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Participante participante){
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(participante);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o participante. Erro: " + e.getMessage());
		}
	}

	public Participante carregar(Integer codigo){
		Participante p = new Participante();
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(Participante.class);
		c.add(Restrictions.eq("IdParticipante", codigo));
        p = (Participante)c.uniqueResult();
		return p;
	}

	public List<Participante> listar(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Participante";
		@SuppressWarnings("unchecked")
		List<Participante> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		} else {
			System.out.println("Não há participantes");
			return null;
		}
	}
}
