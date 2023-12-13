package br.com.estaggio.view.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estaggio.controller.services.AvaliacaoProfessorService;
import br.com.estaggio.model.daos.AlunoDAO;
import br.com.estaggio.model.daos.AvaliacaoProfessorDAO;
import br.com.estaggio.model.daos.EmpresaDAO;
import br.com.estaggio.model.daos.EstagioDAO;
import br.com.estaggio.model.daos.OrientadorDAO;
import br.com.estaggio.model.entities.AlunoEntity;
import br.com.estaggio.model.entities.AvaliacaoProfessorEntity;
import br.com.estaggio.model.entities.EmpresaEntity;
import br.com.estaggio.model.entities.OrientadorEntity;

@Named
@ViewScoped
public class AvaliacaoProfessorManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoDAO alunoDAO;
	@Inject
	private EmpresaDAO empresaDAO;
	@Inject
	private OrientadorDAO orientadorDAO;
	@Inject
	private EstagioDAO estagioDAO;
	@Inject
	private AvaliacaoProfessorDAO avaliacaoProfessorDAO;
	@Inject
	private AvaliacaoProfessorService avaliacaoProfessorService;
	
	@Inject
	private EstagioManagedBean estagioManagedBean;

	private List<AvaliacaoProfessorEntity> avaliacoes = new ArrayList<>();

	private Long id;

	public List<AvaliacaoProfessorEntity> getAvaliacoes() {
		return avaliacoes;
	}

	private AvaliacaoProfessorEntity avaliacao = new AvaliacaoProfessorEntity();

	private List<AlunoEntity> alunos = new ArrayList<>();

	private List<EmpresaEntity> empresas = new ArrayList<>();

	private List<OrientadorEntity> orientadores = new ArrayList<>();

	public void setAvaliacoes(List<AvaliacaoProfessorEntity> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<AvaliacaoProfessorEntity> todasAvaliacoes() {
		return this.avaliacaoProfessorDAO.todasAvaliacoes();
	}

	public AvaliacaoProfessorEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoProfessorEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunos;
	}

	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = empresas;
	}

	public List<OrientadorEntity> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<OrientadorEntity> orientadores) {
		this.orientadores = orientadores;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			avaliacao.setEstagio(estagioDAO.buscarPorId(estagioManagedBean.getEstagioSelecionado().getId()));
			avaliacao.setAluno(alunoDAO.buscarPorId(estagioManagedBean.getEstagioSelecionado().getAluno().getId()));
			avaliacao.setOrientador(
					orientadorDAO.buscarPorId(estagioManagedBean.getEstagioSelecionado().getOrientador().getId()));

			this.avaliacaoProfessorService.criarAvaliacaoProfessor(avaliacao);
			this.avaliacao = new AvaliacaoProfessorEntity();
			context.addMessage(null, new FacesMessage("Avaliação salva com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() {
		this.avaliacoes = this.avaliacaoProfessorDAO.todasAvaliacoes();
	}

	public void consultarEstagioAvaliacao(String id) {
		this.avaliacao = this.avaliacaoProfessorDAO.buscarPorId(new Long(id));
	}
}
