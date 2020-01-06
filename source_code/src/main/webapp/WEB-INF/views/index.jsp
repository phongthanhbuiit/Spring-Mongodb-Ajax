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

<title>Drashborad</title>

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

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<li><a
				class="home sidebar-brand d-flex align-items-center justify-content-center"
				href="#"> <span class="sidebar-brand-icon rotate-n-15"> <i
						class="fas fa-warehouse"></i>
				</span> <span class="sidebar-brand-text mx-3">Warehouse</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="home nav-link" href="#">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>BẢNG ĐIỀU
						KHIỂN</span>
			</a></li>
			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseInputInfo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-file-import"> </i> <span>QUẢN LÝ NHẬP HÀNG</span>
			</a>
				<div id="collapseInputInfo" class="collapse"
					aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a href="inputInfo" id="linkInputInfo" class="collapse-item"><i
							class="fas fa-download pr-2"></i> Nhập kho</a> <a id="linkProduct"
							class="collapse-item" href="product"><i class="fab fa-product-hunt pr-2"></i>
							Sản phẩm</a> <a id="linkMeasure" class="collapse-item" href="measure"> <i
							class="fas fa-box-open pr-2"></i> Đơn vị đo lường
						</a>
					</div>
				</div></li>
			<!-- Divider -->
			<hr class="sidebar-divider">
			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePR"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-ad"></i> <span>QUẢN LÝ PR</span>
			</a>
				<div id="collapsePR" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a href="customer" id="linkCustomer" class="collapse-item"> <i
							class="fas fa-address-card pr-2"></i> Khách Hàng
						</a> <a href="supplier" id="linkSuppliver" class="collapse-item"> <i
							class="fas fa-id-card-alt pr-2"></i> Nhà cung cấp
						</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseOutputInfo"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-truck-moving"></i> <span>QUẢN LÝ XUẤT HÀNG</span>
			</a>
				<div id="collapseOutputInfo" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a href="outputInfo" id="linkOutput" class="collapse-item"><i
							class="fas fa-truck-loading pr-2"> </i> Xuất Kho</a> <a
							href=inventory id="linkInventory" class="collapse-item"><i
							class="fas fa-database pr-2"></i> Xem Hàng Tồn Kho</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>



		<!-- Begin Page Content -->
		<div class="container-fluid mt-5">

			<!-- Content Row -->
			<div class="row">

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-info shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">

									 <a href="inputInfo"> <button 
										class="btn fill-button btn-block btn-info"> NHẬP KHO </button> </a>

								</div>
								<div class="col-auto">
									<i class="fas fa-download fa-2x text-info"> </i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-info shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">
								 <a href="product">
									<button 
										class="btn fill-button btn-block btn-info">SẢN PHẨM</button>
										</a>
								</div>
								<div class="col-auto">
									<i class="fab fa-product-hunt fa-2x text-info"></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-info shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">
								<a href="measure">
									<button 
										class="btn fill-button btn-block btn-info">ĐƠN VỊ ĐO LƯỜNG</button> </a>
								</div>
								<div class="col-auto">
									<i class="fas fa-box-open fa-2x text-info"></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Pending Requests Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-dark shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">
								<a href="#">
									<button class="btn fill-button btn-block btn-dark">TẠO TÀI KHOẢN</button>  </a>
								</div>
								<div class="col-auto">
									<i class="fas fa-user fa-2x text-dark"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
						<!-- Content Row -->
			<div class="row">

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-success shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">

									 <a href="customer"> <button 
										class="btn fill-button btn-block btn-success">  KHÁCH HÀNG </button> </a>

								</div>
								<div class="col-auto">
									<i class="fas fa-address-card fa-2x text-success"> </i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-success border-right-danger shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">
								 <a href="supplier">
									<button 
										class="btn fill-button btn-block btn-success">NHÀ CUNG CẤP</button>
										</a>
								</div>
								<div class="col-auto">
									<i class="fas fa-id-card-alt fa-2x text-success"></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Earnings (Monthly) Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-danger shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">
								<a href="outputInfo">
									<button 
										class="btn fill-button btn-block btn-danger">XUẤT KHO</button> </a>
								</div>
								<div class="col-auto">
									<i class="fas fa-truck-moving fa-2x text-danger"></i>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Pending Requests Card Example -->
				<div class="col-xl-3 col-md-6 mb-4">
					<div class="card border-left-danger shadow h-100 py-4">
						<div class="card-body">
							<div class="row  align-items-center">
								<div class="col ">
								<a href="inventory">
									<button class="btn fill-button btn-block btn-danger">XEM HÀNG TỒN KHO</button>  </a>
								</div>
								<div class="col-auto">
									<i class="fas fa-database fa-2x text-danger"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		<div class="container-fluid mt-4">
			<div id="chartContainer" class="card shadow mb-4 mt-4"
				style="height: 400px; width: 100%;"></div>
		</div>
			<div class="container-fluid mt-4">
				<div id="chartContainerPie" class="card shadow mb-4 mt-4"
					style="height: 600px; width: 100%;"></div>
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
			src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />"
			type="text/javascript"></script>

		<!-- Custom scripts for all pages-->
		<script src="<c:url value= "/resources/js/sb-admin-2.min.js" />"
			type="text/javascript"></script>

		<!-- Page level plugins -->
		<script
			src="<c:url value= "/resources/vendor/chart.js/Chart.min.js" />"
			type="text/javascript"></script>

		<!-- Page level custom scripts -->
		<script src="<c:url value="/resources/js/demo/chart-area-demo.js" />"
			type="text/javascript"></script>
			
			<!-- Page level custom scripts -->
		<script src="<c:url value="/resources/js/main/index.js" />"
		type="text/javascript"></script>	
			
		<script src="<c:url value="/resources/js/demo/chart-pie-demo.js" />"
			type="text/javascript"></script>
		<!-- Canvasjs Chart -->
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>

</html>
