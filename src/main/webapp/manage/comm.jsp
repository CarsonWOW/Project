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
                <dd><em><a href="${pageContext.request.contextPath}/manage/user-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/manage/user.jsp">用户管理</a></dd>
                <dt>新闻咨询管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/blogClass-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/manage/blogClass.jsp">分类管理</a></dd>
                <dd><em><a href="${pageContext.request.contextPath}/manage/blog-add.jsp">新增</a></em><a href="${pageContext.request.contextPath}/manage/blog.jsp">文章管理</a></dd>
                <dt>留言管理</dt>
                <dd><a href="${pageContext.request.contextPath}/manage/guestbook.jsp">留言管理</a></dd>
            </dl>
        </div>
    </div>
</body>
</html>
