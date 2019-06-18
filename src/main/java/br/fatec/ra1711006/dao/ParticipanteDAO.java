package br.fatec.ra1711006.dao;

import java.util.List;
import br.fatec.ra1711006.model.Participante;

public interface ParticipanteDAO {
	public void salvar(Participante participante);
	public Participante carregar(Integer codigo);
	public List<Participante> listar();
}
