package br.com.estaggio.controller.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estaggio.model.daos.AvaliacaoProfessorDAO;
import br.com.estaggio.model.entities.AvaliacaoProfessorEntity;
import br.com.estaggio.model.utils.Transactional;

public class AvaliacaoProfessorService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AvaliacaoProfessorDAO avaliacaoProfessorDAO;
	
	@Transactional
	public void criarAvaliacaoProfessor(AvaliacaoProfessorEntity avaliacao) {
		this.avaliacaoProfessorDAO.criarAvaliacaoProfessor(avaliacao);
	}
	
	@Transactional
	public List<AvaliacaoProfessorEntity> todasAvaliacoes() {
		return this.avaliacaoProfessorDAO.todasAvaliacoes();
	}

}
