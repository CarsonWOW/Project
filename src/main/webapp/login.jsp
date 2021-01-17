<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <script>


        var regTest = /\S/;
        //这个是我封装的
        var $ =function(sbq){
            return document.getElementById(sbq);
        }
        function login() {
            //获取用户名
            var sbqUname = document.getElementById("sbqUname").value;
            //获取密码
            var pwd = document.getElementById("pwd").value;
            if(!regTest.test(sbqUname)){
                document.getElementById("sbqUnameErr").innerHTML="用户名不能为空"
                $("sbqUnameErr").style.color="red";
                return false;
            }else{
                $("sbqUnameErr").innerHTML="正确";
                $("sbqUnameErr").style.color="green";
            }
            if(pwd==''|| pwd == null){
                $("pwdErr").innerHTML="密码不能为空";
                $("pwdErr").className="red";
                return false;
             }/*else if(pwd.length<11){
                 $("pwdErr").innerHTML="密码不能小于11位";
                 $("pwdErr").className="red";
                 return false;
             }*/
            if(isNaN(pwd)){
                $("pwdErr").innerHTML="密码格式不正确，只能是数字";
                $("pwdErr").className="red";
                return false;
            }else{
                $("pwdErr").innerHTML="正确";
                $("pwdErr").className="green";
            }
            return true;
        }

    </script>
    <%--<script>
        function login() {
            //这里的代码就是js的表单验证，大家自己完成。
            return true;
        }
    </script>--%>
</head>

<body>
        <h1> 用户登陆</h1>
        <form action="${pageContext.request.contextPath}/login.user" method="post" onsubmit="return login();">
                用户名：<input type="text" id="sbqUname" name="sbqUname" />
                <span id="sbqUnameErr"></span> <br />
                密码：<input type="password" id="pwd" name="pwd"  />
                <span id="pwdErr"></span><br />
                   <%-- 用户名：<input type="text"  name="sbqUname" /> <br />
                    密码： <input type="password" name="pwd"  /> <br />--%>
                   <input type="submit" value="提交" />

                   <%--<tr>
                       <td class="field">用户名：</td>
                       <td><input type="text" class="text" name="userName"  /></td>
                   </tr>
                   <tr>
                       <td class="field">密码：</td>
                       <td><input type="text" class="text" name="pwd"  /></td>
                   </tr>
                <input type="submit" value="提交" />--%>
        </form>
</body>
</html>

