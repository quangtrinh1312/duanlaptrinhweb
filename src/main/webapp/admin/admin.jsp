<%@page import="DAO.DanhSachSinhVienDAO"%>
<%@page import="Model.Account"%>
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
		$('.xemki').click(function(e) {
			var mssv = $(this).attr('href');
			document.querySelector('.addKi').href = "AddKiServlet?msv=" + mssv;
			console.log(mssv)
			e.preventDefault();
			/* console.log($(this).attr('href')) */
			$.ajax({
				url : 'KiServlet',
				type : 'GET',
				dataType : 'html',
				data : {
					msv : $(this).attr('href'),
				}
			}).done(function(ketqua) {
				$(".tbodyKi").html(ketqua);
				/* console.log(ketqua); */
			});

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
				<a class="navbar-brand" href="#">Quản lý tiền đoàn phí</a>
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
					</a> <a href="#"
						class="list-group-item list-group-item-action-highlight">Danh
						sách đoàn viên</a>
						<%
						Account acc = (Account) request.getSession().getAttribute("account");
						if(acc.getRole()==1){
						%>
						<a href="LChiServlet"
						class="list-group-item list-group-item-action-highlight">Danh
						sách lớp</a>
						<%} %>
				</div>
			</div>
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<%
						String idLop = (String) request.getAttribute("idLop");
						if (idLop == null) {
							Account account = (Account) request.getSession().getAttribute("account");
							DanhSachSinhVienDAO dao = new DanhSachSinhVienDAO();
							idLop = String.valueOf(dao.getMaLopByMaSinhVien(account.getMaSinhVien()));
						}
						%>
						<h3 class="card-title">Danh sách đoàn viên</h3>
						<a href="admin/form.jsp?idLop=<%=idLop%>" class="btn btn-dark">Thêm
							đoàn viên+</a>  
					</div>
					<div class="card-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>STT</th>
									<th>MSSV</th>
									<th>Họ và tên</th>
									<th>Ngày sinh</th>
									<th>Kì</th>
									<th>Lựa chọn</th>
								</tr>
							</thead>
							<%
							int a = 1;
							%>
							<tbody>
								<c:forEach items="${list}" var="o">
									<tr>
										<td><%=a%> <%a += 1;%></td>
										<td>${o.maSinhVien}</td>
										<td>${o.hoTen}</td>
										<td>${o.ngaySinh}</td>
										<td><a data-bs-toggle="modal" data-bs-target="#modalki"
											href="${o.maSinhVien}" class="btn btn-primary xemki">Kì
												nộp</a></td>
										<td><a href="updateServlet?id=${o.maSinhVien}"
											class="btn btn-primary ">Sửa</a> <a
											href="DeleteDssv?id=${o.maSinhVien}&idLop=<%=idLop %>"
											class="btn btn-danger del">Xóa</a></td>
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


	<!-- Modal -->
	<div class="modal fade" id="modalki" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">KÌ NỘP</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Kì</th>
								<th>Giá</th>
							</tr>
						</thead>
						<tbody class="tbodyKi">

						</tbody>

					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<a href="AddKiServlet?msv=" class="btn btn-primary addKi">ADD</a>
				</div>
			</div>
		</div>
	</div>

	<script>
		var del = document.querySelector(".del");
		var msv = $
		{
			sessionScope.account.maSinhVien
		};
		console.log(msv);
		del.onclick = function(e) {
			var i = del.getAttribute("href").indexOf("=");
			var id = del.getAttribute("href").substr(i + 1);
			if (msv == id) {
				alert('you cantnot delete yourself');
				e.preventDefault();
			}
		};
	</script>
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