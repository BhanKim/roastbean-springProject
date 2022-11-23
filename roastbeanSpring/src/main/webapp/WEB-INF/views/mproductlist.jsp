<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>MProductlist</title>
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

<body>

  <!-- ======= Header ======= -->
	<%@include file = "header_minnerpage.jsp" %>
  <!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Manage Productlist</h2>
          <ol>
            <li><a href="MainManage">Main</a></li>
            <li>Manage Productlist</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

	<section class="inner-page">
	  <div class="container">

		<div class="row">
		    <div class="col">
		    	<h2>&nbsp;&nbsp;Manage Product List</h2><br>
		    	<form action="pSearch" method="post" style="text-align:center;">
					<select name="b_opt">
						<option value="product_name">제품명</option>
					</select>&nbsp;
					<input type="text" name="keyword" size="20">&nbsp;
					<input type="submit" class="btn" value="검색" style="background: #F2BCBB; border: 0; padding:3px 12px; color: #fff; transition: 0.4s; border-radius: 50px;">
				</form>
				<div align="right">
					<a href="mpwrite_view" class="btn" style="background: #F2BCBB; border: 0; padding:2px 10px; color: #fff; transition: 0.4s; border-radius: 50px;">상품등록</a>
				</div>
				<br>
		    	<table class="table table-sm table-hover">
					<thead>
						<tr>
							<th width=30 style="text-align: center;">번호</th>
							<th width=100 style="text-align: center;">사진</th>
							<th width=150 style="text-align: center;">제품명</th>
							<th width=70 style="text-align: center;">수량</th>
							<th width=70 style="text-align: center;">금액</th>
						</tr>
					</thead>
					<tbody>
					
						<!-- Manage Product List -->
						<c:forEach items="${mpList}" var="dto" varStatus="status">				
						<tr>
								<td width=70 style="text-align: center;">${dto.rownum }</td>
									
								<td style="text-align: center;"> <img width = 100, height = 100 src="assets/img/product/${dto.product_image}"></td>
											
								<td style="text-align: center;">
									<a href="mproductdetail?product_id=${dto.product_id }" style="color: #000000;">${dto.product_name }</a></td>
								
								<td style="text-align: center;">${dto.product_stock}</td>
								
								<td style="text-align: center;">${dto.product_price}₩</td>
							
						</tr>
						</c:forEach>
						<tr></tr>
						
					</tbody>	
				</table><br>
				
			<!-- Paging -->
			<div class="container" align="center">
               <nav aria-label="Page navigation example">
                  <ul class="pagination justify-content-center">
                     <c:choose>
                        <c:when test="${(page.curPage - 1) < 1 }">
                           <li class="page-item disabled"><a class="page-link">처음</a>
                           </li>
                        </c:when>
                        <c:otherwise>
                           <li class="page-item"><a class="page-link"
                              href="mpList?page=1">처음</a>
                           </li>
                        </c:otherwise>
                     </c:choose>
                     <!-- 이전 -->
                     <c:choose>
                        <c:when test="${(page.curPage - 1) < 1 }">
                           <li class="page-item disabled"><a class="page-link">이전</a>
                           </li>
                        </c:when>
                        <c:otherwise>
                           <li class="page-item"><a class="page-link"
                              href="mpList?page=${page.curPage - 1 }">이전</a>
                           </li>
                        </c:otherwise>
                     </c:choose>
                     <!-- 개별 페이지 -->
                     <c:forEach var="fEach" begin="${page.startPage }"
                        end="${page.endPage }" step="1">
                        <c:choose>
                           <c:when test="${page.curPage == fEach}">
                              <li class="page-item disabled"><a class="page-link active">&nbsp;${fEach }&nbsp;</a>
                              </li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link"
                                 href="mpList?page=${fEach}">&nbsp;${fEach }&nbsp;</a>
                              </li>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>

                     <!-- 다음 -->
                     <c:choose>
                        <c:when test="${(page.curPage + 1) > page.totalPage }">
                           <li class="page-item disabled"><a class="page-link">다음</a>
                           </li>
                        </c:when>
                        <c:otherwise>
                           <li class="page-item"><a class="page-link"
                              href="mpList?page=${page.curPage + 1 }">다음</a>
                           </li>
                        </c:otherwise>
                     </c:choose>
                     <!-- 끝 -->
                     <c:choose>
                        <c:when test="${page.curPage == page.totalPage }">
                           <li class="page-item disabled"><a class="page-link">마지막</a>
                           </li>
                        </c:when>
                        <c:otherwise>
                           <li class="page-item"><a class="page-link"
                              href="mpList?page=${page.totalPage }">마지막</a>
                           </li>
                        </c:otherwise>
                     </c:choose>
                  </ul>
               </nav>
            </div>
				
				
				<!-- Paging End -->
				</div>
			</div>
		 </div>
	</section>
	

				

  </main><!-- End #main -->

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