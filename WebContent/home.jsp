<%@ include file = "header.jsp" %>
		<div class="main-w3layouts-agileinfo">
	           <!--form-stars-here-->
						<div class="wthree-form">
							<!-- <% String name = (String)request.getAttribute("name"); out.print(name);%>
							<h2>Welcome <% out.print(name);%></h2>-->						
							<h2>Welcome <%= session.getAttribute("name") %></h2>
							</div>				
		</div>
<%@ include file = "footer.jsp" %>