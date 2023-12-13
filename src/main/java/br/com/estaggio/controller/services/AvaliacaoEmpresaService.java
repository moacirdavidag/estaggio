package br.com.estaggio.controller.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estaggio.model.daos.AvaliacaoEmpresaDAO;
import br.com.estaggio.model.entities.AvaliacaoEmpresaEntity;
import br.com.estaggio.model.utils.Transactional;

public class AvaliacaoEmpresaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AvaliacaoEmpresaDAO avaliacaoEmpresaDAO;
	
	@Transactional
	public void inserirAvaliacaoEmpresa(AvaliacaoEmpresaEntity avaliacao) {
		this.avaliacaoEmpresaDAO.inserirAvaliacaoEmpresa(avaliacao);
	}
	
	@Transactional
	public List<AvaliacaoEmpresaEntity> todasAvaliacoes() {
		return this.avaliacaoEmpresaDAO.todasAvaliacoes();
	}

	@Transactional
	public AvaliacaoEmpresaEntity buscarPorId(Long id) {
		return this.avaliacaoEmpresaDAO.buscarPorId(id);
	}
	
}
