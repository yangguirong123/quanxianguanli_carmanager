<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车信息管理</title>
</head>
<body>
	<form action="./add.do" method="post">
	<!-- 如果是添加 ，id则为空需要做一个空判断 -->
		<c:if test="${!empty car.id}">
			<input type="hidden" name="id" value="${car.id }" />
			<br>
			
		</c:if>
		<%-- <input type="hidden" name="id" value="${car.id }" /><br> <br> --%>
		<!-- 如果id不为空，那么说明是从数据库查询出来的信息，即为修改信息。如果为空则是添加汽车信息 -->
		<c:if test="${!empty car.id}">
			<input type="hidden" name="carNumber" value="${car.carNumber}" />
			<br>
			
		</c:if>
		<c:if test="${empty car.id}">
		车牌号:<input type="text" name="carNumber" value="${car.carNumber}" />
			<br>
			<br>
		</c:if>
		车辆品牌:<input type="text" name="carName" value="${car.carName}" /><br><br> 
		客户姓名:<input type="text" name="persenName" value="${car.persenName}" /><br> <br> 
		电话:<input type="text" name="telephone" value="${car.telephone}" /><br> <br>
		地址:<input type="text" name="address" value="${car.address}" /><br><br> 
		<span>${mmm}</span><br> <input type="submit" value="确认" />
	</form>
</body>
</html>