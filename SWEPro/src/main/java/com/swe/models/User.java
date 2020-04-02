package com.swe.models;

public class User {

    public String Username ;
    public String password;
  
    public String email;
    
public User() {
    	
    	
    }
    
    public User(String Username, String password,String email) {
    	
    	this.Username=Username;
    	this.password=password;
    	this.email=email;
    	
    }
    
    public void setusername(String Username) {
    	this.Username=Username;
    }
    public  String getusername () {
    	return Username;
    }
    public void setpassword(String password) {
    	this.password=password;
    }
    public  String getpassword () {
    	return password;
    }
    public void setemail(String email) {
    	this.email=email;
    }
    public  String getemail () {
    	return email;
    }
}
