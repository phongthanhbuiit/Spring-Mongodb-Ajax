<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="vi">

<head>

<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Thông Tin Hàng Tồn Kho</title>


<!-- Custom fonts for this template -->
<link
	href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/sb-admin-2.min.css" />"
	rel="stylesheet">

<!-- Custom styles for this page -->
<link
	href="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/main/inventory.css" />"
	rel="stylesheet">

</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Begin Page Content -->
				<div class="container-fluid">
				<div id="chartContainer" class = "card shadow mb-4 mt-4" style="height: 370px; width: 100%;">
				</div>
					<!-- DataTales Example -->
					<div id="data-table" class="card shadow mb-4 ">
						<div class="my-4">
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="cusTable">
										<thead>
											<tr>
												<th>Tên Sản Phẩm</th>
												<th>Số Kí (KG)</th>
												<th>Số Lượng</th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
							<div class="col-sm my-4 filldiv">
							<div class="col-sm-6 mt-3 mb-3 mb-sm-0">
								<label class=label> Tổng toàn bộ số kí hàng tồn kho: </label> <input type="text"
									class="form-control form-control-inputInfo" id="sumKG"
									 readonly>
							</div>
							</div>
						</div>

					</div>
					<!-- /.container-fluid -->
				<div id="chartContainerPie" class = "card shadow mb-4 mt-4" style="height: 500px; width: 100%;">
				</div>
				<!-- End of Main Content -->
			</div>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
	</div>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>


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

	<!-- Page level plugins -->

	<script
		src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js" />"
		type="text/javascript"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value="/resources/js/main/inventory.js" />"
		type="text/javascript"></script>

	<!-- Canvasjs Chart -->
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

	<!-- Sweet Alert -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
</body>

</html>
