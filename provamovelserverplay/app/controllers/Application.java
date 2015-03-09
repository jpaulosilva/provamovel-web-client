package controllers;

import java.util.HashMap;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.ajax;
import views.html.index;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Application extends Controller {
	static Form form = new Form(Object.class);
    public static Result index() {
        return ok(index.render("Home","Seja bem vindo ao sistema.","Para cadastar suas provas se cadastre no menu superior"));
    }
    
    public static Result debug(String s) {
        return ok(index.render("Home","Seja bem vindo ao sistema.",s));
    }
    
    public static Result ajax() {
    	
    	if (!form.hasErrors()) {
    	
    		DynamicForm requestData = form.form().bindFromRequest();
			HashMap values = (HashMap) requestData.get().getData();
			
			ObjectNode result = Json.newObject();
			
			result.put("campos",(String)values.get("test"));
			
			/*result.put("exampleField2", "Hello world!");*/
			
    		return ok(result);
        	
    	}
    	return redirect(routes.Application.debug(form.errorsAsJson().asText()));
    	
    }
    
 public static Result test() {
    	
    	return ok(ajax.render());
    	
    }

}
