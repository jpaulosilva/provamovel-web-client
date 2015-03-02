package controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Prova;
import models.Questao;
import models.TipoQuestao;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.formprova;
import views.html.formprovaquestao;
import views.html.listarprovas;

public class ProvaController extends Controller {

	static Form<Prova> provaForm = new Form(Prova.class);
	static Form<Questao> questaoForm = new Form(Questao.class);

	public static Result salvar() {
		return ok(formprova.render(provaForm));
	}

	public static Result salvarAction() {
		Form<Prova> form = provaForm.bindFromRequest(request());
		if (!form.hasErrors()) {
			try {
				Prova p = form.get();
				p.setAuthor(User.find.byId(session("login")));
				p.setCriacao(new Date());
				form.get().save();
				return redirect(routes.ProvaController.editar(p.getId()));

			} catch (Exception e) {
				return badRequest(formprova.render(provaForm));
			}

		} else {
			return badRequest(formprova.render(provaForm));
		}
	}

	public static Result addQuestaoAction(Long idProva) {
		Prova p = Prova.find.byId(idProva);

		Form<Questao> form = questaoForm.bindFromRequest(request());
		if (!form.hasErrors()) {
			try {
				Questao q = form.get();
				q.setProva(p);

				if (q.getTipo() == TipoQuestao.fechada) {
					 DynamicForm requestData = form.form().bindFromRequest();
					 HashMap values = (HashMap) requestData.get().getData();
					 

					return redirect(routes.Application.debug(values.toString()));
				}

				q.save();
				return redirect(routes.ProvaController.editar(p.getId()));

			} catch (Exception e) {
				// return badRequest(formprova.render(provaForm));
				return redirect(routes.Application.debug(e.getMessage()));
			}

		} else {
			return badRequest(formprova.render(provaForm));
		}

	}

	public static Result listar() {
		List<Prova> provas = Prova.find.all();
		return ok(listarprovas.render(provas));
	}

	public static Result visualizar(Integer id) {
		return TODO;
	}

	public static Result editar(Long id) {
		Prova p = Prova.find.byId(id);
		if (p == null) {
			return redirect(routes.ProvaController.listar());
		} else {
			Form<Prova> form = provaForm.fill(p);
			return ok(formprovaquestao.render(p, form));
		}
	}

	public static Result atualizarAction(Long id) {
		return TODO;
	}

	public static Result excluir(Long id) {
		Prova p = Prova.find.byId(id);
		if (p != null) {
			p.delete();
		}
		return redirect(routes.ProvaController.listar());
	}

	public static Result adicionarAluno(String email) {
		return TODO;
	}

	public static Result excluirAluno(String email) {
		return TODO;
	}
}
