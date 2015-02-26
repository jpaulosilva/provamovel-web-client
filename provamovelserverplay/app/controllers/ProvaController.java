package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Prova;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.listarprovas;

public class ProvaController extends Controller {
	public static Result salvar() {
		return TODO;
	}

	public static Result listar() {
		List<Prova> provas = Prova.find.all();
		return ok(listarprovas.render(provas));
	}

	public static Result visualizar(Integer id) {
		return TODO;
	}

	public static Result editar(Integer id) {
		return TODO;
	}

	public static Result atualizar(Integer id) {
		return TODO;
	}

	public static Result excluir(Integer id) {
		return TODO;
	}
	
	public static Result adicionarAluno(String email) {
		return TODO;
	}
	
	public static Result excluirAluno(String email) {
		return TODO;
	}
}
