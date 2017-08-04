<%@ include file = "header.jsp" %>
		<div class="main-w3layouts-agileinfo">
	           <!--form-stars-here-->
						<div class="wthree-form">
							<h2>Login Form</h2>
							<form action="loginServlet" method="post">
								<div class="form-sub-w3">
									<input type="text" name="email" placeholder="email " required="" />
								<div class="icon-w3">
									<i class="fa fa-user" aria-hidden="true"></i>
								</div>
								</div>
								<div class="form-sub-w3">
									<input type="password" name="password" placeholder="password" required="" />
								<div class="icon-w3">
									<i class="fa fa-unlock-alt" aria-hidden="true"></i>
								</div>
								</div>
								<label class="anim">
									<a href="register.jsp">Register</a>
								</label> 
								<div class="clear"></div>
								<div class="submit-agileits">
									<input type="submit" value="Login">
								</div>
							</form>

						</div>
				<!--//form-ends-here-->

		</div>
<%@ include file = "footer.jsp" %>