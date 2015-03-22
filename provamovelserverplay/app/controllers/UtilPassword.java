package controllers;

import java.util.Date;

import models.User;

public class UtilPassword {
	public static String generateHash(User u){
		Date d = new Date();
		
		return "1234567abc"+d.toString().replace(" ", "")+"defghij89321";
	}
}
