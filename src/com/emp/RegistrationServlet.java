package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

public class RegistrationServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		try {
			
			String name  = req.getParameter("name");
			String email  = req.getParameter("email");
			String phone  = req.getParameter("phone");
			String password  = req.getParameter("password");
			
			Connection conn = ApplicationDataSource.getConnection();
			java.sql.PreparedStatement ps =  conn.prepareStatement("insert into employee(name,email,phone,password) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, password);
			int id =ps.executeUpdate();
			if(id==1){
				HttpSession session=req.getSession();  
				session.setAttribute("name",name);
				session.setAttribute("id",id);
				req.setAttribute("name", name);
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}else{
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
			}
			
			//System.out.println(req.getParameter("name"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private RequestDispatcher RequestDispatcher(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
