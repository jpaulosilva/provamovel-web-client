package controllers;

import java.util.Date;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cadastrar;
import views.html.entrar;

public class UserController extends Controller {
	static Form<User> userForm = new Form(User.class);

	public static Result entrar() {
		return ok(entrar.render(userForm));
	}
	
	public static Result entrarAction() {
		Form<User> form = userForm.bindFromRequest(request());
		if (!form.hasErrors()) {
			User userLogin = form.get();
			User busca = User.find.byId(userLogin.getEmail());
			if(busca == null){
				return badRequest(entrar.render(form));
			}else{
				if(!busca.getPassword().equals(userLogin.getPassword())){
					return badRequest(entrar.render(form));	
				}else{
					Date d = new Date();
					userLogin.setHash("1234567abc"+d.toString().replace(" ", "")+"defghij89321");
					userLogin.update();
					
					session("login",userLogin.getEmail());
					session("hash",userLogin.getHash());
					
					return redirect(routes.Application.index());
				}
			}
				
		} else {
			return badRequest(cadastrar.render(form));
		}
	}

	public static Result cadastrarAction() {

        Form<User> form = userForm.bindFromRequest(request());
        if (!form.hasErrors()) {
                form.get().save();
                return redirect(routes.UserController.entrar());
        } else {
                return badRequest(cadastrar.render(form));
        }

	}

	public static Result cadastrar() {
		return ok(cadastrar.render(userForm));

	}

	public static Result sair() {
		
		 session().clear();
		
		return redirect(routes.Application.index());
	}
}
