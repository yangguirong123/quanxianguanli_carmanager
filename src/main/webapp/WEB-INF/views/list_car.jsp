<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车列表</title>
<script type="text/javascript">
// 当前第几页数据
var currentPage = ${currentPage};

// 总页数
var totalPage = ${totalPage};

function submitForm(actionUrl){
	window.location.href = actionUrl;
}

// 第一页
function firstPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context%>/show.do?pageNum=1");
		return true;
	}
}

// 下一页
function nextPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context%>/show.do?pageNum=" + (currentPage+1));
		return true;
	}
}

// 上一页
function previousPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=context%>/show.do?pageNum=" + (currentPage-1));
		return true;
	}
}

// 尾页
function lastPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=context%>/show.do?pageNum=${totalPage}");
			return true;
		}
	}
</script>
</head>
<body>
	<table width="100%" border="0" bgcolor="#cccccc">
		<tr>
			<td>车牌号</td>
			<td>车辆品牌/型号</td>
			<td>车主姓名</td>
			<td>车主电话</td>
			<td>车主地址</td>
			<td colspan="2">操作</td>
		</tr>

		<%
			String color = "";
			int c = 1;
		%>
		<c:forEach items="${carLists}" var="car">
			<%
				if (c == 1) {
						color = "#ffffff";
						c = 0;
					} else {
						color = "#f5f5f5";
						c = 1;
					}
			%>
			<tr bgcolor="<%=color%>">
				<td>${car.carNumber}</td>
				<td>${car.carName}</td>
				<td>${car.persenName}</td>
				<td>${car.telephone}</td>
				<td>${car.address}</td>
				<td><a href="./delete.do?id=${car.id}">删除</a></td>
				<td><a href="./update.do?id=${car.id}">修改</a></td>
			</tr>

		</c:forEach>
	</table>
	<br>
	<br>共${totalPage}页&nbsp;&nbsp;当前第${currentPage}页&nbsp;&nbsp;
	<a href="#" onclick="firstPage();">首页</a>
	<a href="#" onclick="previousPage();">上一页</a>
	<a href="#" onclick="nextPage();">下一页</a>
	<a href="#" onclick="lastPage();">尾页</a>
	<br>
	
	
</body>
</html>