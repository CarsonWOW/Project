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
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script >
		function deleteFoods(id) {
			if (confirm("确定要删除吗?")){
				location.href = "deleteFoods.food?id=" + id;
			}
		}
	</script>
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
		<h2>美食管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>美食名称</th>
					<th>价格</th>
					<th>种类</th>
					<th>操作</th>
				</tr>
				<c:forEach var="li" items="${list}">
				<tr>
					<td class="first w4 c">${li.fId}</td>
					<td>${li.foodName}</td>
					<td>${li.fPrice}</td>
					<c:forEach var="u" items="${foodsTypes}">
					<c:if test="${li.fTid==u.childId}">
						<td>${u.foodsTypeName}</td>
					</c:if>
					</c:forEach>
					<td class="w1 c"><a href="findFoodsById.food?id=${li.fId}">修改</a> <a href="javascript:deleteFoods(${li.fId});">删除</a></td>
				</tr>
				</c:forEach>

				<%--<tr>
					<td class="first w4 c">1</td>
					<td class="childClass">小类</td>
					<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
				<tr>
					<td class="first w4 c">1</td>
					<td class="childClass">小类</td>
					<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
				<tr>
					<td class="first w4 c">1</td>
					<td>大类</td>
					<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
				<tr>
					<td class="first w4 c">1</td>
					<td class="childClass">小类</td>
					<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
				<tr>
					<td class="first w4 c">1</td>
					<td class="childClass">小类</td>
					<td class="w1 c"><a href="blogClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>--%>
			</table>
			<table>
				<tr>
					<td>
						当前第${page.curPageNo} 页  总共${page.totalCount}条数据  总共${page.totalPageCount}页
						<c:if test="${page.curPageNo>1}">
							<a href="${pageContext.request.contextPath}/Food.food?curPageNo=1"> 首页</a>
							<a  href="${pageContext.request.contextPath}/Food.food?curPageNo=${page.curPageNo-1}">上一页</a>
						</c:if>

						<c:if test="${page.curPageNo<page.totalPageCount}">
							<a  href="${pageContext.request.contextPath}/Food.food?curPageNo=${page.curPageNo+1}">下一页</a>
							<a href="${pageContext.request.contextPath}/Food.food?curPageNo=${page.totalPageCount}">末页</a>
						</c:if>

					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
