<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 博客网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style(1).css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif" /></div>
	<div class="help"><a href="${pageContext.request.contextPath}/index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="blog.jsp">文章</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">博客网</a> &gt; 管理后台
</div>
<jsp:include page="comm.jsp"></jsp:include>
	<div class="main">
		<h2>添加美食</h2>
		<div class="manage">
			<form action="showFood.food" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">食物分类：</td>
						<td>
							<select name="parentId">
								<option value="0" selected="selected">根栏目</option>
								<c:forEach var="li" items="${foodsTypes}">
								<option value="${li.childId}">${li.foodsTypeName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">菜品名称：</td>
						<td><input type="text" class="text" name="foodName"  /></td>
					</tr>
					<tr>
						<td class="field">菜品价格：</td>
						<td><input type="text" class="text" name="foodPrice"  /></td>
					</tr>
					<tr>
						<td class="field">菜品描述：</td>
						<td><input type="text" class="text" name="foodPrint"  /></td>
					</tr>
					<tr>
						<td class="field">菜品图片：</td>
						<td><input type="file" class="text" name="file"  /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
