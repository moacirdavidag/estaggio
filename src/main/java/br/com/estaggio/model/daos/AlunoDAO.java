package br.com.estaggio.model.daos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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

}
