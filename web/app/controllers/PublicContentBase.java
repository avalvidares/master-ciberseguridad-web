package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

   public static void processRegister(String username, String password, String passwordCheck, String type){
        User u = User.loadUser(username);
        if (u!=null) {
            flash.put("error", Messages.get("Public.login.error.credentials"));
            register();
        }
        else {
	        u = new User(username, HashUtils.getMd5(password), type, -1);
	        u.save();
	        registerComplete();
        }
    }

    public static void registerComplete(){
        render();
    }
}
