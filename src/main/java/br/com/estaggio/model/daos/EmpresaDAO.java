package br.com.estaggio.model.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.estaggio.model.entities.AlunoEntity;
import br.com.estaggio.model.entities.EmpresaEntity;

public class EmpresaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void inserirEmpresa(EmpresaEntity empresa) {
		manager.persist(empresa);
	}
	
	public List<EmpresaEntity> todasEmpresas() {
		TypedQuery<EmpresaEntity> query = manager.createQuery("FROM EmpresaEntity", EmpresaEntity.class);
		return query.getResultList();
	}
	
	public void removerEmpresa(EmpresaEntity empresa) {
		this.manager.remove(empresa);
	}
	
	public EmpresaEntity buscarPorId(Long id) {
		return this.manager.find(EmpresaEntity.class, id);
	}
	
	public void atualizarEmpresa(EmpresaEntity empresa) {
		this.manager.merge(empresa);
		this.manager.flush();
	}

}
