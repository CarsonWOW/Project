<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>美食系列</title>
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
			<li class="bnav-item"><a href="${pageContext.request.contextPath}/queryFoods.food">美食系列</a></li>
			<li class="bnav-item">&lt;</li>
			<li class="bnav-item"><a href="${pageContext.request.contextPath}/queryFoods.food">全部菜品</a></li>
		</ul>
		<div class="clearfix table-wrap" id="tab-span">
			<span class="table-item table-active"><a href="${pageContext.request.contextPath}/queryFoods.food">全部菜品</a></span>
			<c:forEach var="u" items="${foodsTypes}">
			<span class="table-item" ><a href="${pageContext.request.contextPath}/findFoodsType.food?id=${u.childId}">${u.foodsTypeName}</a></span>
			</c:forEach>
			<div class="search clearfix">
				<form action="${pageContext.request.contextPath}/queryFoods.food" method="post" name="searchform" id="searchform">
				<input class="inp-txt" type="text" name="FoodName" id="FoodName"  >
				<input class="inp-btn" type="button" name="Submit" id="Submit" value="搜索" onclick="onSubmit()">
			</form>
			</div>
		</div>
		<div id="table-div">
			<div class="table-pic table-show clearfix">
				<c:forEach var="li" items="${list}">.
					<input type="hidden" name="id" value="${li.fId}">
				<a href="${pageContext.request.contextPath}/findFoodsByID.food?id=${li.fId}" class="ms-wrap ms-right">
					<span class="ms-pic">
						<%--食物图片--%>
						<img src="${li.fPicture}" alt="" />
					</span>
					<%--食物名称--%>
					<h2 class="ms-tit">${li.foodName}</h2>
					<%--食物价格--%>
					<p class="ms-txt">价格：${li.fPrice}</p>
				</a>
				</c:forEach>
				<%--<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic2.jpg" alt="" />
					</span>
					<h2 class="ms-tit">草莓布丁杯</h2>
					<p class="ms-txt">价格：12元</p>
				</a>
				<a href="meishi-con.jsp" class="ms-wrap">
					<span class="ms-pic">
						<img src="img/ms-pic3.jpg" alt="" />
					</span>
					<h2 class="ms-tit">菲力黑椒牛排</h2>
					<p class="ms-txt">价格：69元</p>
				</a>
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic4.jpg" alt="" />
					</span>
					<h2 class="ms-tit">香煎排意面</h2>
					<p class="ms-txt">价格：69元</p>
				</a>
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic5.jpg" alt="" />
					</span>
					<h2 class="ms-tit">鲜香培根比萨</h2>
					<p class="ms-txt">价格：59元/24寸</p>
				</a>
				<a href="meishi-con.jsp" class="ms-wrap">
					<span class="ms-pic">
						<img src="img/ms-pic6.jpg" alt="" />
					</span>
					<h2 class="ms-tit">番茄烩意面</h2>
					<p class="ms-txt">价格：39元</p>
				</a>
			</div>
			<div class="table-pic clearfix">
				<a href="meishi-con.jsp" class="ms-wrap">
					<span class="ms-pic">
						<img src="img/ms-pic3.jpg" alt="" />
					</span>
					<h2 class="ms-tit">菲力黑椒牛排</h2>
					<p class="ms-txt">价格：69元</p>
				</a>
			</div>
			<div class="table-pic clearfix">
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic4.jpg" alt="" />
					</span>
					<h2 class="ms-tit">香煎排意面</h2>
					<p class="ms-txt">价格：69元</p>
				</a>
				<a href="meishi-con.jsp" class="ms-wrap">
					<span class="ms-pic">
						<img src="img/ms-pic6.jpg" alt="" />
					</span>
					<h2 class="ms-tit">番茄烩意面</h2>
					<p class="ms-txt">价格：39元</p>
				</a>
			</div>
			<div class="table-pic clearfix">
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic5.jpg" alt="" />
					</span>
					<h2 class="ms-tit">鲜香培根比萨</h2>
					<p class="ms-txt">价格：59元/24寸</p>
				</a>
			</div>
			<div class="table-pic clearfix">
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic2.jpg" alt="" />
					</span>
					<h2 class="ms-tit">草莓布丁杯</h2>
					<p class="ms-txt">价格：12元</p>
				</a>
			</div>
			<div class="table-pic clearfix">
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic2.jpg" alt="" />
					</span>
					<h2 class="ms-tit">草莓布丁杯</h2>
					<p class="ms-txt">价格：12元</p>
				</a>
			</div>
			<div class="table-pic clearfix">
				<a href="meishi-con.jsp" class="ms-wrap ms-right">
					<span class="ms-pic">
						<img src="img/ms-pic1.jpg" alt="" />
					</span>
					<h2 class="ms-tit">海鲜芝士大虾</h2>
					<p class="ms-txt">价格：49元</p>
				</a>--%>
				<%--<table>
					<tr>
						<td>
							当前第${page.curPageNo} 页  总共${page.totalCount}条数据  总共${page.totalPageCount}页
							<c:if test="${page.curPageNo>1}">
								<a href="${pageContext.request.contextPath}/New.new?curPageNo=1"> 首页</a>
								<a  href="${pageContext.request.contextPath}/New.new?curPageNo=${page.curPageNo-1}">上一页</a>
							</c:if>

							<c:if test="${page.curPageNo<page.totalPageCount}">
								<a  href="${pageContext.request.contextPath}/New.new?curPageNo=${page.curPageNo+1}">下一页</a>
								<a href="${pageContext.request.contextPath}/New.new?curPageNo=${page.totalPageCount}">末页</a>
							</c:if>

						</td>
					</tr>
				</table>--%>
			</div>

			<ul class="ms-paging clearfix">
				<li><a href="javascript:;" class="pag-item">&lt;</a></li>
				<c:if test="${page.curPageNo>1}">
					<li><a href="${pageContext.request.contextPath}/queryFoods.food?curPageNo=1" class="pag-item pag-active">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/queryFoods.food?curPageNo=1" class="pag-item pag-active">上一页</a></li>
				</c:if>
				<c:if test="${page.curPageNo<page.totalPageCount}">
					<li><a href="${pageContext.request.contextPath}/queryFoods.food?curPageNo=${page.curPageNo+1}" class="pag-item">下一页</a></li>
					<li><a href="${pageContext.request.contextPath}/queryFoods.food?curPageNo=${page.totalPageCount}" class="pag-item">末页</a></li>
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
