package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Prova;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class MobileController extends Controller{
	public static Result getProvas() {
		List<Prova> provas = Prova.find.all();
		List<String> provasString = new ArrayList<String>();
		for(Prova p :provas){
			provasString.add(p.getTitulo());
		}
		return ok(Json.toJson(provasString));
	}

	public static Result getProva(Long id) {
		Prova prova = Prova.find.byId(id);
		return ok(Json.toJson(prova));
	}
}
