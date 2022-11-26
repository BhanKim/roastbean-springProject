<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Chart</title>
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
<script type="text/javascript">
window.onload = function() { 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	exportEnabled: true,
	
	title: {
		text: "상품 판매 순위"
	},
	
	axisX:{
	    interval: 1
	},
	
	data: [{
		type: "column", //change type to bar, line, area, pie, etc
		dataPoints: ${dataPoints}
	}]
});
chart.render();

 
var chart2 = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	exportEnabled: true,
	title: {
		text: "상품 판매 순위"
	},
	data: [{
		type: "pie", //change type to bar, line, area, pie, etc
		dataPoints: ${dataPoints}
	}]
});
chart2.render();
}
</script>
</head>
<body>
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

  <!-- ======= Header ======= -->
	<%@include file = "header_minnerpage.jsp" %>
  <!-- End Header -->

	<br><br>
		<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<br><br>
	<hr><br><br>
		<div id="chartContainer2" style="height: 370px; width: 100%; margin-bottom: 50px;"></div>


</body>
</main>

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
  
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</head>
</html>
