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
			<a class="nav-link scrollto" href="qna_list_by_admin"><font color="8784D6" style="font-size: 1.2em; font-weight: bold;">QnA</font></a>
			&emsp;&emsp;&emsp;
			<ol>
				<li><a href="index">Home</a></li>
				<li>My page</li>
			</ol>
        </div>
      </div>
    </section><!-- End Breadcrumbs Section -->
    
	<section class="inner-page">
		<div class="container">
			<h3>&nbsp;&nbsp;&nbsp;&nbsp;My QnA List</h3>
			<div class="row">
				<div class="col-8"></div>
				<div class="col-4">
				<form action="qna_list_by_admin" method="post" style="text-align:center;">
					<select name="query" >
						<option value="qna_write_seq"<c:if test="${query=='qna_write_seq'}">selected="selected"</c:if>>??????</option>
						<option value="noncomment"<c:if test="${query=='noncomment'}">selected="selected"</c:if>>????????? ??????</option>
						<option value="qna_write_category"<c:if test="${query=='qna_write_category'}">selected="selected"</c:if>>????????????</option>
						<option value="qna_write_content"<c:if test="${query=='qna_write_content'}">selected="selected"</c:if>>????????????</option>
						<option value="user_id"<c:if test="${query=='user_id'}">selected="selected"</c:if>>????????? ID</option>
					</select>&nbsp;
					<input type="text" name="content" size="20" value="${content }">&nbsp;
					<input type="submit" class="btn" value="??????" style="background: #F2BCBB; border: 0; padding:3px 12px; color: #fff; transition: 0.4s; border-radius: 50px;">
				</form>
				</div>
			</div>
			<hr style="border: solid 2px red;">
			<br>
			<div class="col">
				<div>
					<table class="table table-hover" style="vertical-align: middle;">
						<thead>
							<tr align="center">
								<th style="width: 7%;">????????????</th>
								<th style="width: 8%;">?????????</th>
								<th style="width: 8%;">????????????</th>
								<th style="width: 47%;">?????? / ??????</th>
								<th style="width: 20%;">????????? / ?????????</th>
								<th style="width: 10%;">????????????</th>
							</tr>
						</thead>
						<c:forEach items="${adminQnaList}" var="dto">
					 	<form action="qna_answer_by_admin?page=${fEach}&query=${query}&content=${content}" method="post">
							<tr style="background-color: #A3A7AB;">
								<td colspan="6">
								<input type="hidden" name="page" value="${fEach}">
								<input type="hidden" name="query" value="${query}">
								<input type="hidden" name="content" value="${content}">
								</td>
							</tr>
							<tr align="center" >
								<td>${dto.qna_write_seq}<input type="hidden" name="qna_write_seq" value="${dto.qna_write_seq}"></td>
								<td>${dto.user_id}</td>
								<td>${dto.qna_write_category}</td>
								<td align="left">
									- ?????? : ${dto.qna_write_title}<br>
									- ?????? : ${dto.qna_write_content}
								</td>
								<td align="left">
									????????? : ${dto.qna_write_initdate}<br>
									<c:if test="${dto.qna_write_updatedate != null}">
									????????? : ${dto.qna_write_updatedate}
									</c:if>
								</td>
								<c:choose>
									<c:when test="${dto.qna_write_comment_content == null || dto.qna_write_comment_content == ''}">
									<td></td>
									</c:when>
										<c:otherwise>
											<td>????????????</td>
										</c:otherwise>
								</c:choose>
							</tr>
	
							<c:if test="${dto.qna_write_comment_content == null || dto.qna_write_comment_content == ''}">
								<tr align="center" valign="top" style="background-color: #F2F1EF;">
									<td><input type="hidden" name="submit_type" value="insert"></td>
									<td></td>
									<td align="right">???</td>
									<td align="left" colspan="2">
										<textarea name="qna_write_comment_content" rows="5" cols="70%" style="background-color: #F2F1EF"></textarea>
									</td>
									<td valign="middle"><input type="submit" value="????????????" class="btn" style="background-color: #F2BCBB"></td>
								</tr>
							</c:if>
	
							<c:if test="${dto.qna_write_comment_content != null && dto.qna_write_comment_content != ''}">
								<tr align="center" style="background-color: #F2F1EF;">
									<td></td>
									<td></td>
									<td align="right" valign="top">???</td>
									<td align="left">
										<textarea name="qna_write_comment_content" rows="5" cols="70%" style="background-color: #F2F1EF">${dto.qna_write_comment_content}</textarea>
									</td>
									<td align="left">
										<input type="hidden" name="submit_type" value="update">
										????????? : ${dto.qna_write_comment_initdate}<br>
										<c:if test="${dto.qna_write_comment_updatedate != null}">
										????????? : ${dto.qna_write_comment_updatedate}
										</c:if>
									</td>
									<td valign="middle"><input type="submit" value="????????????" class="btn" style="background-color: #A3A7AB"></td>
								</tr>
							</c:if>
						</form>
						</c:forEach>
					</table>
				</div>

				<!-- Paging -->
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
	                              href="qna_list_by_admin?page=1&query=${query}&content=${content}">??????</a>
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
	                              href="qna_list_by_admin?page=${page.curPage - 1 }&query=${query}&content=${content}">??????</a>
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
	                                 href="qna_list_by_admin?page=${fEach}&query=${query}&content=${content}">&nbsp;${fEach }&nbsp;</a>
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
	                              href="qna_list_by_admin?page=${page.curPage + 1 }&query=${query}&content=${content}">??????</a>
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
	                              href="qna_list_by_admin?page=${page.totalPage }&query=${query}&content=${content}">?????????</a>
	                           </li>
	                        </c:otherwise>
	                     </c:choose>
	                  </ul>
	               </nav>
	            </div>
				<!-- Paging End -->
				
				<form action="qna_list_by_admin" method="post" style="text-align:center;">
					<select name="query" >
						<option value="qna_write_seq"<c:if test="${query=='qna_write_seq'}">selected="selected"</c:if>>??????</option>
						<option value="noncomment"<c:if test="${query=='noncomment'}">selected="selected"</c:if>>????????? ??????</option>
						<option value="qna_write_category"<c:if test="${query=='qna_write_category'}">selected="selected"</c:if>>????????????</option>
						<option value="qna_write_content"<c:if test="${query=='qna_write_content'}">selected="selected"</c:if>>????????????</option>
						<option value="user_id"<c:if test="${query=='user_id'}">selected="selected"</c:if>>????????? ID</option>
					</select>&nbsp;
					<input type="text" name="content" size="20" value="${content }">&nbsp;
					<input type="submit" class="btn" value="??????" style="background: #F2BCBB; border: 0; padding:3px 12px; color: #fff; transition: 0.4s; border-radius: 50px;">
				</form>
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