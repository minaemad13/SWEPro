package com.swe.dao;

import com.swe.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class RegisterDao 
{
    public String authorizeRegister(User registerBean) //create authorizeRegister()function
    {
        String username=registerBean.getusername();
        String password=registerBean.getpassword();
        String email=registerBean.getemail();  //get all value through User object and store in temporary variable
        
        
        String url="jdbc:mysql://localhost:3306/online_store";
        		//"jdbc:sqlserver://localhost\\SQLEXPRESS2019;databaseName=online_store;integratedSecurity=true";
        		
        		//"jdbc:sqlserver://localhost:1433;databaseName=online_store;user=DESKTOP-JI9OJHG\\SQLEXPRESS2019;integratedsecurity=true";
        	
        	
        	
        		
       //localhost;integratedSecurity=true;
        //database connection url string
        String uname="root"; //database username
        String pass=""; //database password
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           //("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
         
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            System.out.print("ddddddd");
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("insert into Users(username,password,email) values(?,?,?)"); //sql insert query
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.executeUpdate(); //execute query
             
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
            return "SUCCESS REGISTER"; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL REGISTER"; //if invalid return string "FAIL REGISTER"
    }
}