package br.com.estaggio.model.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estagios")
public class EstagioEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@ManyToOne
    private OrientadorEntity orientador;

    @ManyToOne
    private AlunoEntity aluno;

    @ManyToOne
    private EmpresaEntity empresa;
	
    public EstagioEntity() {}
    
	public EstagioEntity(Long id, String descricao, OrientadorEntity orientador, AlunoEntity aluno,
			EmpresaEntity empresa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.orientador = orientador;
		this.aluno = aluno;
		this.empresa = empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
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
		EstagioEntity other = (EstagioEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EstagioEntity [id=" + id + ", descricao=" + descricao + ", orientador=" + orientador + ", aluno="
				+ aluno + ", empresa=" + empresa + "]";
	}
}
