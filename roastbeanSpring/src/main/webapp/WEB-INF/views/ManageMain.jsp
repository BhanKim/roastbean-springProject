<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <!-- test -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

  <title>Manage Main</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
  <!-- hosik css -->
  <link href="css/hosikcss.css" rel="stylesheet">
  <!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->


</head>

<body>

	<!-- ======= Header ======= -->
	
	<!-- 22.11.19 Hosik - Can view manage_main.jsp just got Admin session -->
	<c:if test="${ADMIN == 'admin'}">
		<%@include file = "header_minnerpage.jsp" %>
	<!-- End Header -->

	<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
		 <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Manage Mode</h2>
          <ol>
            <li><a href="ManageMain">ManageMain</a></li>
            <li>Inner Page</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

		<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
		<section class="inner-page">
			<div class="container">
			<div align="center">
			
				  <div class="container">
				  		<div class="row">
					    <div class="col">
			
							<!-- <table style="margin-left: auto; margin-right: auto; border:none;" border="1"
									class="table table-sm table-hover">
									<thead >
									<tr>
										<td width="400" height="60" style="text-align: center; vertical-align:middle; color: #fff; background-color:#5f5f5f;" onClick="location.href='mpList'">PRODUCT LIST</td>	
										<td width="400" height="60" style="text-align: center; vertical-align:middle; color: #fff; background-color:#F2BCBB;" onClick="location.href='manage_chart.jsp'">CHART<br><준비중></td>
									</tr>
									<tr>
										<td width="400" height="60" style="text-align: center; vertical-align:middle; color: #fff; background-color:#5f5f5f;" onClick="location.href='OrderList'">ORDERS LIST</td>
										<td width="400" height="60" style="text-align: center; vertical-align:middle; color: #fff; background-color:#F2BCBB;" onClick="location.href='UserList'">USER LIST</td>
									</tr>
									<tr>
										<td width="400" height="60" style="text-align: center; vertical-align:middle; color: #fff; background-color:#5f5f5f;" onClick="location.href=' # ''">미 정</td>
										<td width="400" height="60" style="text-align: center; vertical-align:middle; color: #fff; background-color:#F2BCBB;" onClick="location.href='notice_list'">NOTICE</td>
									</tr>
								</thead>
							</table> -->
							<table style="margin-left: auto; margin-right: auto; border:none;" border="1"
									class="table table-sm table-hover">
									<thead >
									<tr>
										<td colspan="2" style="text-align: center; vertical-align:middle; "height="80">
											금일 총 판매금액  :<b> <fmt:formatNumber value="${order_date_sales }" pattern="#,###"/></b> 원<br>
										</td>
									</tr>
									<tr>
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											지난 1주일간 총  판매금액 :<b> <fmt:formatNumber value="${order_week_sales }" pattern="#,###"/></b> 원
											
										</td>
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											지난 1달간 총  판매금액 :<b> <fmt:formatNumber value="${monthly_statistics }" pattern="#,###"/></b> 원
										</td>
									</tr>	
									 <tr>
										<td width="400" height="100" style="text-align: center; vertical-align:middle; ">
											<b>금일 많이 팔린 상품</b> 
											<br>${order_date_order_quantity_NQP_N }
											<br>팔린 갯수 : ${order_date_order_quantity_NQP_Q } 개
											<br>판매금액 : <b><fmt:formatNumber value="${order_date_order_quantity_NQP_P }" pattern="#,###"/></b> 원
										</td>
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											<b>금일 높은 매출 상품</b>
											<br>${order_date_order_price_NQP_N }
											<br>팔린 갯수 : ${order_date_order_price_NQP_Q } 개
											<br>판매금액 : <b><fmt:formatNumber value="${order_date_order_price_NQP_P }" pattern="#,###"/></b> 원
										</td>	
									</tr>	
									<tr>
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											<b>1주일간 가장 많이 팔린 상품</b> 
											<br>판매 갯수 : ${week_order_product_order_quantity_NQP_N }
											<br>${week_order_product_order_quantity_NQP_Q  } 개
											<br><b><fmt:formatNumber value="${week_order_product_order_quantity_NQP_P }" pattern="#,###"/></b> 원
										</td>
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											<b>1주일간 가장 높은 매출 상픔</b> 
											<br>${week_order_product_order_price_NQP_N }
											<br>판매 갯수 : ${week_order_product_order_price_NQP_Q } 개
											<br><b><fmt:formatNumber value="${week_order_product_order_price_NQP_P }" pattern="#,###"/></b> 원
										</td>
									</tr>
									<tr>
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											금일 신규 회원 수 : ${count_new_users }
											<br>금일 신규 게시글 : ${today_sum_community }
										</td>
										<!--  -->
										<td width="300" height="100" style="text-align: center; vertical-align:middle; ">
											 금일 신규 Qna : ${todayNewQNA }
											 <br>답장을 기다리고 있는 Qna : ${totalQNA-doneanswerQNA}
										</td>
									</tr>
									<c:forEach items="${weekList}" var="dto">
									<tr>
										<td>${dto.order_date }</td>
										<td>판매량 : ${dto.order_qty }/ 매출금액 : ${dto.order_price }</td>
									</tr>
									</c:forEach>
									<tr>
										<td colspan="2">
											<table>	
												<c:forEach items="${chartMonth }" var="dtoMonth">
													<tr>
														<td>차트 잠정 미정. </td>
														<td>${dtoMonth.month } </td>
														<td>${dtoMonth.month_total_salesPrice } </td>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</thead>
							</table>
								
							
				
					</div></div></div></div>
			</div>
		</section>

		<!--  ---------------------------------- 정보 쓰기란 종료 ----------------------------------  -->
	</main>
</c:if>		

	<!-- 22.11.19 Hosik - Can view manage_main.jsp just got Admin session End  -->
	<!-- End #main -->
	<c:if test="${ADMIN != 'admin'}">
		<%@include file = "header_innerpage.jsp" %>
		<main id="main">

		<!-- ======= Breadcrumbs Section ======= -->
			 <section class="breadcrumbs">
			      <div class="container">
			        <div class="d-flex justify-content-between align-items-center">
			          <h2>Error</h2>
			        </div>
			      </div>
		    </section><!-- End Breadcrumbs Section -->
	
			<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
			<section class="inner-page">
				<div class="container">
						<h2> 잘못된 접근 입니다.</h2>
						<a href="index">메인 화면으로 돌아가기</a>
				</div> 
			</section>
		</main>
	</c:if>	
	
	

	<!-- ======= Footer ======= -->
	<%@include file="footer.jsp"%>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>