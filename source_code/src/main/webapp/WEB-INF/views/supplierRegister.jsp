<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Thêm Nhà Cung Cấp</title>

<!-- Custom fonts for this template-->
<link
	href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.css" />"
	rel="stylesheet" type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:url value="/resources/css/sb-admin-2.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main/supplierRegister.css" />"
	rel="stylesheet" type="text/css">
</head>

<body class="bg-customizer">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-img"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Thêm Nhà Cung Cấp!</h1>
							</div>
							<form class="supplier windsora-validation" method="post" name = "windsora-validation" novalidate>
								<div class="form-group row">
									<div class="col-sm mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-supplier"
											id="name" placeholder="Họ và tên" required>
										<div class="invalid-feedback">Vui lòng nhập họ và tên</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-supplier"
											id="address" placeholder="Địa chỉ" required>
										<div class="invalid-feedback">Vui lòng nhập địa chỉ</div>

									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text"
											class="form-control form-control-supplier" id="phone"
											placeholder="Số điện thoại" required>
										<div class="invalid-feedback">Vui lòng nhập số điện thoại</div>

									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="email" class="form-control form-control-supplier"
											id="email" placeholder="Emailỉ" required>
										<div class="invalid-feedback">Vui lòng nhập Email</div>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-supplier"
											id="moreinfo" placeholder="Thông tin khác">
									</div>
								</div>
								  <a id = "addNewSupplier" class="btn btn-supplier btn-block"> Thêm Nhà Cung Cấp </a>
								
								<hr>
								<a href="back" class="btn btn-google btn-supplier btn-block">
									<i class="fa fa-address-card fa-fw "></i> Quay trở về trang nhà cung cấp

								</a> <a href="home"
									class="btn btn-facebook btn-supplier btn-block"> <i
									class="fa fa-home fa-fw"></i> Quay trở về trang chủ

								</a>
							</form>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"
		type="text/javascript"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value= "/resources/vendor/jquery-easing/jquery.easing.min.js" />"
		type="text/javascript"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value= "/resources/js/sb-admin-2.min.js" />"
		type="text/javascript"></script>
	<!-- Page level custom scripts -->
	<script src="<c:url value="/resources/js/main/supplierRegister.js" />"
		type="text/javascript"></script>
		
			<!-- Sweet Alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>

</html>
