package br.com.estaggio.model.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estaggio.model.entities.OrientadorEntity;

public class OrientadorDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void inserirOrientador(OrientadorEntity orientador) {
		this.manager.persist(orientador);
	}
	
	public List<OrientadorEntity> todosOrientadores() {
		TypedQuery<OrientadorEntity> query = manager.createQuery("FROM OrientadorEntity", OrientadorEntity.class);
		return query.getResultList();
	}
	
	public void removerOrientador(OrientadorEntity orientador) {
		this.manager.remove(orientador);
	}
	
	public OrientadorEntity buscarPorId(Long id) {
		return this.manager.find(OrientadorEntity.class, id);
	}
	
	public void editarOrientador(OrientadorEntity orientador) {
		this.manager.merge(orientador);
		this.manager.flush();
	}

}
