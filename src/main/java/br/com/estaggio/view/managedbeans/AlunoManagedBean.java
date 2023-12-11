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
	
	private List<AlunoEntity> alunos = new ArrayList<>();
	
	private AlunoEntity alunoSelecionado;
	
	public void init() {
		this.alunos = alunoDAO.todosAlunos();
	}
	
	public AlunoEntity getAluno() {
		return aluno;
	}

	public void setAluno(AlunoEntity aluno) {
		this.aluno = aluno;
	}

	
	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunoDAO.todosAlunos();
	}
	
	public AlunoEntity getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(AlunoEntity alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
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
	
	public void consultar() {
		this.alunos = this.alunoDAO.todosAlunos();
	}
	
	public void excluirAluno(AlunoEntity aluno) {
        try {
            alunoService.excluirAluno(aluno);
            alunos.remove(aluno); 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno excluído com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir aluno", e.getMessage()));
        }
    }
	
}
