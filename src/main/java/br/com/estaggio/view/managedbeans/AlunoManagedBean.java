package br.com.estaggio.view.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estaggio.controller.services.AlunoService;
import br.com.estaggio.model.daos.AlunoDAO;
import br.com.estaggio.model.entities.AlunoEntity;

@Named
@ViewScoped
public class AlunoManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoDAO alunoDAO; 
	
	@Inject
	private AlunoService alunoService;
	
	private AlunoEntity aluno = new AlunoEntity();
	
	private String nome = "Moacir David";

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public AlunoEntity getAluno() {
		return aluno;
	}

	public void setAluno(AlunoEntity aluno) {
		this.aluno = aluno;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.alunoService.criarAluno(aluno);
			this.aluno = new AlunoEntity();
			context.addMessage(null, new FacesMessage("Aluno salvo com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} 
	}
	
}
