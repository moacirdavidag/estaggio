package br.com.estaggio.controller.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estaggio.model.daos.EstagioDAO;
import br.com.estaggio.model.entities.EstagioEntity;
import br.com.estaggio.model.utils.Transactional;

public class EstagioService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstagioDAO estagioDAO;
	
	@Transactional
	public void inserirEstagio(EstagioEntity estagio) {
		this.estagioDAO.inserirEstagio(estagio);
	}
	
	@Transactional
	public List<EstagioEntity> todosEstagios() {
		return this.estagioDAO.todosEstagios();
	}
	
	@Transactional
	public void removerEstagio(EstagioEntity estagio) {
		this.estagioDAO.deletarEstagio(estagio);
	}

	@Transactional
	public EstagioEntity buscarPorId(Long id) {
		return this.estagioDAO.buscarPorId(id);
	}
	
	@Transactional
	public void atualizarEstagio(EstagioEntity estagio) {
		this.estagioDAO.atualizarEstagio(estagio);
	}
}
