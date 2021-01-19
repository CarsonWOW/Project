<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/13
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/user-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/manage/queryUser.user">用户管理</a></dd>
                <dt>新闻咨询管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/blog-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/New.new">新闻管理</a></dd>
                <dt>美食管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/addFood.food">新增</a></em><a href="${pageContext.request.contextPath}/Food.food">菜品管理</a></dd>
                <dt>店面管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/addShop.shop">新增</a></em><a href="${pageContext.request.contextPath}/Shop.shop">店面管理</a></dd>
            </dl>
        </div>
    </div>
</body>
</html>
