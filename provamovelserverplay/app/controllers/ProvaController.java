package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import models.Alternativa;
import models.Prova;
import models.Questao;
import models.TipoQuestao;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.formprovaquestao;
import views.html.index;
import views.html.listarprovas;

public class ProvaController extends Controller {

	static Form<Prova> provaForm = new Form(Prova.class);
	static Form<Questao> questaoForm = new Form(Questao.class);

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
				return redirect(routes.ProvaController.listar());
			}

		} else {
			return redirect(routes.ProvaController.listar());
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
					q.setAlternativas(new ArrayList<Alternativa>());

					Integer count = Integer.parseInt((String) values
							.get("count"));
					for (int i = 1; i <= count; i++) {
						if (values.get("alt" + i) != null) {
							Alternativa a = new Alternativa();
							a.setTitulo((String) values.get("alt" + i));
							a.setIndice((long) i);
							q.getAlternativas().add(a);

						}
					}

					// return
					// redirect(routes.Application.debug(values.toString()));
				}

				q.save();
				return redirect(routes.ProvaController.editar(p.getId()));

			} catch (Exception e) {
				// return badRequest(formprova.render(provaForm));
				return redirect(routes.Application.debug(e.getMessage()));
			}

		} else {
			// return redirect(routes.ProvaController.editar(p.getId()));
			return redirect(routes.Application.debug(form.errorsAsJson()
					.toString()));
		}

	}

	public static Result listar() {
		List<Prova> provas = Prova.find.all();
		return ok(listarprovas.render(provaForm, provas));
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
			return ok(formprovaquestao.render(p, form, questaoForm));
		}
	}

	public static Result atualizarAction(Long id) {
		Form<Prova> form = provaForm.bindFromRequest(request());

		Prova p = Prova.find.byId(id);

		if (!form.hasErrors()) {
			form.get().update(id);

			return redirect(routes.ProvaController.listar());
		} else {
			return badRequest(formprovaquestao
					.render(p, provaForm, questaoForm));
		}
	}

	public static Result excluir(Long id) {
		Prova p = Prova.find.byId(id);
		if (p != null) {
			p.delete();
		}
		return redirect(routes.ProvaController.listar());
	}

	public static Result excluirQuestao(Long id) {
		Questao q = Questao.find.byId(id);
		User u = q.getProva().getAuthor();

		if (u.getHash().equals(session("email"))) {
			return ok(index.render("Restrição Tecnica", "Restrição Tecnica",
					"Usuario sem permissão"));
		} else {

			if (q != null) {
				q.delete();
			}
			System.out.println("o que?");
			return redirect(routes.ProvaController.editar(q.getProva().getId()));

		}
	}

	public static Result adicionarAluno(String email) {
		return TODO;
	}

	public static Result excluirAluno(String email) {
		return TODO;
	}
}
