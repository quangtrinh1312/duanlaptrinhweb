<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
       <link rel="stylesheet" href="./assets/cssLogin.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Đăng nhập</h3>
                    </div>
                    <div class="card-body">
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label for="username">Tên tài khoản</label>
                                <input type="text" name="username" id="username" class="form-control" placeholder="Nhập Tên tài khoản" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Mật khẩu</label>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Nhập mật khẩu" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
                                <h6 class="text-center" style="color:red;">${err}</h6>
                            </div>
                        </form>
                        <a href="signin.jsp" style="margin:0; align-items: center;">đăng kí</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>