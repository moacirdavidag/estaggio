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
import br.com.estaggio.model.entities.AlunoEntity;
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
	
	private OrientadorEntity orientadorSelecionado = new OrientadorEntity();
	
	private Long id;
	
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
	
	public OrientadorEntity getOrientadorSelecionado() {
		return orientadorSelecionado;
	}

	public void setOrientadorSelecionado(OrientadorEntity orientadorSelecionado) {
		this.orientadorSelecionado = orientadorSelecionado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.orientadorService.inserirOrientador(orientador);;
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
	
	public String removerOrientador(Long id) {
		this.orientador = this.orientadorService.buscarPorId(id);
		if(orientador != null) {			
			this.orientadorService.removerOrientador(orientador);
		}
	    this.orientadores.remove(orientador);
	    consultar();
	    return "orientadores?faces-redirect=true";
	}
	
	public OrientadorEntity carregarOrientadorAtualizacao() {
		this.orientadorSelecionado = this.orientadorDAO.buscarPorId(id);
		return this.orientadorSelecionado;
	}
	
	public String salvarAtualizacao() {
		this.orientadorService.atualizarOrientador(orientadorSelecionado);
		this.orientadorSelecionado = new OrientadorEntity();
		return "orientadores?faces-redirect=true";
	}
}
