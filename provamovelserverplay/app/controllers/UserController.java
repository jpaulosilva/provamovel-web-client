package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cadastrar;

;

public class UserController extends Controller {
	static Form<User> userForm = new Form(User.class);

	public static Result entrar() {
		return TODO;
	}

	public static Result cadastrar() {
		Form<User> form = userForm.bindFromRequest(request());
		if (!form.hasErrors()) {
			form.get().save();
			return redirect(routes.ResultadoProfessorController
					.getAlunosPorProva(1));
		} else {
			return badRequest(cadastrar.render(form));
		}

	}

	public static Result showCadastrar() {
		return ok(cadastrar.render(userForm));

	}

	public static Result sair() {
		return TODO;
	}
}
