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

<title>Thêm Thông Tin Phiếu Xuất</title>

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
<link
	href="<c:url value="/resources/css/main/outputInfoRegister.css" />"
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
								<h1 class="h4 text-gray-900 mb-4">Thêm Thông Tin Phiếu
									Xuất!</h1>
							</div>
							<form class="outputInfo windsora-validation" method="post"
								name="windsora-validation" novalidate>
								<div class="formInput">
								<div class = "input0">
				
								<div class="form-group row">
										<label class=label> Hàng Đã Nhập: </label>
										<div class="col-sm-12 mb-3 mb-sm-0">
											<select class="form-control form-control-lg OptionSelectProduct"
												id="OptionSelectProduct0">
											</select>
										</div>
									</div>

									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<label class=label> Số Kí: </label> <input type="number"
												step=0.1 class="form-control form-control-outputInfo"
												id="count0" placeholder="Số Kí (kilogram)" required>
											<div class="invalid-feedback">Vui lòng nhập số lượng (Số Kí)</div>
										</div>
										<div class="col-sm-6 mb-3 mb-sm-0">
											<label class=label> Số Lượng: </label> <input type="number"
												class="form-control form-control-outputInfo" id="qty0"
												placeholder="Số lượng" required>
											<div class="invalid-feedback">Vui lòng nhập số Lượng</div>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<label class=label> Số tiền bán (1KG): </label> <input
												type="number" step=any
												class="form-control form-control-outputInfo"
												id="outputPrice0" placeholder=" Số tiền bán"
												oninput="sumPrice(this.value, 0)"
												onchange="sumPrice(this.value, 0)" required>
											<div class="invalid-feedback">Vui lòng nhập Số tiền bán</div>
										</div>
										<div class="col-sm-6 mb-3 mb-sm-0">
											<label class=label> Tổng số tiền: </label> <input type="text"
												class="form-control form-control-outputInfo" id="sumoutput0"
												placeholder="Thành tiền" readonly>
										</div>
									</div>
								</div> 
		
							</div>
							<div class="form-group row">
										<label class=label> Khách Hàng: </label>
										<div class="col-sm-12 mb-3 mb-sm-0">
											<select class="form-control form-control-lg OptionSelectCustomer"
												id=OptionSelectCustomer>
											</select>
										</div>
							</div>
								<a id="addNewOutputInfo" class="btn btn-outputInfo btn-block">
									Thêm Thông Tin Phiếu Xuất </a>

							</form>

							<hr>
							<a class="btn btn-outputInfo btn-block btn-addmore">
										Thêm Hàng Hoá Khác </a>
							<a href="back" class="btn btn-google btn-outputInfo btn-block">
								<i class="fa fa-address-card fa-fw "></i> Quay trở về trang
								thông Tin Phiếu Xuất

							</a> <a href="home" class="btn btn-facebook btn-outputInfo btn-block">
								<i class="fa fa-home fa-fw"></i> Quay trở về trang chủ

							</a>
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
	<script
		src="<c:url value="/resources/js/main/outputInfoRegister.js" />"
		type="text/javascript"></script>

	<!-- Sweet Alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>

</html>
