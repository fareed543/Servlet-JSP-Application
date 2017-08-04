package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		Connection con;
		try {
			con = ApplicationDataSource.getConnection();
			java.sql.PreparedStatement ps = con.prepareStatement("select * from employee where email=? AND password=?");
			ps.setString(1, req.getParameter("email"));
			ps.setString(2, req.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			
			if (!rs.isBeforeFirst() ) {    
			    System.out.println("No data"); 
			    RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
			}else{
				rs.next();
				
				//System.out.println(rs);	
				//req.setAttribute("name", rs.getString(2));
				//if(rs != null){
					//System.out.println(rs);	
					
					HttpSession session=req.getSession();  
					session.setAttribute("name",rs.getString(2));
					session.setAttribute("id",rs.getInt(1));
					RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					rd.forward(req, resp);
				//}	
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
