package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
@Entity
public class Questao extends Model{
	@Id
	Long id;
	String titulo;
	
	@OneToOne(optional = true)
	Alternativa correta;
	
	public static Finder<Long, Questao> find = new Finder<Long, Questao>(Long.class, Questao.class);
	
	@ManyToOne(cascade=CascadeType.ALL)
	Prova prova;
	
	@Enumerated(value=EnumType.STRING)
	TipoQuestao tipo;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="questao")
	List<Alternativa> alternativas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public TipoQuestao getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuestao tipo) {
		this.tipo = tipo;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Alternativa getCorreta() {
		return correta;
	}

	public void setCorreta(Alternativa correta) {
		this.correta = correta;
	}
	
	
	
}
