package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Resposta extends Model{
	@Id
	Long id;
	String resposta;
	@ManyToOne(cascade=CascadeType.ALL)
	RespostaProva respostaProva;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public RespostaProva getRespostaProva() {
		return respostaProva;
	}
	public void setRespostaProva(RespostaProva respostaProva) {
		this.respostaProva = respostaProva;
	}
	
	
}
