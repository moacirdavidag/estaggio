package br.com.estaggio.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_alunos")
public class AlunoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String matricula;
	private String senha;

	@ManyToOne
    private OrientadorEntity orientador = new OrientadorEntity();

	@ManyToOne
    private EmpresaEntity empresa = new EmpresaEntity();

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List <EstagioEntity> estagios = new ArrayList<>();
	
	@ManyToOne
	private AvaliacaoProfessorEntity avaliacoesProfessor = new AvaliacaoProfessorEntity();
	
	public AlunoEntity() {
	}

	public AlunoEntity(Long id, String nome, String email, String matricula, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public List<EstagioEntity> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<EstagioEntity> estagios) {
		this.estagios = estagios;
	}

	public AvaliacaoProfessorEntity getAvaliacoesProfessor() {
		return avaliacoesProfessor;
	}

	public void setAvaliacoesProfessor(AvaliacaoProfessorEntity avaliacoesProfessor) {
		this.avaliacoesProfessor = avaliacoesProfessor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoEntity other = (AlunoEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AlunoEntity [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + ", senha="
				+ senha + "]";
	}
	
}
