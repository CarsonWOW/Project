<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 优先使用 IE 最新版本和 Chrome -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
</body>
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

<div class="new-wrap">
    <p class="newfood-tit">新品推荐</p>
    <div class="newfood-box clearfix" id="newfood-table">
        <ul class="newfood-wrap clearfix newfood-show">
            <li class="newfood-item newfood-right newfood-li1">
                <a href="meishi-con.jsp" class="newfood-p1">茶漱海鲜汤</a>
            </li>
            <li class="newfood-item newfood-right newfood-li2">
                <a href="meishi-con.jsp" class="newfood-p2">玉米海螺沟</a>
            </li>
            <li class="newfood-item newfood-right newfood-li3">
                <a href="meishi-con.jsp" class="newfood-p3">芝士蛋糕卷</a>
            </li>
            <li class="newfood-item newfood-li4">
                <a href="meishi-con.jsp" class="newfood-p4">芝士大虾</a>
            </li>
            <li class="newfood-item newfood-right newfood-li5">
                <a href="meishi-con.jsp" class="newfood-p5">西冷牛排</a>
            </li>
            <li class="newfood-item newfood-right newfood-li6">
                <a href="meishi-con.jsp" class="newfood-p6">草莓布丁杯</a>
            </li>
            <li class="newfood-item newfood-right newfood-li7">
                <a href="meishi-con.jsp" class="newfood-p7">黑椒牛排</a>
            </li>
            <li class="newfood-item newfood-li8">
                <a href="meishi-con.jsp" class="newfood-p8">茶漱海鲜汤</a>
            </li>
        </ul>
        <ul class="newfood-wrap clearfix">
            <li class="newfood-item newfood-right newfood-li5">
                <a href="meishi-con.jsp" class="newfood-p5">西冷牛排</a>
            </li>
            <li class="newfood-item newfood-right newfood-li6">
                <a href="meishi-con.jsp" class="newfood-p6">草莓布丁杯</a>
            </li>
            <li class="newfood-item newfood-right newfood-li7">
                <a href="meishi-con.jsp" class="newfood-p7">黑椒牛排</a>
            </li>
            <li class="newfood-item newfood-li8">
                <a href="meishi-con.jsp" class="newfood-p8">茶漱海鲜汤</a>
            </li>
            <li class="newfood-item newfood-right newfood-li1">
                <a href="meishi-con.jsp" class="newfood-p1">茶漱海鲜汤</a>
            </li>
            <li class="newfood-item newfood-right newfood-li2">
                <a href="meishi-con.jsp" class="newfood-p2">玉米海螺沟</a>
            </li>
            <li class="newfood-item newfood-right newfood-li3">
                <a href="meishi-con.jsp" class="newfood-p3">芝士蛋糕卷</a>
            </li>
            <li class="newfood-item newfood-li4">
                <a href="meishi-con.jsp" class="newfood-p4">芝士大虾</a>
            </li>
        </ul>
        <ul class="newfood-wrap clearfix">
            <li class="newfood-item newfood-right newfood-li3">
                <a href="meishi-con.jsp" class="newfood-p3">芝士蛋糕卷</a>
            </li>
            <li class="newfood-item newfood-li4">
                <a href="meishi-con.jsp" class="newfood-p4">芝士大虾</a>
            </li>
            <li class="newfood-item newfood-right newfood-li1">
                <a href="meishi-con.jsp" class="newfood-p1">茶漱海鲜汤</a>
            </li>
            <li class="newfood-item newfood-right newfood-li2">
                <a href="meishi-con.jsp" class="newfood-p2">玉米海螺沟</a>
            </li>
            <li class="newfood-item newfood-right newfood-li7">
                <a href="meishi-con.jsp" class="newfood-p7">黑椒牛排</a>
            </li>
            <li class="newfood-item newfood-right newfood-li5">
                <a href="meishi-con.jsp" class="newfood-p5">西冷牛排</a>
            </li>
            <li class="newfood-item newfood-right newfood-li6">
                <a href="meishi-con.jsp" class="newfood-p6">草莓布丁杯</a>
            </li>
            <li class="newfood-item newfood-li8">
                <a href="meishi-con.jsp" class="newfood-p8">茶漱海鲜汤</a>
            </li>
        </ul>
    </div>
    <div class="clearfix" id="newfood-span">
        <span style="background: url(img/icon-2.png);"></span>
        <span></span>
        <span></span>
    </div>
</div>
<div class="company-wrap">
    <p class="company-tit">公司简介</p>
    <dl class="clearfix company-dl">
        <dt class="company-dt">
            <img src="img/pic1.png"/>
        </dt>
        <dd class="company-dd">
            <p>贵族食代牛排是昔日的台湾首富、台湾知名企业贵族食代集团董事长王永庆先生招待贵宾的知名私房料理。严选一头牛的第六至第八对肋骨这六块牛排。是以“一头牛仅供6客”的贵族食代牛排为招牌菜的中高价位直营连锁西餐厅，独具中国口味，全熟牛排，鲜嫩多汁，适合中国人口味，以菜色精致、好吃、服务好、风格高雅、管理专业着称。</p>
            <p>何谓经典，可能就是在品鉴无数美食后，其绝妙的滋味仍旧不能被替代。再次品味时，仍能激起内心的波澜与感动。如此经典，我们将为您重新诠释。全新的摆盘，搭配特制爽口的配菜，全熟风味，您不可辜负的舌尖美味。</p>
            <p>2003年登陆大陆，截至目前，贵族食代牛排在上海、北京、深圳、广州、南京、武汉、成都、重庆等地已经有40余家直营店，成为高端连锁牛排的领导品牌。</p>
        </dd>
    </dl>
</div>
<div class="news-wrap">
    <p class="news-tit">新闻资讯</p>
    <dl class="clearfix news-dl">
        <dt class="news-dt">
            <img src="img/pic2.jpg"/>
        </dt>
        <dd class="news-dd">
            <c:forEach var="u" items="${newsList}">
            <input type="hidden" name="id" value="${u.newId}">
            <a href="${pageContext.request.contextPath}/queryNews1.food?id=${u.newId}" class="news-link clearfix">
                <p class="link-tit">${u.newTitle}</p>
                <p class="link-time">${u.createTime}</p>
                </c:forEach>
            </a>
        </dd>
    </dl>
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
    //新品推荐table切换
    var nSpan = document.getElementById("newfood-span");
    var newspan = nSpan.querySelectorAll("span");
    var oUl  = document.getElementById("newfood-table");
    var uls = oUl.querySelectorAll("ul");
    var last=newspan[0];
    for(var i=0;i<newspan.length;i++){
        newspan[i].index=i;  //给每一个按钮添加一个自定义属性，存储的是他们对应的索引值；
        newspan[i].onclick=function(){
            last.style.background="url(img/icon.png)";  //把上一次点击对象的背景更换掉
            uls[last.index].style.display="none"; //上一个对应的div，让他隐藏
            this.style.background="url(img/icon-2.png)"; //给当前点击的按钮添加背景
            uls[this.index].style.display="block"; //当前点击按钮对应的div显示
            last=this; 	//把上一次点击的对象更新成当前点击的对象
        };
    };
</script>
</html>
