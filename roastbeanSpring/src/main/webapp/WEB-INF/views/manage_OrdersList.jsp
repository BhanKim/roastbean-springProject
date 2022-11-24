<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <!-- test -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

  <title>Manage_order_list</title>
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

  <!-- =======================================================
  * Template Name: Delicious - v4.9.1
  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->


</head>
<body link="black" vlink="black" alink="navy">
<!-- ======= Header ======= -->
<c:if test="${ADMIN == 'admin'}">
		<%@include file = "header_minnerpage.jsp" %>
  <!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2><a href="OrderList">Order List</a></h2>
          <ol>
            <li><a href="ManageMain">ManageMain</a></li>
            <li>Order List</li>
          </ol>
        </div>

      </div>
    </section> 
    <!--End Breadcrumbs Section -->

<!--  ---------------------------------- 정보 쓰기란 시작 ---------------------------------- -->
	<div style="text-align: center;">
	<div align="center">
	<section class="inner-page">
	  <div class="container">
	  		<div class="row">
		    <div class="col">
	  <h2>주문 리스트</h2>
		&nbsp;&nbsp;&nbsp; 
 	<form action="OrderList">
		   <br>
		   검색
		   <select name="query">
		      <option value="order_seq"<c:if test="${query=='order_seq'}">selected="selected"</c:if>>주문번호</option>
		      <option value="user_id"<c:if test="${query=='user_id'}">selected="selected"</c:if>>고객ID</option>
		      <option value="order_name"<c:if test="${query=='order_name'}">selected="selected"</c:if>>고객명</option>
		      <option value="product_name"<c:if test="${query=='product_name'}">selected="selected"</c:if>>상품명</option>
		      <option value="order_date"<c:if test="${query=='order_date'}">selected="selected"</c:if>>주문날짜</option>
		   </select>&nbsp;&nbsp;&nbsp;
		   <input type="text" name="content" value="${content}">
		   <input type="submit" value="검색" class="btn" style="background: #F2BCBB; border: 0; padding:3px 12px; color: #fff; transition: 0.4s; border-radius: 50px;">
		</form>
		<br>
		<br>
	      <table style="margin-left: auto; margin-right: auto; border:none;" border="1" class="table table-sm table-hover">
	        <thead style="color: #fff" bgcolor="#F2BCBB">
		<tr style="border:none;">
		        <td style="text-align: center;">주문번호</td>
		        <td style="text-align: center;">ID</td>
		        <td style="text-align: center;">이름</td>
		        <td style="text-align: center;">상품명</td>
		        <td style="text-align: center;">수량</td>
		        <td style="text-align: center;">금액</td>
		        <td style="text-align: center;">주문날짜</td>
		     </tr>
		</thead>
		<tbody>
		     <c:forEach items="${manageorderlist}" var="dto">
		      <tr style="border:none;"> 
		         <td style="text-align: center;">${dto.order_seq}</td>
		         <td style="text-align: center;">${dto.user_id }</td>
		         <td style="text-align: center;">${dto.order_name }</td>
		         <td style="text-align: center;">${dto.product_name }</td>
		         <td style="text-align: center;">${dto.order_qty }</td>
		         <td style="text-align: center;">${dto.order_price }</td>
		         <td style="text-align: center;">${dto.order_date}</td> 		      
		      </tr>
		      </c:forEach>
		      <tr></tr>
						 <tr>
						<td align="center" colspan="7">
						<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
							<c:otherwise>
								<a href="OrderList?page=1&query=${query}&content=${content}">[ 처음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
							<c:otherwise>
								<a href="OrderList?page=${page.curPage - 1 }&query=${query}&content=${content}">[ 이전 ]</a>
							</c:otherwise>
							</c:choose>
							
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${page.startPage }" end="${page.endPage }" step="1">
								<c:choose>
								<c:when test="${page.curPage == fEach}">
									[ ${fEach } ] &nbsp;
								</c:when>
								<c:otherwise>
									<a href="OrderList?page=${fEach }&query=${query}&content=${content}">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
							<c:when test="${(page.curPage + 1) > page.totalPage }">
								[ 다음 ]
							</c:when>
							<c:otherwise>
								<a href="OrderList?page=${page.curPage + 1 }&query=${query}&content=${content}">[ 다음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
							<c:when test="${page.curPage == page.totalPage }">
								[ 마지막 ]
							</c:when>
							<c:otherwise>
								<a href="OrderList?page=${page.totalPage }&query=${query}&content=${content}">[ 마지막 ]</a>
							</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</tbody>	
	      </table></div></div></div>
	      </section>
	      </div>
	      <br>
	     
	      
	</div>
	<!--  ---------------------------------- 정보 쓰기란 종료 ----------------------------------  -->


  </main><!-- End #main -->
</c:if>		
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
	<%@include file = "footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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