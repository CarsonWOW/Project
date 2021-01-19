
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新闻资讯</title>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
	</head>
	<body>
	<jsp:include page="comm.jsp"></jsp:include>
		
		<div id="container">
			<div id="buttons">
		        <span index="1" class="on"></span>
		        <span index="2"></span>
		        <span index="3"></span>
		    </div>
		    <a href="javascript:;" id="prev" class="arrow"><img src="img/l.png"/></a>
		    <a href="javascript:;" id="next" class="arrow"><img src="img/r.png"/></a>
		</div>
		
		<ul class="breadnav clearfix">
			<li class="bnav-item"><a href="index.jsp">首页</a></li>
			<li class="bnav-item">&lt;</li>
			<li class="bnav-item"><a href="news.jsp">新闻资讯</a></li>
		</ul>
		<div class="newslist-wrap">
			<p class="newslist-tit">新闻资讯</p>
			<%--<jsp:useBean id="list" scope="session" type="java.util.List"/>--%>
			<c:forEach var="li" items="${list}">
			<dl class="newslist-box clearfix">
				<td><input type="hidden"  name="id" value="${li.newId}" /></td>
				<dt class="newslist-pic">
					<img  src="${li.newPicture}"/>
				</dt>
				<dd class="newslist-txt">
					<a href="news-con.jsp" class="newslist-font24">${li.newTitle}</a>
					<ul class="newslist-ul">
						<li class="newslist-li">
							<p class="newslist-time">${li.createTime}</p>
						</li>
						<li class="newslist-li">
							<a href="news-con.jsp" class="newslist-con">${li.newDes}</a>
						</li>
						<li class="newslist-li"><a class="newslist-link" href="findD_des.new?id=${li.newId}">&lt;阅读全文&gt;</a></li>
					</ul>
				</dd>
			</dl>
			<span class="news-line">
				<img src="img/news-line.png"/>
			</span>
			</c:forEach>
			<ul class="ms-paging clearfix">
				<li><a href="javascript:;" class="pag-item">&lt;</a></li>
				<c:if test="${page.curPageNo>1}">
					<li><a href="${pageContext.request.contextPath}/queryNew.new?curPageNo=1" class="pag-item pag-active">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/queryNew.new?curPageNo=1" class="pag-item pag-active">上一页</a></li>
				</c:if>
				<c:if test="${page.curPageNo<page.totalPageCount}">
					<li><a href="${pageContext.request.contextPath}/queryNew.new?curPageNo=${page.curPageNo+1}" class="pag-item">下一页</a></li>
					<li><a href="${pageContext.request.contextPath}/queryNew.new?curPageNo=${page.totalPageCount}" class="pag-item">末页</a></li>
				</c:if>
				<li><a href="javascript:;" class="pag-item">&gt;</a></li>
				<tr>
					<td>当前第${page.curPageNo} 页  总共${page.totalCount}条数据  总共${page.totalPageCount}页</td>
				</tr>
			</ul>
		</div>
		<div class="foot">
			<div class="foot-wrap">
				<p class="foot-tit">友情链接</p>
				<ul class="foot-link clearfix">
					<li class="foot-pic">
						<a href="javascript:;"><img src="img/link6.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="img/link5.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="img/link4.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="img/link3.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="img/link2.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="img/link1.png"/></a>
					</li>
				</ul>
				<div class="copyright">
					<p>CopyRight©2003-2015 www.91cy.cn All rigt rederved</p>
					<p>版权所有：贵族食代牛排有限公司  来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
					<p>ICP备案号：京ICP备16047255号-3本站信息由会员自主添加，如信息涉及隐私等，网站不承担任何责任！</p>
				</div>
			</div>
		</div>
		
	</body>
	<!--jq调用-->
	<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
	<script type="text/javascript">
		//导航当前项切换	
		$(".nav-item").click(function(){
			$(this).parent("li").siblings().children().removeClass("nav-active");		
			//点击对象的父级（li）的兄弟级（li）的子集（a）移除类
			$(this).addClass("nav-active");												
			//给点击对象添加类
		});
	</script>
</html>
