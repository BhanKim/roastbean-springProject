<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
<!-- ======= Top Bar ======= -->
<section id="topbar"
	class="d-flex align-items-center fixed-top topbar-transparent">
	<div
		class="container-fluid container-xl d-flex align-items-center justify-content-center justify-content-lg-start">
		<i class="bi bi-phone d-flex align-items-center"><span>02-7157-7557</span></i>
		<i class="bi bi-clock ms-4 d-none d-lg-flex align-items-center"><span>Mon-Sat: 10:00 AM - 18:00 PM</span></i>
	</div>
</section>
<style>
    .badge2:after{
        content:attr(value);
        font-size:16px;
        color: #fff;
        background: red;
        border-radius:50%;
        padding: 0 5px;
        position:relative;
        left:-8px;
        top:-10px;
        opacity:0.9;
    }
</style>
<!-- ======= Header ======= -->
<header id="header" class="fixed-top d-flex align-items-center header-transparent">
	<div class="container-fluid container-xl d-flex align-items-center justify-content-between">
		<div class="col-lg-4">
			<h1>
				<a href="index"><img src="assets/img/logo.png" alt="" class="img-fluid" width="320" height="72"></a>
			</h1>
		</div>
		<nav id="navbar" class="navbar order-last order-lg-0">
			<c:if test="${ID == null }">
				<ul>
					<li class="dropdown"><a href="#about"><span>ABOUT</span></a>
						<ul>
							<li><a href="companyinfo">Information</a></li>
							<li><a href="companylocation">Location</a></li>
							<li><a href="beans_that_fit_me">Coffee That Suits Me</a></li>
						</ul>
					<li class="dropdown"><a href="#COMMUNITY"><span>COMMUNITY</span></a>
						<ul>
							<li><a href="boardList">Community</a></li>
							<li><a href="boardnList">COMMUNITY NOTICE</a></li>
						</ul>
					<li><a class="nav-link scrollto" href="beaninfo">BEAN INFORMATION</a></li>
					<li><a class="nav-link scrollto" href="productList">COFFEE SHOP</a></li>
					<li class="dropdown"><a href="notice_list"><span>CUSTOMER SERVICE</span></a>
						<ul>
							<li><a href="notice_list">NOTICE</a></li>
							<li><a href="cs_faq">FAQ</a></li>
							<li><a href="qna_question_by_user">QnA</a></li>
						</ul>
					<li>&emsp;&emsp;</li>
					<li><a class="nav-link scrollto" href="login"><font color="#F2BCBB" style="font-size: 1.1em">Get Started</font></a></li>
				</ul>
			</c:if>	
			
			<!-- success login -->
			<c:if test="${ID != null }">
				<ul>
					<li class="dropdown"><a href="#about"><span>ABOUT</span></a>
						<ul>
							<li><a href="companyinfo">Information</a></li>
							<li><a href="companylocation">Location</a></li>
							<li><a href="beans_that_fit_me">Coffee That Suits Me</a></li>
						</ul>
					<li class="dropdown"><a href="#COMMUNITY"><span>COMMUNITY</span></a>
						<ul>
							<li><a href="boardList">COMMUNITY</a></li>
							<li><a href="boardnList">COMMUNITY NOTICE</a></li>
						</ul>
					<li><a class="nav-link scrollto" href="beaninfo">BEAN INFORMATION</a></li>
					<li><a class="nav-link scrollto" href="productList">COFFEE SHOP</a></li>
					
					<c:if test="${ID != 'admin'}">
						<li class="dropdown"><a href="notice_list"><span>CUSTOMER SERVICE</span></a>
							<ul>
								<li><a href="notice_list">NOTICE</a></li>
								<li><a href="cs_faq">FAQ</a></li>
								<li><a href="qna_question_by_user">QnA</a></li>
							</ul>
						</li>
						<li>&emsp;&emsp;</li>
						<li><a class="nav-link scrollto" href="mypage_info_list"><font color="#F2BCBB" style="font-size: 0.9em">${NICK}님</font></a></li>
						<li><a href="cartOrder"><i class="fa badge2 fa-lg" value="${CARTCOUNT.cartCount}" style="font-size: 1.5em">&#xf07a;</i></a></li>
					</c:if>
					<c:if test="${ID == 'admin'}">
						<li class="dropdown"><a href="notice_list"><span>CUSTOMER SERVICE</span></a>
							<ul>
								<li><a href="notice_list">NOTICE</a></li>
								<li><a href="cs_faq">FAQ</a></li>
								<li><a href="qna_list_by_admin">QnA</a></li>
							</ul>
						</li>
						<li>&emsp;&emsp;</li>
						<li><a class="nav-link scrollto" href="mypage_info_list"><font color="#F2BCBB" style="font-size: 0.9em">${NICK}님</font></a></li>
						<li><a class="nav-link scrollto" href="ManageMain"><font color="#F2BCBB" style="font-size: 0.9em">Manage</font></a></li>
					</c:if>
					
					<c:choose>
						<c:when test="${API eq null}">
							<li><a class="nav-link scrollto" href="logout_action"><font style="font-size: 0.9em">Logout</font></a></li>
						</c:when>
						<c:otherwise>
							<li><a class="nav-link scrollto" href="logout_action" onclick="signOut()"><font style="font-size: 0.9em">Logout</font></a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</c:if>	
			<i class="bi bi-list mobile-nav-toggle"></i>
		</nav>
	</div>
	
	<!-- Google Login API -->
	<script>
	    function signOut() {
	        google.accounts.id.disableAutoSelect();
	        // do anything on logout
	        location.reload();
    		//document.location = "index.jsp";
	    }
	</script>
	<script src="https://accounts.google.com/gsi/client" async defer></script>
    
</header>