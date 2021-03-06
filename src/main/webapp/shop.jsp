<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>店面展示</title>
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script>
	function onSubmit() {
		var FoodName=document.getElementById("searchform");
		FoodName.submit();
	}
</script>
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
	<li class="bnav-item"><a href="${pageContext.request.contextPath}/findNews.food">首页</a></li>
	<li class="bnav-item">&lt;</li>
	<li class="bnav-item"><a href="${pageContext.request.contextPath}/queryShops.shop">店面展示</a></li>
	<li class="bnav-item">&lt;</li>
	<li class="bnav-item"><a href="javascript:;">全部店面</a></li>
</ul>
<div class="clearfix table-wrap" id="tab-span">
	<span class="table-item table-active"><a href="${pageContext.request.contextPath}/queryShops.shop" >全部店面</a></span>
	<c:forEach var="u" items="${shopsTypes}">
		<span class="table-item"><a href="${pageContext.request.contextPath}/findShopsType.shop?id=${u.BU_shopTypeId}">${u.BU_Name}</a></span>
	</c:forEach>
	<div class="search clearfix">
		<form action="${pageContext.request.contextPath}/queryShops.shop" method="post" name="searchform" id="searchform">
			<input class="inp-txt" type="text" name="FoodName" id="FoodName"  >
			<input class="inp-btn" type="button" name="Submit" id="Submit" value="搜索" onclick="onSubmit()">
		</form>
	</div>
</div>
<div id="table-div">
	<div class="table-pic table-show clearfix">
		<c:forEach var="li" items="${list}">.
			<input type="hidden" name="id" value="${li.shopId}">
			<a href="${pageContext.request.contextPath}/findShopsByID.shop?id=${li.shopId}" class="shop-wrap shop-right">
					<span class="ms-pic">
						<%--店面图片--%>
						<img src="${li.shopPicture}" alt="" />
					</span>
					<%--店面名称--%>
				<p class="shop-tit">${li.shopName}</p>
			</a>
		</c:forEach>
		<%--<a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic1.jpg" alt="" />
            </span>
            <p class="shop-tit">北京朝阳区店</p>
        </a>
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic2.jpg" alt="" />
            </span>
            <p class="shop-tit">北京朝阳区店</p>
        </a>
        <a href="shop-con.jsp" class="shop-wrap">
            <span class="shop-pic">
                <img src="img/shop-pic3.jpg" alt="" />
            </span>
            <p class="shop-tit">北京朝阳区店</p>
        </a>
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic4.jpg" alt="" />
            </span>
            <p class="shop-tit">北京朝阳区店</p>
        </a>
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic5.jpg" alt="" />
            </span>
            <p class="shop-tit">北京朝阳区店</p>
        </a>
        <a href="shop-con.jsp" class="shop-wrap">
            <span class="shop-pic">
                <img src="img/shop-pic6.jpg" alt="" />
            </span>
            <p class="shop-tit">北京朝阳区店</p>
        </a>
    </div>
    <div class="table-pic clearfix">
        <a href="shop-con.jsp" class="shop-wrap">
            <span class="shop-pic">
                <img src="img/shop-pic3.jpg" alt="" />
            </span>
            <p class="shop-tit">上海朝阳区店</p>
        </a>
    </div>
    <div class="table-pic clearfix">
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic4.jpg" alt="" />
            </span>
            <p class="shop-tit">厦门朝阳区店</p>
        </a>
        <a href="shop-con.jsp" class="shop-wrap">
            <span class="shop-pic">
                <img src="img/shop-pic6.jpg" alt="" />
            </span>
            <p class="shop-tit">厦门朝阳区店</p>
        </a>
    </div>
    <div class="table-pic clearfix">
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic5.jpg" alt="" />
            </span>
            <p class="shop-tit">广州朝阳区店</p>
        </a>
    </div>
    <div class="table-pic clearfix">
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic2.jpg" alt="" />
            </span>
            <p class="shop-tit">深圳朝阳区店</p>
        </a>
    </div>
    <div class="table-pic clearfix">
        <a href="shop-con.jsp" class="shop-wrap shop-right">
            <span class="shop-pic">
                <img src="img/shop-pic1.jpg" alt="" />
            </span>
            <p class="shop-tit">朝阳区店</p>
        </a>
    </div>
    <ul class="shop-paging clearfix">
        <li><a href="shop-con.jsp" class="pag-item">&lt;</a></li>
        <li><a href="shop-con.jsp" class="pag-item pag-active">1</a></li>
        <li><a href="javascript:;" class="pag-item">2</a></li>
        <li><a href="javascript:;" class="pag-item">3</a></li>
        <li><a href="javascript:;" class="pag-item">4</a></li>
        <li><a href="javascript:;" class="pag-item">&gt;</a></li>
    </ul>--%>
	</div>
	<ul class="shop-paging clearfix">
		<li><a href="shop-con.jsp" class="pag-item">&lt;</a></li>
		<c:if test="${page.curPageNo>1}">
			<li><a href="${pageContext.request.contextPath}/queryShops.shop?curPageNo=1" class="pag-item pag-active">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/queryShops.shop?curPageNo=${page.curPageNo-1}" class="pag-item">上一页</a></li>
		</c:if>
		<c:if test="${page.curPageNo<page.totalPageCount}">
			<li><a href="${pageContext.request.contextPath}/queryShops.shop?curPageNo=${page.curPageNo+1}" class="pag-item">下一页</a></li>
			<li><a href="${pageContext.request.contextPath}/queryShops.shop?curPageNo=${page.totalPageCount}" class="pag-item">末页</a></li>
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
	//美食系列当前项切换
	$(".table-item").click(function(){
		$(this).siblings().removeClass("table-active");
		$(this).addClass("table-active");
	});
	//美食系列table切换
	var oSpan = document.getElementById("tab-span");
	var spans = oSpan.querySelectorAll("span");
	var oDiv  = document.getElementById("table-div");
	var divs = oDiv.querySelectorAll("div");
	var last=spans[0];
	for(var i=0;i<spans.length;i++){
		spans[i].index=i;  //给每一个按钮添加一个自定义属性，存储的是他们对应的索引值；
		spans[i].onclick=function(){
			divs[last.index].style.display="none"; //上一个对应的div，让他隐藏
			divs[this.index].style.display="block"; //当前点击按钮对应的div显示
			last=this; 	//把上一次点击的对象更新成当前点击的对象
		};
	};
</script>
</html>
