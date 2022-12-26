<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="testcss.css">
    <title>Document</title>
</head>
<body>
    <!-- header boostrap5-->
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Quản lý tiền đoàn phí</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="../login.jsp">đăng xuất</a>
                  </li>
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
                    <a href="#" class="list-group-item list-group-item-action active" aria-current="true">
                      <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">Danh sách</h5>
                        </div>
                    </a>
                    <a href="DssvServlet?param=true" class="list-group-item list-group-item-action">Danh sách đoàn viên</a>
                    <a href="danhSachDoanVienNopTien.jsp" class="list-group-item list-group-item-action">Danh sách đoàn viên nộp tiền</a>
                    <a href="danhSachDoanVienNopTien.jsp" class="list-group-item list-group-item-action-highlight">Danh sách đoàn viên chưa nộp tiền</a>
                </div>
            </div>
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Danh sách đoàn viên</h3>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>MSSV</th>
                                    <th>Họ và tên</th>
                                    <th>Ngày sinh</th>
                                    <th>Giới tính</th>
                                    <th>Địa chỉ</th>
                                    <th>Số điện thoại</th>
                                    <th>Chức vụ</th>
                                    <th>Đoàn phí</th>
                                    <th>Thao tác</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>123456</td>
                                    <td>Nguyễn Thái Học</td>
                                    <td>01/01/2000</td>
                                    <td>Nam</td>
                                    <td>Đà Nẵng</td>
                                    <td>0123456789</td>
                                    <td>Trưởng đoàn</td>
                                    <td>Chưa nộp</td>
                                    <td>
                                        <a href="#" class="btn btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>123457</td>
                                    <td>Dương Quốc Việt</td>
                                    <td>28/09/2002</td>
                                    <td>Nam</td>
                                    <td>Đà Nẵng</td>
                                    <td>0123456789</td>
                                    <td>Trưởng đoàn</td>
                                    <td>Chưa nộp</td>
                                    <td>
                                        <a href="#" class="btn btn-primary">Sửa</a>
                                        <a href="#" class="btn btn-danger">Xóa</a>
                                    </td>
                                </tr>
                            </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- todo list admin boostrap5-->
    

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>