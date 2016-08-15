<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/head.jsp" %>
<body>

<form:form method="POST" action="./updatecategory" class="form-horizontal">
<div class="form-group">
			<label class="col-md-4 control-label" for="CategoryId">CategoryId</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="CategoryId"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="CategoryName">CategoryName</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="CategoryName"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="ProductId">ProductId</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="ProductId"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="ProductName">ProductName</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="ProductName"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton" class="btn btn-danger"
					type="submit" value="Enter">AddCategory</button>
			</div>
		</div>

	</form:form>

<%@ include file="/WEB-INF/views/footer.jsp" %>