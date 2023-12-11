package br.com.estaggio.view.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estaggio.controller.services.OrientadorService;
import br.com.estaggio.model.daos.OrientadorDAO;
import br.com.estaggio.model.entities.EmpresaEntity;
import br.com.estaggio.model.entities.OrientadorEntity;

@Named
@ViewScoped
public class OrientadorManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrientadorDAO orientadorDAO;
	
	@Inject
	private OrientadorService orientadorService;
	
	private OrientadorEntity orientador = new OrientadorEntity();
	
	private List<OrientadorEntity> orientadores = new ArrayList<>();
	
	public void init() {
		this.orientadores = this.orientadorDAO.todosOrientadores();
	}

	public OrientadorEntity getOrientador() {
		return orientador;
	}

	public void setOrientador(OrientadorEntity orientador) {
		this.orientador = orientador;
	}

	public List<OrientadorEntity> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<OrientadorEntity> orientadores) {
		this.orientadores = this.orientadorDAO.todosOrientadores();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.orientadorDAO.inserirOrientador(orientador);;
			this.orientador = new OrientadorEntity();
			context.addMessage(null, new FacesMessage("Orientador salvo com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} 
	}
	
	public void consultar() {
		this.orientadores = this.orientadorDAO.todosOrientadores();
	}
	
}
