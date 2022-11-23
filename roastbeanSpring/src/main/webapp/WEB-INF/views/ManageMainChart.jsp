<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript">
		window.onload = function() {
		 
		var dps = [[]];
		<c:if test="${error == null}">
			var chart = new CanvasJS.Chart("chartContainer", {
				theme: "light2", // "light1", "dark1", "dark2"
				animationEnabled: true,
				title: {
					text: "Column Chart from Database"
				},
				data: [{
					type: "column",
					dataPoints: dps[0]
				/* datapoint */
				}]
			});
		</c:if>
		 
		var xValue;
		var yValue;
		 
		<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
			<c:forEach items="${dataPoints}" var="dataPoint">
				xValue = parseInt("${dataPoint.x}");
				yValue = parseFloat("${dataPoint.y}");
				dps[parseInt("${loop.index}")].push({
					x : xValue,
					y : yValue,
				});		
			</c:forEach>	
		</c:forEach> 
		 
		<c:if test="${error == null}">
			chart.render();
			</c:if>
		}
	</script>
	<title>Manage Chart Test</title>
</head>
<body>
	<%-- <c:if test="${error != null}">
	<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px; text-align: center;'>${error}</div>
	</c:if> --%>
	<%-- <c:if test="${error == null}"> --%>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<%-- </c:if> --%>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>      