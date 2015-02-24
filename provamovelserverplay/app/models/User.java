package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
public class User extends Model{
@Id
@Email
String email;

@Required
String password;
String hash;

public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getHash() {
	return hash;
}
public void setHash(String hash) {
	this.hash = hash;
}


}
