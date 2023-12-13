package br.com.estaggio.model.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao_empresa")
public class AvaliacaoEmpresaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private AlunoEntity aluno;
	@OneToOne
	private EmpresaEntity empresa;
	@OneToOne
	private EstagioEntity estagio;
	
	private String rendimento;
	private String conhecimento;
	private String cumprimentoTarefas;
	private String aprendizagem;
	private String desempenho;
	
	public AvaliacaoEmpresaEntity() {}

	public AvaliacaoEmpresaEntity(Long id, AlunoEntity aluno, EmpresaEntity empresa, EstagioEntity estagio,
			String rendimento, String conhecimento, String cumprimentoTarefas, String aprendizagem, String desempenho) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.empresa = empresa;
		this.estagio = estagio;
		this.rendimento = rendimento;
		this.conhecimento = conhecimento;
		this.cumprimentoTarefas = cumprimentoTarefas;
		this.aprendizagem = aprendizagem;
		this.desempenho = desempenho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AlunoEntity getAluno() {
		return aluno;
	}

	public void setAluno(AlunoEntity aluno) {
		this.aluno = aluno;
	}

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	public EstagioEntity getEstagio() {
		return estagio;
	}

	public void setEstagio(EstagioEntity estagio) {
		this.estagio = estagio;
	}

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}

	public String getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(String conhecimento) {
		this.conhecimento = conhecimento;
	}

	public String getCumprimentoTarefas() {
		return cumprimentoTarefas;
	}

	public void setCumprimentoTarefas(String cumprimentoTarefas) {
		this.cumprimentoTarefas = cumprimentoTarefas;
	}

	public String getAprendizagem() {
		return aprendizagem;
	}

	public void setAprendizagem(String aprendizagem) {
		this.aprendizagem = aprendizagem;
	}

	public String getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(String desempenho) {
		this.desempenho = desempenho;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoEmpresaEntity other = (AvaliacaoEmpresaEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AvaliacaoEmpresaEntity [id=" + id + ", aluno=" + aluno + ", empresa=" + empresa + ", estagio=" + estagio
				+ ", rendimento=" + rendimento + ", conhecimento=" + conhecimento + ", cumprimentoTarefas="
				+ cumprimentoTarefas + ", aprendizagem=" + aprendizagem + ", desempenho=" + desempenho + "]";
	}
}
