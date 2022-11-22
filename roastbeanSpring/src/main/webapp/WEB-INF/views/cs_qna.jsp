<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Roast Bean : QnA</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <style type="text/css">
  .form-control3 {
	  padding: 0.375rem 0.75rem;
	  font-size: 1rem;
	  font-weight: 400;
  	  line-height: 1em;
  	  text-align-center;
	  color: #212529;
	  background-color: #CFD4D9;
	  background-clip: padding-box;
	  border: 1px solid #ced4da;
	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	  border-radius: 0.375rem;
	  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
	  height: 32px; 
	}
  </style>

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
			<a class="nav-link scrollto" href="notice_list">Notice</a>
			<a class="nav-link scrollto" href="cs_faq">FAQ</a>
			<a class="nav-link scrollto" href="qna_list_by_user"><font color="8784D6" style="font-size: 1.2em; font-weight: bold;">QnA</font></a>
			&emsp;&emsp;&emsp;
			<ol>
				<li><a href="index">Home</a></li>
				<li>Customer Service</li>
			</ol>
        </div>
      </div>
    </section><!-- End Breadcrumbs Section -->
    
	<section class="inner-page">
		<div class="container">
				<!--
 				<h3>&nbsp;&nbsp;1:1 QnA</h3>
				<br>
				<div>
					<span >
					제품 사용, 오염, 전용 박스 손상, 라벨 제거, 사은품 및 부속 사용/분실 시, 교환/환불이 불가능 합니다.<br>
					교환을 원하시는 상품(사이즈)의 재고가 부족 시, 교환이 불가합니다.<br>
					문의유형을 선택하시면 1:1상담이 가능합니다.<br>
					주문취소/교환/환불은 마이페이지>주문내역에서 신청하실 수 있습니다.<br>
					1:1문의 처리 내역은 마이페이지>1:1문의를 통해 확인하실 수 있습니다.<br>
					상품 정보(사이즈, 실측, 예상 배송일 등) 관련 문의는 상품명을 표기하셔야 빠른 답변이 가능합니다.
					</span>
				</div>
				<br>
				<br>
				 -->
				<br>
				<div class="row">
					<div class="col-2"></div>
					<div class="col-8">
						<h3>문의 작성</h3>
						<hr style="border: solid 2px red;">
						<br>
						<form action="qna_question_by_user" method="post">
						<table class="table table-hover" style="vertical-align: middle;">
							<tr align="left">
								<td align="left" style="width: 20%;">문의유형</td>
								<td style="width: 80%;">
									<select name="qna_write_category" style="width: 120px">
										<option value="이용문의">이용문의</option>
										<option value="상품문의">상품문의</option>
										<option value="배송문의">배송문의</option>
										<option value="신고문의">신고문의</option>
										<option value="기타">기타</option>
									</select>								
								</td>
							</tr>
							<tr align="left">
								<td align="left" style="width: 20%;">작성자</td>
								<td style="width: 80%;">
									<input type="text" value="${ID }" readonly="readonly">							
								</td>
							</tr>
							<tr align="left">
								<td align="left" style="width: 20%;">제목</td>
								<td style="width: 80%;">
									<input type="text" name="qna_write_title">							
								</td>
							</tr>
							<tr align="left" valign="top">
								<td align="left" style="width: 20%;">문의내용</td>
								<td style="width: 80%;">
									<textarea name="qna_write_content" rows="6" cols="80%"></textarea>
								</td>
							</tr>
						</table>
							<div align="right">
								<input type="submit" value="작성하기" onclick="alert('질문등록이 완료되었습니다.');return true;" class="btn mb-2" style="background-color: #F2BCBB">
							</div>
						</form>
							<div align="right">
								<button class="btn" type="button" style="background-color: #D0D4D8" onclick="location.href='mypage_qna_list_'">질문목록</button>
							</div>
					</div>
					<div class="col-2"></div>
				</div>
				<%-- ******** 페이징부분 아직 적용안됐음 ******** --%>
			 	<%-- <div class="container" align="center">
				<table>
					<tr>
						<td align="center" colspan="6">
						<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 처음 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=1&product_id=${productDetail.product_id}">[ 처음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
							<c:when test="${(page.curPage - 1) < 1 }">
								[ 이전 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=${page.curPage - 1 }&product_id=${productDetail.product_id}">[ 이전 ]</a>
							</c:otherwise>
							</c:choose>
							
							<!-- 개별 페이지 -->
							<c:forEach var="fEach" begin="${page.startPage }" end="${page.endPage }" step="1">
								<c:choose>
								<c:when test="${page.curPage == fEach}">
									&nbsp; [ ${fEach } ] &nbsp;
								</c:when>
								<c:otherwise>
									<a href="productDetail.do?page=${fEach }&product_id=${productDetail.product_id}">[ ${fEach } ]</a>&nbsp;
								</c:otherwise>
								</c:choose>
							</c:forEach>
							
							<!-- 다음 -->
							<c:choose>
							<c:when test="${(page.curPage + 1) > page.totalPage }">
								[ 다음 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=${page.curPage + 1 }&product_id=${productDetail.product_id}">[ 다음 ]</a>
							</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
							<c:when test="${page.curPage == page.totalPage }">
								[ 마지막 ]
							</c:when>
							<c:otherwise>
								<a href="productDetail.do?page=${page.totalPage }&product_id=${productDetail.product_id}">[ 마지막 ]</a>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</table>
				</div> --%>
				<%-- ******** 페이징부분 아직 적용안됐음 ******** --%>
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