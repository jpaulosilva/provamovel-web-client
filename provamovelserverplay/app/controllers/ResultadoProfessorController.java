package controllers;

import java.util.List;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.alunos;

public class ResultadoProfessorController extends Controller {
	public static Result getResultadoAluno(Integer idprova,String emailAluno ) {
		return TODO;
	}
	
	public static Result getAlunosPorProva(Integer id) {
		List<User> users = User.find.all();
		return ok(alunos.render(users));
	}
}
