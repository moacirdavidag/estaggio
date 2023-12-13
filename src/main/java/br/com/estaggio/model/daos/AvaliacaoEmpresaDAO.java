package br.com.estaggio.model.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estaggio.model.entities.AvaliacaoEmpresaEntity;

public class AvaliacaoEmpresaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void inserirAvaliacaoEmpresa(AvaliacaoEmpresaEntity avaliacao) {
		this.manager.persist(avaliacao);
	}
	
	public List<AvaliacaoEmpresaEntity> todasAvaliacoes() {
		TypedQuery<AvaliacaoEmpresaEntity> query = manager.createQuery("FROM AvaliacaoEmpresaEntity", AvaliacaoEmpresaEntity.class);
		return query.getResultList();
	}

	public AvaliacaoEmpresaEntity buscarPorId(Long id) {
		return this.manager.find(AvaliacaoEmpresaEntity.class, id);
	}
	
}
