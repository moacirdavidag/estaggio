package br.com.estaggio.view.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estaggio.controller.exceptions.BusinessException;
import br.com.estaggio.controller.services.AlunoService;
import br.com.estaggio.controller.services.EmpresaService;
import br.com.estaggio.model.daos.EmpresaDAO;
import br.com.estaggio.model.entities.EmpresaEntity;


@Named
@ViewScoped
public class EmpresaManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaDAO empresaDAO; 
	
	@Inject
	private EmpresaService empresaService;
	
	private EmpresaEntity empresa = new EmpresaEntity();
	
	private List<EmpresaEntity> empresas = new ArrayList<>();
	
	private EmpresaEntity empresaSelecionada;
	
	public void init() {
		this.empresas = empresaDAO.todasEmpresas();
	}
	
	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	
	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresaDAO.todasEmpresas();
	}
	
	public EmpresaEntity getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(EmpresaEntity empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.empresaService.inserirEmpresa(empresa);;
			this.empresa = new EmpresaEntity();
			context.addMessage(null, new FacesMessage("Empresa salva com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} 
	}
	
	public void consultar() {
		this.empresas = this.empresaDAO.todasEmpresas();
	}
	
}
