package br.com.estaggio.model.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estaggio.model.entities.AvaliacaoProfessorEntity;

public class AvaliacaoProfessorDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<AvaliacaoProfessorEntity> todasAvaliacoes() {
		TypedQuery<AvaliacaoProfessorEntity> query = manager.createQuery("FROM AvaliacaoProfessorEntity", AvaliacaoProfessorEntity.class);
		return query.getResultList();
	}
	
	public void criarAvaliacaoProfessor(AvaliacaoProfessorEntity avaliacao) {
		this.manager.persist(avaliacao);
	}
	
	public AvaliacaoProfessorEntity buscarPorId(Long id) {
		return this.manager.find(AvaliacaoProfessorEntity.class, id);
	}

}
