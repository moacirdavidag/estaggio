package br.com.estaggio.model.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estaggio.model.entities.AlunoEntity;

public class AlunoDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public void inserirAluno(AlunoEntity aluno) {
		manager.persist(aluno);
	}
	
	public List<AlunoEntity> todosAlunos() {
		TypedQuery<AlunoEntity> query = manager.createQuery("FROM AlunoEntity", AlunoEntity.class);
		return query.getResultList();
	}
	
	public void excluirAluno(AlunoEntity aluno) {
		this.manager.remove(aluno);
	}

}
