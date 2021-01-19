<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/15
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="clearfix nav">
    <a class="logo" href="javascript:;"></a>
    <ul class="clearfix nav-wrap">
        <li><a class="nav-item nav-active" href="${pageContext.request.contextPath}/findNews.food">首页</a></li>
        <li><a class="nav-item" href="pinpai.jsp">品牌故事</a></li>
        <li><a class="nav-item" href="${pageContext.request.contextPath}/queryFoods.food">美食系列</a></li>
        <li><a class="nav-item" href="${pageContext.request.contextPath}/queryShops.shop">店面展示</a></li>
        <li><a class="nav-item" href="${pageContext.request.contextPath}/queryNew.new">新闻资讯</a></li>
        <li><a class="nav-item" href="about-us.jsp">关于我们</a></li>
        <li><a class="nav-item" href="${pageContext.request.contextPath}/login.jsp">后台管理</a></li>
    </ul>
</div>
</body>
</html>
