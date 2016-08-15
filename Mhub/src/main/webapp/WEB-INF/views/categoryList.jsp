
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
 <title>Users List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  
  <!-- <link href=”resources/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
<script type=”text/javascript” src=”resources/js/bootstrap.min.js”></script>
<script src="<c:url value="/resources/angular-1.5.5/angular.min.js"/>" ></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mystyle.css"/>">-->
</head>
<%@ include file="/WEB-INF/views/adminheader.jsp"%>
<body>
  <div>

<h2><p style="float:left;">List Of Users!</p></h2>
    	
 <p style="text-align: justify;">
  		<div ng-app="myApp" ng-controller="namesCtrl">
	<form>
		<input type="text" ng-model="search">&nbsp&nbsp
		<span class="glyphicon glyphicon-search"></span>
		
	</form>
	<table class="table table-striped">
	<tr>		
		<th>CategoryId</th>
		<th>CategoryName</th>
		<th>ProductId</th>
		<th>ProductName</th>
		
	</tr>
	<tr ng-repeat="resource in names | filter:search">		
		<td>{{ resource.CategoryId}}</td>
		<td>{{ resource.CategoryName}}</td>
		<td>{{ resource.ProductId }}</td>
		<td>{{ resource.ProductName}}</td>
		 <td align="center">
		<a href="edit1/{{resource.CategoryId}}">Edit</a> | <a href="delete1/{{resource.CategoryId}}">Delete</a></td>
   	</tr>
	</table>    
	<script>
	angular.module('myApp', []).controller('namesCtrl', function($scope) {
    $scope.names = ${data};
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
	});
	</script>
	</div>
  	</p>
	
</div>
</div>

<%@ include file="/WEB-INF/views/footer.jsp" %>