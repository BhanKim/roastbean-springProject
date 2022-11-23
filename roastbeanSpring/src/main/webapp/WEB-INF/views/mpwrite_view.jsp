<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>상품등록</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>

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
          <h2>Product Registration</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Product Registration</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->


	<section class="inner-page">
	  <div class="container">
		<form action="mpregistration" method="post" enctype="multipart/form-data">
		
		<!-- 사진 선택 버튼 -->
		<div class="row justify-content-center">
		
		<!-- 선택된 사진 보이는 곳 -->
		<div class="row jstify-content-center">
			<div class="text-center gy-1">
				<img src="user/profile_sample.png" width="250" height="250" class="rounded-circle" alt="사진 선택시 변경" id="blah">
			</div>
		</div>
		
			<div class="col-4 my-3">
				<div class="input-group">
					<label class="input-group-text" for="inputGroupFile01">사진선택</label> 
					<input type="file" class="form-control" name="file"	accept="image/*" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"	value="사진선택">
				</div>
			</div>
		</div>
		
			<table width="800" class="table table-sm table-hover">
					<tr>
						<th width="200" height="40">상품명</th>
						<td> 
						<input type="text" name="product_name" size="50" placeholder="상품명을 입력하세요."> 
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">중량</th>
						<td> 
						<select name="product_weight">
						<option selected="selected">중량</option>
						<c:forEach var="cnt" begin="1" end="3">
						<option value="${cnt*100}">${cnt*100}</option>
						</c:forEach>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">수량</th>
						<td> 
						<select name="product_stock">
						<option selected="selected">수량</option>
						<c:forEach var="cnt" begin="1" end="10">
						<option value="${cnt*10}">${cnt*10}</option>
						</c:forEach>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">타입</th>
						<td> 
						<select name="category_type">
						<option selected="selected">타입</option>
						<option>G블렌딩</option>
						<option>산미강한</option>
						<option>산미중간</option>
						<option>산미약간</option>
						<option>산미없는</option>
						<option>싱글오리진</option>
						<option>디카페인</option>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">산미</th>
						<td> 
						<select name="category_acidity">
						<option selected="selected">산미</option>
						<option>1.0</option>
						<option>1.5</option>
						<option>2.0</option>
						<option>2.5</option>
						<option>3.0</option>
						<option>3.5</option>
						<option>4.0</option>
						<option>4.5</option>
						<option>5.0</option>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">바디감</th>
						<td> 
						<select name="category_body">
						<option selected="selected">바디감</option>
						<option>1.0</option>
						<option>1.5</option>
						<option>2.0</option>
						<option>2.5</option>
						<option>3.0</option>
						<option>3.5</option>
						<option>4.0</option>
						<option>4.5</option>
						<option>5.0</option>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">단맛</th>
						<td> 
						<select name="category_sweet">
						<option selected="selected">단맛</option>
						<option>1.0</option>
						<option>1.5</option>
						<option>2.0</option>
						<option>2.5</option>
						<option>3.0</option>
						<option>3.5</option>
						<option>4.0</option>
						<option>4.5</option>
						<option>5.0</option>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">아로마</th>
						<td> 
						<select name="category_aroma">
						<option selected="selected">아로마</option>
						<option>1.0</option>
						<option>1.5</option>
						<option>2.0</option>
						<option>2.5</option>
						<option>3.0</option>
						<option>3.5</option>
						<option>4.0</option>
						<option>4.5</option>
						<option>5.0</option>
					</select>
						</td>
					</tr>
					
					<tr>
						<th width="200" height="40">금액</th>
						<td> 
						<input type="text" name="product_price" size="20" placeholder="숫자만 입력하세요."> ₩
						</td>
					</tr>
					
					
					<tr>
						<th width="100" height="320">상품설명</th>
						<td>
						<textarea rows="3" cols="50" name="product_info" id="community_content"></textarea>
						<script>CKEDITOR.replace('community_content');</script>
						</td>
					</tr>
					<tr>
						<td colspan="2" height="40">
							&nbsp;&nbsp;<input type="submit" class="btn" style="background: #F2BCBB; border: 0; padding:2px 10px; color: #fff; transition: 0.4s; border-radius: 50px;" value="상품등록">&nbsp;
							<a href="mpList?page=<%= session.getAttribute("cpage") %>" class="btn" style="background: #A3A7AB; border: 0; padding:2px 10px; color: #fff; transition: 0.4s; border-radius: 50px;">취소</a>&nbsp;						
						</td>
					</tr>
			</table>
		</form>	
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