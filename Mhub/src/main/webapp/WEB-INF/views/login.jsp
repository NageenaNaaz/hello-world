<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/head.jsp" %>

<form:form action="logincheck" method="post" class="form-horizontal"><br>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">UserName</label>  
  <div class="col-md-2">
  <input id="textinput" name="username" type="text" placeholder="Enter your Name" class="form-control input-md">
  <span class="help-block">Ex:Naaz</span>  
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-2">
    <input id="passwordinput" name="pwd" type="password" placeholder="" class="form-control input-md">
    <span class="help-block">Ex:a-z ,1-10,!-*</span>
  </div>
</div>	

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button1id"></label>
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success"type="submit" value="login">Submit</button>
    	 <!--<button id="button2id" name="button2id" class="btn btn-danger">register</button>
    	 <button id="singlebutton" name="singlebutton" class="btn btn-danger">Reset</button>
  --> </div>
</div>
<!-- Button -->
<!-- <div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">New User</label>
  <div class="col-md-4">
  <a href="signup">
    <button id="singlebutton" name="singlebutton" class="btn btn-danger">Register</button>
  </a>
  </div>
</div> -->
<center>
	<h2>New User Signup Here</h2>
	<a href="signup">SignUp</a>
</center>
</form:form>

<%@ include file="/WEB-INF/views/footer.jsp" %>