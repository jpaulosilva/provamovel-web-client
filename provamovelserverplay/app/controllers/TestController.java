package controllers;

import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class TestController extends Controller {
	static Form<User> userForm = new Form(User.class);

	public static Result calcula() {
		Form form = userForm.bindFromRequest(request());
		// redirect(routes.TestController.mostra(""));
		
		DynamicForm requestData = form.form().bindFromRequest();
        String value = requestData.get("value");
		return mostra(value);

	}

	public static Result mostra(String s) {
		return ok(test.render(s));

	}

}
