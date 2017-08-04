package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

public class ProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		//get the Session Id
		HttpSession session=req.getSession();  
		String user =  (String) session.getAttribute("name");
		int id =  (int) session.getAttribute("id");
		/*
		 * session
		 * */
		
		Connection con;
		try {
			con = ApplicationDataSource.getConnection();
			java.sql.PreparedStatement ps =  con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(user.isEmpty()){
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);	
			}else{
				rs.next();
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				//System.out.println(rs.getString(3));
				req.setAttribute("email", rs.getString(3));
				req.setAttribute("phone", rs.getString(4));
				
				EmployeePOJO empPOJO = new EmployeePOJO();
				empPOJO.setId(rs.getInt(1));
				empPOJO.setName(rs.getString(2));
				empPOJO.setEmail(rs.getString(3));
				empPOJO.setPhone(rs.getString(4));
				req.setAttribute("emppojo", empPOJO);
				RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
