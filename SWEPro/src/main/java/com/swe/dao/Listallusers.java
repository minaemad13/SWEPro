package com.swe.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.swe.models.User;

public class Listallusers
{
	public String[] listallusers(){
		 String username,email;
		 int count=0;
		 String[]result={};
        String url="jdbc:mysql://localhost:3306/online_store"; //database connection url string
        String uname="root"; //database username
        String pass=""; //database password
        try
        {
        	 Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            pstmt=con.prepareStatement("select username,email from users);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {    
                username=rs.getString("username");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
                email=rs.getString("password"); 
                result[count]=username;
                result[count+1]=email;
                count+=2;
            } 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
	}
}
