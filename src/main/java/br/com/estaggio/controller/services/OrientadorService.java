package br.com.estaggio.controller.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estaggio.model.daos.OrientadorDAO;
import br.com.estaggio.model.entities.OrientadorEntity;
import br.com.estaggio.model.utils.Transactional;

public class OrientadorService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrientadorDAO orientadorDAO;
	
	@Transactional
	public void inserirOrientador(OrientadorEntity orientador) {
		this.orientadorDAO.inserirOrientador(orientador);
	}
	
	@Transactional
	public List<OrientadorEntity> todosOrientadores() {
		return this.orientadorDAO.todosOrientadores();
	}
	
	@Transactional
	public void removerOrientador(OrientadorEntity orientador) {
		this.orientadorDAO.removerOrientador(orientador);
	}
	
	@Transactional
	public OrientadorEntity buscarPorId(Long id) {
		return this.orientadorDAO.buscarPorId(id);
	}
	
	@Transactional
	public void atualizarOrientador(OrientadorEntity orientador) {
		this.orientadorDAO.editarOrientador(orientador);
	}

}
