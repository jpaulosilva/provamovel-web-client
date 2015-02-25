package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
@Entity
public class RespostaProva extends Model{
	@Id
	Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Prova prova;
	User aluno;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="respostaProva")
	List<Resposta> respostas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public User getAluno() {
		return aluno;
	}

	public void setAluno(User aluno) {
		this.aluno = aluno;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	
	
}
