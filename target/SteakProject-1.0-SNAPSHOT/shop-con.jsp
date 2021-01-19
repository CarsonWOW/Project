<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>店面展示 - 详情</title>
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
			<li class="bnav-item"><a href="${pageContext.request.contextPath}/queryShops.shop">店面展示</a></li>
			<li class="bnav-item">&lt;</li>
			<li class="bnav-item"><a href="javascript:;">${shops.shopName}</a></li>
		</ul>

	<div class="shop-conwrap">
		<%--店面种类名--%>
		<h1 class="shop-contit">${shops.shopName}</h1>
		<span class="shop-conpic">
				<%--店面图片--%>
				<img src="${shops.shopPicture}"/>
			</span>
		<p class="shop-font14"><span class="shop-font18">特色菜品：</span>${shops.shopCuisine}</p>
		<p class="shop-font14"><span class="shop-font18">营业时间：</span>${shops.shopBusiness}</p>
		<p class="shop-font14"><span class="shop-font18">停车泊位：</span>${shops.shopPark}</p>
		<p class="shop-font14"><span class="shop-font18">餐厅地址：</span>${shops.shopSite}</p>
		<p class="shop-font14"><span class="shop-font18">餐厅标签：</span>${shops.shopLabel}</p>

		<a href="${pageContext.request.contextPath}/queryShops.shop" class="shop-icon">返回列表页</a>
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
