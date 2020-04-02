package com.swe.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.swe.dao.LoginDao;
import com.swe.dao.RegisterDao;
import com.swe.models.User;


@Controller

public class UserController extends HttpServlet {

	
	@RequestMapping("/")
	
	public String reg() {
		return "index";
		
	}
   @RequestMapping("/signin")
	
	public String log() {
		return "login";
		
	}
	
	
	  @RequestMapping("/register")

	    protected @ResponseBody String regis(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	    {
	        
	        if(request.getParameter("submit")!=null) //check button click event not null from register.jsp page button
	        {
	            String username=request.getParameter("username");
	            String password=request.getParameter("password");
	            String email=request.getParameter("email");  //get all textbox name from register.jsp page
	           
	            
	            User registerBean=new User(); //this class contain  seeting up all received values from register.jsp page to setter and getter method for application require effectively
	            
	            registerBean.setusername(username);
	            registerBean.setpassword(password);
	            registerBean.setemail(email);  //set the all value through registerBean object
	            
	            RegisterDao registerdao=new RegisterDao(); //this class contain main logic to perform function calling and database operation
	            
	            String registerValidate=registerdao.authorizeRegister(registerBean); //send registerBean object values into authorizeRegister() function in RegisterDao class
	            
	            if(registerValidate.equals("SUCCESS REGISTER")) //check calling authorizeRegister() function receive "SUCCESS REGISTER" string message after redirect to index.jsp page
	            {
	               // request.setAttribute("RegiseterSuccessMsg",registerValidate); //apply register successfully message "RegiseterSuccessMsg"
	               //RequestDispatcher rd=request.getRequestDispatcher("suc.html"); //redirect to index.jsp page
	                //rd.forward(request, response);
	            	return "rugesterd";
	            }
	            else
	            {
	                /*request.setAttribute("RegisterErrorMsg",registerValidate); // apply register error message "RegiseterErrorMsg"
	                RequestDispatcher rd=request.getRequestDispatcher("index.html"); //show error same page register.jsp page
	                rd.include(request, response);*/
	            	return "fail";
	            }
	        }
			return "fail";
	  
	  
	    }
	  
	  
	  
	  
	  @RequestMapping("/login")

	    protected@ResponseBody String Logei(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	    {
	        if(request.getParameter("login")!=null) //check button click event not null from login.jsp page button
	        {
	            String username=request.getParameter("username"); //get textbox name "txt_username"
	            String password=request.getParameter("password"); //get textbox name "txt_password"
	            
	            User loginBean=new User(); //this class contain seeting up all received values from index.jsp page to setter and getter method for application require effectively 
	            
	            loginBean.setusername(username); //set username through loginBean object
	            loginBean.setpassword(password); //set password through loginBean object
	            
	            LoginDao loginDao=new LoginDao(); //this class contain main logic to perform function calling and database operation
	            
	            String authorize=loginDao.authorizeLogin(loginBean); //send loginBean object values into authorizeLogin() function in LoginDao class
	            
	            if(authorize.equals("SUCCESS LOGIN")) //check calling authorizeLogin() function receive string "SUCCESS LOGIN" message after continue process
	            {
	               /* HttpSession session=request.getSession(); //session is created
	                session.setAttribute("login",loginBean.getemail()); //session name is "login" and  store username in "getUsername()" get through loginBean object
	                RequestDispatcher rd=request.getRequestDispatcher("suc.html"); //redirect to welcome.jsp page
	                rd.forward(request, response);*/
	            	return"loged in";
	            }
	            else
	            {
	                /*request.setAttribute("WrongLoginMsg",authorize); //wrong login error message is "WrongLoginMsg"
	                RequestDispatcher rd=request.getRequestDispatcher("login.html"); //show error same index.jsp page
	                rd.include(request, response);*/
	            	return"fail";
	            }
	        }
	        return "fail";
	    }


        @RequestMapping("/List")
        public String[] listallusers() {
            String SQL = "select * from Student";
            String[] students = jdbcTemplateObject.query(SQL, new StudentMapper());
            return students;
        }

}
