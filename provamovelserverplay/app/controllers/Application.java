package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Home","Seja bem vindo ao sistema.","Para cadastar suas provas se cadastre no menu superior"));
    }

}
