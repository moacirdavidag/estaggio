package br.com.estaggio.view.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.estaggio.controller.services.EstagioService;
import br.com.estaggio.model.daos.AlunoDAO;
import br.com.estaggio.model.daos.EmpresaDAO;
import br.com.estaggio.model.daos.EstagioDAO;
import br.com.estaggio.model.daos.OrientadorDAO;
import br.com.estaggio.model.entities.AlunoEntity;
import br.com.estaggio.model.entities.EmpresaEntity;
import br.com.estaggio.model.entities.EstagioEntity;
import br.com.estaggio.model.entities.OrientadorEntity;

@Named
@ViewScoped
public class EstagioManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstagioDAO estagioDAO;
	
	@Inject
	private EstagioService estagioService;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Inject
	private EmpresaDAO empresaDAO;
	
	@Inject
	private OrientadorDAO orientadorDAO;
	
	private List<EstagioEntity> estagios = new ArrayList<>();
	
	private List<AlunoEntity> alunos = new ArrayList<>();
	
	private List<EmpresaEntity> empresas = new ArrayList<>();
	
	private List<OrientadorEntity> orientadores = new ArrayList<>();
	
	private EstagioEntity estagio = new EstagioEntity();
	private Date dataInicio;
    private Date dataFinal;
    private EstagioEntity estagioSelecionado = new EstagioEntity();
    
    private Long id;
    private AlunoEntity alunoSelecionado = new AlunoEntity();
    private OrientadorEntity orientadorSelecionado = new OrientadorEntity();
    private EmpresaEntity empresaSelecionada = new EmpresaEntity();
	
	@PostConstruct
	public void init() {
		this.estagios = estagioDAO.todosEstagios();
		this.alunos = this.alunoDAO.todosAlunos();
		this.orientadores = this.orientadorDAO.todosOrientadores();
		this.empresas = this.empresaDAO.todasEmpresas();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.estagio.setStatus("EM ANDAMENTO");
			Date sqlDataInicio = new Date(dataInicio.getTime());
	        Date sqlDataFinal = new Date(dataFinal.getTime());
	        
	        this.estagio.setDataInicio(sqlDataInicio);
	        this.estagio.setDataFinal(sqlDataFinal);

	        this.estagioService.inserirEstagio(estagio);
	        this.estagio = new EstagioEntity();
			this.estagioService.inserirEstagio(estagio);
			this.estagio = new EstagioEntity();
			context.addMessage(null, new FacesMessage("Estágio salvo com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} 
	}
	
	public List<EstagioEntity> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<EstagioEntity> estagios) {
		this.estagios = estagios;
	}

	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = this.alunoDAO.todosAlunos();
	}

	public List<EmpresaEntity> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaEntity> empresas) {
		this.empresas = this.empresaDAO.todasEmpresas();
	}

	public List<OrientadorEntity> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<OrientadorEntity> orientadores) {
		this.orientadores = this.orientadorDAO.todosOrientadores();
	}

	public EstagioEntity getEstagio() {
		return estagio;
	}

	public void setEstagio(EstagioEntity estagio) {
		this.estagio = estagio;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public EstagioEntity getEstagioSelecionado() {
		return estagioSelecionado;
	}

	public void setEstagioSelecionado(EstagioEntity estagioSelecionado) {
		this.estagioSelecionado = estagioSelecionado;
	}

	public AlunoEntity getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(AlunoEntity alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrientadorEntity getOrientadorSelecionado() {
		return orientadorSelecionado;
	}

	public void setOrientadorSelecionado(OrientadorEntity orientadorSelecionado) {
		this.orientadorSelecionado = orientadorSelecionado;
	}


	public EmpresaEntity getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(EmpresaEntity empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}

	public void consultar() {
		this.estagios = this.estagioDAO.todosEstagios();
	}
	
	public void consultarAlunos() {
		this.alunoDAO.todosAlunos();
	}
	
	public void consultarEmpresas() {
		this.empresaDAO.todasEmpresas();
	}
	
	public void consultarOrientadores() {
		this.orientadorDAO.todosOrientadores();
	}
	
	public String removerEstagio(Long id) {
		this.estagio = this.estagioService.buscarPorId(id);
		if(estagio != null) {			
			this.estagioService.removerEstagio(estagio);
		}
	    this.estagios.remove(estagio);
	    consultar();
	    return "estagios?faces-redirect=true";
	}

	public EstagioEntity carregarEstagioAtualizacao() {
		this.estagioSelecionado = this.estagioDAO.buscarPorId(id);
		if (estagioSelecionado.getAluno() != null && estagioSelecionado.getAluno().getId() != null) {
	        estagioSelecionado.setAluno(alunoDAO.buscarPorId(estagioSelecionado.getAluno().getId()));
	    }
		return this.estagioSelecionado;
	}
	
	public String salvarAtualizacao() {
		this.estagioSelecionado.setAluno(alunoSelecionado);
		this.estagioSelecionado.setOrientador(orientadorSelecionado);
		this.estagioSelecionado.setEmpresa(empresaSelecionada);
		this.estagioService.atualizarEstagio(estagioSelecionado);
		this.estagioSelecionado = new EstagioEntity();
		return "estagios?faces-redirect=true";
	}
	
	public String redirectTo(String page, Long id) {
	    return page + "?faces-redirect=true&idEstagio=" + id;
	}

	
}
