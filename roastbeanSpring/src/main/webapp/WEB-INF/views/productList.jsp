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
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
}
.pagination a.active {
    padding-bottom: 6px;
    border-bottom: 3px solid #111;
}
.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<body>
	<!-- ======= Header ======= -->
	<%@include file = "header_innerpage.jsp" %>
  	<!-- End Header -->
  	
  	<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Coffee Shop</h2>
          <ol>
            <li><a href="index">Home</a></li>
            <li>Coffee Shop</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->
    
	<section id="why-us" class="why-us">
		<div class="container">
			<div class="row">
				<div class="xans-element- xans-product xans-product-headcategory title" align="center">
					<h2>
						<% if(request.getParameter("type") == null) { %>
							<span class="tit_n1" style="font-weight: bold;">????????????</span>
						<% } else { %>
							<span class="tit_n1" style="font-weight: bold;"><%=request.getParameter("type")%></span>
						<% } %>
					</h2>
					<p class="banner"></p>
					<ul id="type" style="display:inline-block; list-style:none;">
						<li style="float: left; padding: 10px;"><a class="active" href="productList?page=1">????????????</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=????????????&type=?????????(????????????)">?????????(????????????)</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=????????????&type=?????????(????????????)">?????????(????????????)</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=????????????&type=????????????(????????????)">????????????(????????????)</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=????????????&type=?????????(????????????)">?????????(????????????)</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=G?????????&type=G?????????">G?????????</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=???????????????&type=???????????????">???????????????</a></li>
		                <li style="float: left; padding: 10px;"><a href="productList?category_type=????????????&type=????????????">????????????</a></li>
            		</ul>
				</div>
				<c:forEach items="${list}" var="dto">
				<div class="col-lg-4">
				 <div class="card mb-4 product-wap rounded-0" style="border: 0;">
					<div class="box" align="center" style="padding: 40px 30px;"><a href="productDetail?product_id=${dto.product_id}">
						<img class="card-img rounded-0 img-fluid" src="assets/img/product/${dto.product_image}"></a>
						<h5>${dto.product_name}</h5>
						<p>${dto.product_info}</p>
						<p>?????? ${dto.category_acidity} | ????????? ${dto.category_body} | ?????? ${dto.category_sweet} | ????????? ${dto.category_aroma}</p>
						<h6><fmt:formatNumber value="${dto.product_price}" groupingUsed="true" /> ???</h6>
					</div>
				 </div>
				</div>
				</c:forEach>
				<div class="container" align="center">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:choose>
								<c:when test="${(page.curPage - 1) < 1 }">
									<li class="page-item disabled"><a class="page-link">??????</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productList?page=1">??????</a>
									</li>
								</c:otherwise>
							</c:choose>
							<!-- ?????? -->
							<c:choose>
								<c:when test="${(page.curPage - 1) < 1 }">
									<li class="page-item disabled"><a class="page-link">??????</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productList?page=${page.curPage - 1 }">??????</a>
									</li>
								</c:otherwise>
							</c:choose>
							<!-- ?????? ????????? -->
							<c:forEach var="fEach" begin="${page.startPage }"
								end="${page.endPage }" step="1">
								<c:choose>
									<c:when test="${page.curPage == fEach}">
										<li class="page-item disabled"><a class="page-link active">&nbsp;${fEach }&nbsp;</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="productList?page=${fEach}">&nbsp;${fEach }&nbsp;</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<!-- ?????? -->
							<c:choose>
								<c:when test="${(page.curPage + 1) > page.totalPage }">
									<li class="page-item disabled"><a class="page-link">??????</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productList?page=${page.curPage + 1 }">??????</a>
									</li>
								</c:otherwise>
							</c:choose>
							<!-- ??? -->
							<c:choose>
								<c:when test="${page.curPage == page.totalPage }">
									<li class="page-item disabled"><a class="page-link">?????????</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="productList?page=${page.totalPage }">?????????</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
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