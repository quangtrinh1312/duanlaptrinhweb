<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" >
</head>
<style>
.mb-3 {
	width: 50%;
}

body {
	margin: 0 0 0 0;
	background-color: #ccc;
	color: black;
}

form {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}
.mb-3{
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}
.container {
	margin-top: 25vh;
}
option{
	width:30vw;
	heigh:30vh;
}
</style>
<body>
	<div class="container">
		<!--<form action="../AddDoanVienServlet" method="post"> 
		<form action="/cuoiKiTKLTWeb/AddDoanVienServlet" method="post"> -->
		<form action="AddKiServlet" method="post">
			<div class="mb-3">
				<select name="ki" id="cars" multiple>
					<c:forEach items="${list }" var="o">
						<option value="${o}" >Kì: ${o}</option>
					</c:forEach>	 
				</select>
				<input name="msv" style="display:none" value="<%= request.getParameter("msv") %>"/>
			</div>

			<button type="submit" class="btn btn-primary">Xác Nhận</button>
		</form>
	</div>
</body>
</html>