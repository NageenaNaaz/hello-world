<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/views/head.jsp" %>
<body>

<form:form method="POST" action="addcustomer" class="form-horizontal">

	<div class="form-group">
	  <label class="col-md-4 control-label" for="UserId">UserId</label>  
	  <div class="col-md-2">
	 	 <input type="text" class="form-control" name="UserId" placeholder="Enter UserId" required/>
	  <span class="help-block">Ex:1-100</span>  
	  </div>
	  
	</div>
	<div class="form-group">
	  <label class="col-md-4 control-label" for="EmailId">EmailId</label>  
	  <div class="col-md-2">
	 	 <input type="email" class="form-control" name="EmailId" placeholder="Enter EmailId" required/>
	  <span class="help-block">Ex:1-100</span>  
	  </div>
	</div>
     <div class="form-group">
	  <label class="col-md-4 control-label" for="UserName">UserName</label>  
	  <div class="col-md-2">
	 	 <input type="text" class="form-control" name="UserName" placeholder="Enter UserName" required/>
	  <span class="help-block">Ex:1-100</span>  
	  </div>
	</div>

    <div class="form-group">
	  <label class="col-md-4 control-label" for="Password">Password</label>  
	  <div class="col-md-2">
	 	 <input type="password" class="form-control" name="Password" placeholder="Enter Password" required/>
	  <span class="help-block">Ex:1-100</span>  
	  </div>
	</div>
	<!-- Button -->
	<div class="form-group">
  		<label class="col-md-4 control-label" for="singlebutton">ADD Users</label>
  			<div class="col-md-4">
    			<button id="singlebutton" name="singlebutton" class="btn btn-danger"value="login">Register</button>
  			</div>
	</div>
    <!-- <input type="submit" class="btn btn-lg btn-primary btn-block" value="Register"><br> -->
    
</form:form>

<%@ include file="/WEB-INF/views/footer.jsp" %>