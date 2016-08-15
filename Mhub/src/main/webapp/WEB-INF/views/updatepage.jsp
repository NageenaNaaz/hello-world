<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/adminheader.jsp" %>
<body>

<form:form method="POST" action="./updateproduct" class="form-horizontal">
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
		<div class="form-group">
			<label class="col-md-4 control-label" for="Description">Description</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="Description"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="Quantity">Quantity</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="Quantity"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="Price">Price</label>
			<div class="col-md-2">
				<input type="text" class="form-control" name="Price"
					placeholder="Enter ProductId" required /> <span class="help-block">Ex:1-100</span>
			</div>
		</div>
		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton" class="btn btn-danger"
					type="submit" value="Enter">AddProduct</button>
			</div>
		</div>

	</form:form>


<%@ include file="/WEB-INF/views/footer.jsp" %>