package br.com.estaggio.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.OneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_orientadores")
public class OrientadorEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private String matricula;
	private String email;

	@OneToMany(mappedBy = "orientador")
	private List <AlunoEntity> alunos;

	@OneToMany(mappedBy = "orientador")
	private List<EstagioEntity> estagios;
	
	public OrientadorEntity() {}
	
	public OrientadorEntity(String nome, String cpf, String matricula, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.email = email;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunos;
	}

	public List<EstagioEntity> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<EstagioEntity> estagios) {
		this.estagios = estagios;
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
		OrientadorEntity other = (OrientadorEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "OrientadorEntity [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", matricula=" + matricula
				+ ", email=" + email + "]";
	}

}
