package br.com.estaggio.controller.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.estaggio.model.daos.EmpresaDAO;
import br.com.estaggio.model.entities.EmpresaEntity;
import br.com.estaggio.model.utils.Transactional;

public class EmpresaService implements Serializable {

	@Inject
	private EmpresaDAO empresaDAO;
	
	@Transactional
	public void inserirEmpresa(EmpresaEntity empresa) {
		this.empresaDAO.inserirEmpresa(empresa);
	}
	
	@Transactional
	public List<EmpresaEntity> todasEmpresas() {
		return this.empresaDAO.todasEmpresas();
	}
	
}
