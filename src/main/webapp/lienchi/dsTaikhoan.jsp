<%@page import="Model.Lop"%>
<%@page import="java.util.List"%>
<%@page import="DAO.LopDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="testcss.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.editLop').click(function(e) {
			var mssv = $(this).attr('href');
			var item = mssv.split("&");
			$("#idE").val(item[0])
			$("#nameE").val(item[1])
			$("#passE").val(item[2])
			e.preventDefault();
			 console.log($(this).attr('href')) 

		});
	});
</script>
<title>Document</title>
</head>
<body>
	<!-- header boostrap5-->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="LChiServlet">Quản lý tiền đoàn phí</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Features</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="logoutServlet">Đăng
								xuất</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- header boostrap5-->
	<!-- todo list admin boostrap5-->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active"
						aria-current="true">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">Danh sách</h5>
						</div>
					</a> <a href="LChiServlet"
						class="list-group-item list-group-item-action-highlight">Danh
						sách lớp</a> <a href="DstkServlet"
						class="list-group-item list-group-item-action-highlight">Danh
						sách tài khoản</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Danh sách tài khoản</h3>
						<a data-bs-toggle="modal" data-bs-target="#modalAdd"
							href="lienchi/form.jsp" class="btn btn-dark">Thêm Tài Khoản</a>
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>STT</th>
									<th>Mã Sinh Viên</th>
									<th>Username</th>
									<th>Password</th>
									<th>Lựa chọn</th>
								</tr>
							</thead>
							<%
							int a = 1;
							%>
							<tbody>
								<c:forEach items="${list}" var="o">
									<tr>
										<td><%=a%> <% a += 1;%></td>
										<td>${o.maSinhVien}</td>
										<td>${o.userName}</td>
										<td>${o.passWord}</td>

										<td style=" display: flex;   flex-direction: row;">
										<a data-bs-toggle="modal" data-bs-target="#modalEdit"
										href="${o.maSinhVien}&${o.userName}&${o.passWord}"
										class="btn btn-primary editLop">Sửa</a> 
										<form action="deleteDstkServlet" method="post">
										<input type="hidden" value="${o.maSinhVien }" name="id">
										<button type="submit" class="btn btn-danger del" >Xóa</button>
										</form></td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- todo list admin boostrap5-->
	<%
		LopDAO dao=new LopDAO();
	List<Lop>list=dao.getAll();
	%>
	<!-- Modal -->
	<div class="modal fade" id="modalAdd" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">THÊM TÀI KHOẢN</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="AddAccountServlet" method="post">
					<div class="modal-body">
					
						<div class="mb-3">
							<label>Username</label> <input required class="form-control" type="text"
								name="name">
						</div>
						<div class="mb-3">
							<label>Password</label> <input required class="form-control" type="password"
								name="pass">
						</div>
						<div class="mb-3">
							<label>Họ Tên</label> <input required class="form-control" type="text"
								name="hoten">
						</div>
					
						<div class="mb-3">
							<label>Ngày Sinh</label> <input class="form-control" type="date"
								name="date">
						</div>
						<div class="mb-3">
							<label>Lớp</label>
							<select name="maLop" class="form-control">
								<%
									for(int i=0;i<list.size();i++){
								%>
								<option value="<%=list.get(i).getMaLop() %>"><%=list.get(i).getTenLop() %></option>
								<%} %>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary addKi">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="modalEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sửa tài khoản</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="EditAccountServlet" method="post">
					<input type="hidden" id="idE" name="id">
					<div class="modal-body">
						<label>Username</label> <input id="nameE" class="form-control"
							type="text" name="name">
					</div>
					<div class="modal-body">
						<label>Password</label> <input id="passE" class="form-control"
							type="text" name="password">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary addKi">Edit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>