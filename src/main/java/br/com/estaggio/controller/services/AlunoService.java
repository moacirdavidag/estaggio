package br.com.estaggio.controller.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estaggio.controller.exceptions.BusinessException;
import br.com.estaggio.model.daos.AlunoDAO;
import br.com.estaggio.model.entities.AlunoEntity;
import br.com.estaggio.model.utils.Transactional;

public class AlunoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void criarAluno(AlunoEntity aluno)throws BusinessException {
		if(aluno == null) {
			throw new BusinessException("Não foi possível registrar o aluno!");
		}
		this.alunoDAO.inserirAluno(aluno);
	}
	
	@Transactional
	public List<AlunoEntity> todosAlunos() {
		return this.alunoDAO.todosAlunos();
	}
	
	@Transactional
	public void excluirAluno(AlunoEntity aluno) {
		this.alunoDAO.excluirAluno(aluno);
	}
}
