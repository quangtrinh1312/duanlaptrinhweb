<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<style>
.mb-3{
	width:50%;
}
body{
	margin:0 0 0 0;
	background-color: #ccc;
	color:black;
}
form{

	display:flex;
	align-items:center;
	justify-content: center;
	flex-direction: column;
}
.container{
	margin-top:25vh;
}
</style>
<body>
	<div class="container">
		<!--<form action="../AddDoanVienServlet" method="post"> 
		<form action="/cuoiKiTKLTWeb/AddDoanVienServlet" method="post"> -->
		<form action="AddDoanVienServlet" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Họ tên:
					</label> <input name="hoTen" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Ngày Sinh:
					</label> <input name="ngaySinh" type="date" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" required>
			</div>
			<button type="submit" class="btn btn-primary">Xác Nhận</button>
		</form>
	</div>
</body>
</html>