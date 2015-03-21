package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.ajax;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {
	static Form form = new Form(Object.class);

	public static Result index() {
		return ok(index.render("Home", "Seja bem vindo ao sistema.",
				"Para cadastar suas provas se cadastre no menu superior"));
	}

	public static Result debug(String s) {
		return ok(index.render("Home", "Seja bem vindo ao sistema.", s));
	}

	public static Result ajax() {

		/*
		 * if (!form.hasErrors()) {
		 * 
		 * DynamicForm requestData = form.form().bindFromRequest(); HashMap
		 * values = (HashMap) requestData.get().getData();
		 * 
		 * ObjectNode result = Json.newObject();
		 * 
		 * result.put("campos",(String)values.toString());
		 * 
		 * //result.put("exampleField2", "Hello world!");
		 * 
		 * return ok(result);
		 * 
		 * }
		 */
		
		JsonNode json = request().body().asJson();
		

			return ok(json.findValue("name").findValue("a"));
		
		//return ok(request().);
	}

	public static Result test() {

		return ok(ajax.render());

	}

}
