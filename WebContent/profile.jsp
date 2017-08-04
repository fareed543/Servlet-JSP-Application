<%@page import="com.emp.EmployeePOJO"%>
<%@ include file = "header.jsp" %>
		<div class="main-w3layouts-agileinfo">
	           <!--form-stars-here-->
						<div class="wthree-form">
							<h2>Welcome <%= session.getAttribute("name") %></h2>
							<h2>Email <%= request.getAttribute("email") %></h2>
							<h2>Phone <%= request.getAttribute("phone") %></h2>
							
							</div>				
		</div>
		<%
		//EmployeePOJO emppojo1 = new EmployeePOJO();
		//request.getAttribute(emppojo.getId());
		//out.print(request.getAttribute(emppojo.getId()));
		//Integer.parseInt(request.getParameter("someInteger"))
		
		%>
		<div class="main-w3layouts-agileinfo">
	           <!--form-stars-here-->
						<div class="wthree-form">
							<h2>Values with POJO </h2>
							<h2>Email 1</h2>
							<h2>Email 11</h2>
							</div>				
		</div>
<%@ include file = "footer.jsp" %>