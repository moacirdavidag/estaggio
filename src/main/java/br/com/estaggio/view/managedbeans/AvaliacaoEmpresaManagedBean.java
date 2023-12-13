package br.com.estaggio.view.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estaggio.controller.services.AvaliacaoEmpresaService;
import br.com.estaggio.model.daos.AlunoDAO;
import br.com.estaggio.model.daos.AvaliacaoEmpresaDAO;
import br.com.estaggio.model.daos.EmpresaDAO;
import br.com.estaggio.model.daos.EstagioDAO;
import br.com.estaggio.model.daos.OrientadorDAO;
import br.com.estaggio.model.entities.AlunoEntity;
import br.com.estaggio.model.entities.AvaliacaoEmpresaEntity;
import br.com.estaggio.model.entities.AvaliacaoProfessorEntity;
import br.com.estaggio.model.entities.EmpresaEntity;
import br.com.estaggio.model.entities.EstagioEntity;

@Named
@ViewScoped
public class AvaliacaoEmpresaManagedBean implements Serializable {

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
	private AvaliacaoEmpresaDAO avaliacaoEmpresaDAO;
	
	@Inject AvaliacaoEmpresaService avaliacaoEmpresaService;
	
	@Inject
	private EstagioManagedBean estagioManagedBean;
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private List<AvaliacaoEmpresaEntity> avaliacoes = new ArrayList<>();
	
	private List<AlunoEntity> alunos = new ArrayList<>();
	
	private List<EmpresaEntity> empresas = new ArrayList<>();
	
	private EstagioEntity estagioSelecionado;
	
	private AvaliacaoEmpresaEntity avaliacao;
	
	@PostConstruct
	public void init() {
	    this.avaliacao = new AvaliacaoEmpresaEntity(); 
	}
	
	public List<AvaliacaoEmpresaEntity> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoEmpresaEntity> avaliacoes) {
		this.avaliacoes = avaliacoes;
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

	public EstagioEntity getEstagioSelecionado() {
		return estagioSelecionado;
	}

	public void setEstagioSelecionado(EstagioEntity estagioSelecionado) {
		this.estagioSelecionado = estagioSelecionado;
	}

	public AvaliacaoEmpresaEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoEmpresaEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			avaliacao.setEstagio(estagioDAO.buscarPorId(estagioManagedBean.getEstagioSelecionado().getId()));
			avaliacao.setAluno(alunoDAO.buscarPorId(estagioManagedBean.getEstagioSelecionado().getAluno().getId()));
			avaliacao.setEmpresa(
					empresaDAO.buscarPorId(estagioManagedBean.getEstagioSelecionado().getOrientador().getId()));

			this.avaliacaoEmpresaService.inserirAvaliacaoEmpresa(avaliacao);
			this.avaliacao = new AvaliacaoEmpresaEntity();
			context.addMessage(null, new FacesMessage("Avaliação salva com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() {
		this.avaliacoes = this.avaliacaoEmpresaDAO.todasAvaliacoes();
	}

	public void consultarEstagioAvaliacao(String id) {
		this.avaliacao = this.avaliacaoEmpresaDAO.buscarPorId(new Long(id));
	}

}
