Ï<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Roast Bean</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<style type="text/css">
.star {
	font-size: 1rem;
	color: red;
}

.star2 {
	font-size: 2rem;
	color: red;
}

.star span {
	width: 0;
	left: 0;
	color: red;
	pointer-events: none;
}
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
}
.pagination a.active {
    padding-bottom: 6px;
    border-bottom: 3px solid #111;
}
</style>
</head>
<body>
	<!-- ======= Header ======= -->
	<%@include file = "header_minnerpage.jsp" %>
	
	<main id="main">
  	<!-- End Header -->

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Product Detail (Manage)</h2>
          <ol>
            <li><a href="index">Home</a></li>
            <li>Product Detail (Manage)</li>
          </ol>
        </div>
      </div>
    </section><!-- End Breadcrumbs Section -->
		<section id="contact" class="contact">
			<div class="container pb-5">
				<div class="row">
					<div class="col-lg-5 mt-5">
						<div class="card mb-3">
							<img class="card-img img-fluid"
								src="assets/img/product/${mproductdetail.product_image}"
								alt="Card image cap" id="product-detail">
						</div>
					</div>
					<div class="col-lg-7 mt-5">
							<div class="">
								<div class="card-body">
									<h1 class="h2">${mproductdetail.product_name}</h1>

									
									<p class="h3 py-2">
										<fmt:formatNumber value="${mproductdetail.product_price}"
											groupingUsed="true" />
										원
									</p>
									<ul class="list-inline">
										<li class="list-inline-item"></li>
									</ul>
									<h6>상품설명:</h6>
									<p>${mproductdetail.product_info}</p>

									<div class="row">
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item"><b>용량 : </b> <input
													type="hidden" name="product_weight" id="product-size"
													value="S"></li>
												<li class="list-inline-item">${mproductdetail.product_weight}g</li>
											</ul>
										</div>
										
										<p>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">
												<b>카테고리 타입: ${mproductdetail.category_type}</b><br>
												<b>산미 : </b> ${mproductdetail.category_acidity}&nbsp;
												<b>바디감 : </b> ${mproductdetail.category_body} &nbsp;
												<b>단맛 : </b> ${mproductdetail.category_sweet} &nbsp;
												<b>아로마 : </b> ${mproductdetail.category_aroma}
												</li>
											</ul>
										</div>
										<p>
										<p>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right"><b>현재 수량
														: ${mproductdetail.product_stock}</b>
												</li>
											</ul>
										</div>
										<p>
										<div class="col d-grid">
										<a href="mproductdetailupdate?product_id=${mproductdetail.product_id }" class="btn btn-success"
											style="background: #F2BCBB; border: 0; padding:10px 24px; color: #fff; 
											transition: 0.4s; border-radius: 50px; ">수정</a>
										</div>
										<div class="col d-grid">
										<a href="mproductdetaildelete?product_id=${mproductdetail.product_id }" class="btn btn-success"
											style="background: #F2BCBB; border: 0; padding:10px 24px; color: #fff; 
											transition: 0.4s; border-radius: 50px; ">삭제</a>
										</div>
									</div>
									<input type="hidden" name="product_id"
										value='<%=request.getParameter("product_id")%>'>
									<div class="row pb-3">
										</div>
									</div>
								</div>
							</div>
					</div>
				</div>
		</section>
	</main>
	<%@include file="footer.jsp"%>
	
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