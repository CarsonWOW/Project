<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 博客网</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style(1).css"/>
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
		<h2>修改用户</h2>
		<div class="manage">
			<form action="updateUser.user" method="post">
				<table class="form">
					<tr>
						<td class="field"></td>
						<td><input type="hidden" class="text" name="id" value="${user.buUserId}"  /></td>
					</tr>
					<tr>
						<td class="field">Email：</td>
						<td><input type="text" class="text" name="Email" value="${user.buEmail}" /></td>
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value="${user.buUserName}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="passWord" value="${user.buPassword}" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><c:if test="${user.buSex=='男'}">
								<input type="radio" name="sex" value="男" checked="checked" />男
								<input type="radio" name="sex" value="女"/>女
							</c:if>
							<c:if test="${user.buSex=='女'}">
								<input type="radio" name="sex" value="男" />男
								<input type="radio" name="sex" value="女" checked="checked" />女
							</c:if>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<select name="birthyear">
								<option value="2000">2000</option>
								<option value="1999" selected="selected">1999</option>
								<option value="1998">1998</option>
								<option value="1997">1997</option>
								<option value="1996">1996</option>
								<option value="1995">1995</option>
							</select>年
							<select name="birthmonth">
								<option value="12">12</option>
								<option value="11" selected="selected">11</option>
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
							</select>月
							<select name="birthday">
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1" selected="selected">1</option>
							</select>日
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="${user.buMobile}" /></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td>
							<select name="STATUS">
								<option value="1">普通用户</option>
								<option value="2">管理员</option>
							</select>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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
