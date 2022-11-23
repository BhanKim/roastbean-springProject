<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
<br><br>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<br><br>
<hr><br><br>
<div id="chartContainer2" style="height: 370px; width: 100%;"></div>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</head>
</html>
