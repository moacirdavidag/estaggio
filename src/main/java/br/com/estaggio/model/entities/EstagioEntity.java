package br.com.estaggio.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private String status;
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	private int cargaHorariaTotal;
	
	@ManyToOne
	@JoinColumn(name = "orientador_id")
    private OrientadorEntity orientador;

    @ManyToOne
	@JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @ManyToOne
	@JoinColumn(name = "empresa_id")
    private EmpresaEntity empresa;
    
    @OneToMany(mappedBy = "estagio", cascade = CascadeType.ALL)
	private List <AvaliacaoProfessorEntity> avaliacoesProfessor;
	
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}

	public void setCargaHorariaTotal(int cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
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
