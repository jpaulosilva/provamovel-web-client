package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.Alternativa;
import models.Prova;
import models.Questao;
import models.TipoQuestao;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.entrar;

public class MobileController extends Controller {
	public static Result login() {
		/*
		 * JsonNode json = request().body().asJson(); String email =
		 * json.findValue("login").asText(); String password =
		 * json.findValue("password").asText();
		 * 
		 * User busca = User.find.byId(email); if(busca == null){ return
		 * ok(Json.
		 * toJson("{'error':'1','errorMessage':'Usuário não encontrado'}"));
		 * }else{ if(!busca.getPassword().equals(password)){ return
		 * ok(Json.toJson("{'error':'1','errorMessage':'Senha inválida'}"));
		 * }else{ busca.setHash(UtilPassword.generateHash(busca));
		 * busca.update();
		 * 
		 * session("login",busca.getEmail()); session("hash",busca.getHash());
		 * 
		 * return ok(Json.toJson("{'error':'0','hash':'"+busca.getHash()+"'}"));
		 * } }
		 */
		response().setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost");
		Map<String, Object> jzon = new HashMap<String, Object>();
		jzon.put("error", "0");
		jzon.put("hash", "10");
		return ok(Json.toJson(jzon));
	}

	public static Result getProvas() {
		response().setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost");
		List<Prova> provas = Prova.find.all();
		Map<String, String> jzon = new HashMap<String, String>();
		for (Prova p : provas) {
			jzon.put("titulo", p.getTitulo());
			jzon.put("autor", p.getAuthor().getEmail());
			jzon.put("data", p.getCriacao().toString());
			jzon.put("questoes", p.getQuestoes().size() + "");

		}

		List<Map<String, String>> items = new ArrayList<Map<String, String>>();
		items.add(jzon);
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("items", items);
		return ok(Json.toJson(retorno));
	}

	public static Result getProva(Long id) {
		response().setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost");
		Prova prova = Prova.find.byId(id);
		Map<String, Object> jzon = new HashMap<String, Object>();

		jzon.put("titulo", prova.getTitulo());

		List<Map<String, Object>> questoes = new ArrayList<Map<String, Object>>();

		jzon.put("titulo", prova.getTitulo());

		for (Questao q : prova.getQuestoes()) {
			Map<String, Object> questao = new HashMap<String, Object>();
			questao.put("titulo", q.getTitulo());
			questao.put("tipo", q.getTipo().toString());
			if (q.getTipo() == TipoQuestao.fechada) {
				List<Map<String, String>> alternativas = new ArrayList<Map<String, String>>();

				for (Alternativa a : q.getAlternativas()) {
					Map<String, String> alternativa = new HashMap<String, String>();
					alternativa.put("titulo", a.getTitulo());
					alternativas.add(alternativa);
				}
				questao.put("alternativas", alternativas);
			}
			questoes.add(questao);
		}

		jzon.put("questoes", questoes);

		return ok(Json.toJson(jzon));
	}
}
