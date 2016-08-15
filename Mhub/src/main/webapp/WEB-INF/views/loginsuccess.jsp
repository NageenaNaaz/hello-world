<%@ include file="/WEB-INF/views/head.jsp" %>
<body>
Welcome............<%=session.getAttribute("UNAME") %>
Login success
<br>
<br>
<a href="login">Login Page</a>

<br>
<br>
<br>
<br>
	<li><a href="viewproduct">View Product List</a></li>
	<li><a href="viewsupplier">View Supplier List</a></li>
	<li><a href="viewcategory">View Category List</a></li>
	<p><a href="../j_spring_security_logout">Logout</a>
<%@ include file="/WEB-INF/views/footer.jsp" %>