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
@Table(name = "tb_avaliacao_professor")
public class AvaliacaoProfessorEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private OrientadorEntity orientador;
	@OneToOne 
	private AlunoEntity aluno;
	@OneToOne
	private EstagioEntity estagio;
	
	private String assiduidade;
	private String disciplina;
	private String sociabilidade;
	private String responsabilidade;
	private String iniciativa;
	
	public AvaliacaoProfessorEntity() {}

	public AvaliacaoProfessorEntity(OrientadorEntity orientador, AlunoEntity aluno, EstagioEntity estagio) {
		super();
		this.orientador = orientador;
		this.aluno = aluno;
		this.estagio = estagio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrientadorEntity getOrientador() {
		return orientador;
	}

	public void setOrientador(OrientadorEntity orientador) {
		this.orientador = orientador;
	}

	public AlunoEntity getAluno() {
		return aluno;
	}

	public void setAluno(AlunoEntity aluno) {
		this.aluno = aluno;
	}

	public String getAssiduidade() {
		return assiduidade;
	}

	public void setAssiduidade(String assiduidade) {
		this.assiduidade = assiduidade;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSociabilidade() {
		return sociabilidade;
	}

	public void setSociabilidade(String sociabilidade) {
		this.sociabilidade = sociabilidade;
	}

	public String getResponsabilidade() {
		return responsabilidade;
	}

	public void setResponsabilidade(String responsabilidade) {
		this.responsabilidade = responsabilidade;
	}

	public String getIniciativa() {
		return iniciativa;
	}

	public void setIniciativa(String iniciativa) {
		this.iniciativa = iniciativa;
	}

	public EstagioEntity getEstagio() {
		return estagio;
	}

	public void setEstagio(EstagioEntity estagio) {
		this.estagio = estagio;
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
		AvaliacaoProfessorEntity other = (AvaliacaoProfessorEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AvaliacaoProfessor [id=" + id + ", orientador=" + orientador + ", aluno=" + aluno + ", estagio="
				+ estagio + "]";
	} 

}
