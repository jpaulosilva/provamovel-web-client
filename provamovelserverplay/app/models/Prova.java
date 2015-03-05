package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Prova extends Model {
	@Id
	Long id;

	@Required
	String titulo;

	@Formats.DateTime(pattern = "dd/MM/yyyy")
	Date criacao;

	@OneToOne(optional = true)
	User author;

	@ManyToMany(cascade = CascadeType.ALL)
	List<User> alunos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prova")
	List<Questao> questoes;

	public static Finder<Long, Prova> find = new Finder<Long, Prova>(
			Long.class, Prova.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<User> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<User> alunos) {
		this.alunos = alunos;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}
	
	

}
