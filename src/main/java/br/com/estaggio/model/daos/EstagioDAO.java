package br.com.estaggio.model.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estaggio.model.entities.EstagioEntity;

public class EstagioDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void inserirEstagio(EstagioEntity estagio) {
		this.manager.persist(estagio);
	}
	
	public List<EstagioEntity> todosEstagios() {
		TypedQuery<EstagioEntity> query = manager.createQuery("FROM EstagioEntity", EstagioEntity.class);
		return query.getResultList();
	}
	
	public void deletarEstagio(EstagioEntity estagio) {
		this.manager.remove(estagio);
	}
	
	public EstagioEntity buscarPorId(Long id) {
		return this.manager.find(EstagioEntity.class, id);
	}

	public void atualizarEstagio(EstagioEntity estagio) {
		this.manager.merge(estagio);
		this.manager.flush();
	}
	
}
