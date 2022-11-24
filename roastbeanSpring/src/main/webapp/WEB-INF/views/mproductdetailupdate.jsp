<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		
    <form name= "mproductdetailupdateinsert" action="mproductdetailupdateinsert" method="post"
    enctype="multipart/form-data">
    
    
    <c:if test="${not empty mproductdetailupdate.product_image}">
			<div class="container pb-5">
				<div class="row">
					<div class="col-lg-5 mt-5">
						<div class="card mb-3">
					<input type="file" class="form-control my-2" name="file"
					accept="image/*"
					onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"
					value="사진 선택">
							<img class="card-img img-fluid"
								src="assets/img/product/${mproductdetailupdate.product_image}"
								alt="Card image cap" id="product-detail">
						</div>
					</div>
					
					<div class="col-lg-7 mt-5">
							<div class="">
								<div class="card-body">
									<h1 class="h2"><input type="text" class="form-control" name="product_name" value="${mproductdetailupdate.product_name}" ></h1>
									
									<p class="h3 py-2">
										<input type="text" name="product_price" 
										value="${mproductdetailupdate.product_price}${product_price}" 
										placeholder="제품의 가격을 입력해주세요">원
									</p>
									
									<ul class="list-inline">
									</ul>
									<b>상품설명:</b>
									<p><input type="text" class="form-control" name="product_info" 
										value="${mproductdetailupdate.product_info}${product_info}" 
										placeholder="제품의 정보를 입력해주세요">
										</p>
				
									<table>
										<tr>
											<td>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item"><b>용량 : </b> <input type="text" name="product_weight" class="form-control"
										value="${mproductdetailupdate.product_weight}${product_weight}"
										placeholder="제품의 용량를 입력해주세요" size="12"></li>
												<li class="list-inline-item">${mproductdetail.product_weight}g</li>
											</ul>
										</div>
											</td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<td>
												<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">
												<b>카테고리 타입:<input type="text" class="form-control" 
											name="category_type" 
											value="${mproductdetailupdate.category_type}${category_type}" 
											placeholder="카테고리를 입력해주세요"></b></li></ul>
											</td>
										</tr>
										<tr>
											<td>
											<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">
												<b>산미 : </b><input type="text" class="form-control" 
											name="category_acidity" 
											value="${mproductdetailupdate.category_acidity}${category_acidity}" 
											placeholder="산미를 입력해주세요"></li></ul></div>
											
											</td>
											<td></td>
											<td>
											
											<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">
												<b>바디감 : </b> <input type="text" class="form-control" 
											name="category_body" 
											value="${mproductdetailupdate.category_body}${category_body}" 
											placeholder="바디감을 입력해주세요"></li></ul></div>
											</td>
										</tr>
										
										<tr>
										<td>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">
				
												<b>단맛 : </b> <input type="text" class="form-control" 
											name="category_sweet" 
											value="${mproductdetailupdate.category_sweet}${category_sweet}" 
											placeholder="단맛을 입력해주세요"></li></ul></div>
										</td>
										<td></td>
										<td>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right">
												<b>아로마 : </b> <input type="text" class="form-control" 
											name="category_aroma" 
											value="${mproductdetailupdate.category_aroma}${category_aroma}" 
											placeholder="아로마를 입력해주세요">
											</li></ul></div>
										</td>
										</tr>
										<tr><td>
										<div class="col-auto">
											<ul class="list-inline pb-3">
												<li class="list-inline-item text-right"><b>현재 수량
														: <input type="text" class="form-control" 
												name="product_stock" 
												value="${mproductdetailupdate.product_stock}${product_stock}" 
												placeholder="현재 수량을 입력해주세요">
												</b>
												</li>
											</ul>
										</div>
										</td>
										<td></td>
										<td>
											<div class="col d-grid">
											<input type="submit"class="btn btn-success"
												style="background: #F2BCBB; border: 0; padding:10px 48px; color: #fff; 
												transition: 0.4s; border-radius: 50px; " value="수정">
											</div>
											</td></tr>
					</table>
					
									</div>
									<input type="hidden" name="product_id"
										value='<%=request.getParameter("product_id")%>'>
									<div class="row pb-3">
										</div>
									</div>
								</div>
							</div>
					</div>
				</c:if>
				</form>
				
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