package com.mypack.mypack.services;

import com.mypack.mypack.dao.daoImplementation;
import com.mypack.mypack.entities.Admin;
import com.mypack.mypack.entities.Client;
import com.mypack.mypack.entities.Driver;
import com.mypack.mypack.entities.Manager;
import com.mypack.mypack.utilityClassees.SessionUtil;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

public class AuthentificationService {



    public boolean login(String email,String password){

        //Identify the actor to login
        String actorString = email.split("@")[1];
        if(actorString.equals("admin.com")){
            //Create the query
            String query = "SELECT a from Admin a where a.email=:email and a.password=:password";
            //Set the parameters
            HashMap<String,Object> map_of_parameters = new HashMap<>();
            map_of_parameters.put("email",email);
            map_of_parameters.put("password",password);
            //Search in the table
            List<Admin> admin = new daoImplementation().query(Admin.class,query,map_of_parameters);
            if(admin.size() > 0){
                //Set the sessions
                HttpSession session = SessionUtil.getSession();
                session.setAttribute("user", "admin");
                session.setAttribute("id",admin.get(0).getId());

                return true;
            }else {
                return false;
            }
        }else if(actorString.equals("manager.com")){
            //Create the query
            String query = "SELECT a from Manager a where a.email=:email and a.password=:password";
            //Set the parameters
            HashMap<String,Object> map_of_parameters = new HashMap<>();
            map_of_parameters.put("email",email);
            map_of_parameters.put("password",password);
            //Search in the table
            List<Manager> manager = new daoImplementation().query(Manager.class,query,map_of_parameters);
            if(manager.size() > 0){
                //Set the sessions
                HttpSession session = SessionUtil.getSession();
                session.setAttribute("user", "manager");
                session.setAttribute("id",manager.get(0).getId());
                return true;
            }else {
                return false;
            }
        } else if (actorString.equals("driver.com")) {
            //Create the query
            String query = "SELECT a from Driver a where a.email=:email and a.password=:password";
            //Set the parameters
            HashMap<String,Object> map_of_parameters = new HashMap<>();
            map_of_parameters.put("email",email);
            map_of_parameters.put("password",password);
            //Search in the table
            List<Driver> driver = new daoImplementation().query(Driver.class,query,map_of_parameters);
            if(driver.size() > 0){
                //Set the sessions
                HttpSession session = SessionUtil.getSession();
                session.setAttribute("user", "manager");
                session.setAttribute("id",driver.get(0).getId());
                return true;
            }else {
                return false;
            }
        }else {
            //Create the query
            String query = "SELECT a from Client a where a.email=:email and a.password=:password";
            //Set the parameters
            HashMap<String,Object> map_of_parameters = new HashMap<>();
            map_of_parameters.put("email",email);
            map_of_parameters.put("password",password);
            //Search in the table
            List<Client> client = new daoImplementation().query(Client.class,query,map_of_parameters);
            if(client.size() > 0){
                //Set the sessions
                HttpSession session = SessionUtil.getSession();
                session.setAttribute("user", "client");
                session.setAttribute("id",client.get(0).getId());
                return true;
            }else {
                return false;
            }

        }


    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return "login";
    }
}

