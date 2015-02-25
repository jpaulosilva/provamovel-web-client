package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
@Entity
public class Prova extends Model{
	@Id
	Long id;
	User author;
	
	
	@OneToMany(cascade=CascadeType.PERSIST)
	List<User> alunos;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="prova")
	List<Questao> questoes;

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
	
	
}
