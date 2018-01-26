<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="master/public/static.jsp" />
    <title>淘宝客--首页</title>
</head>
<body class="login-body">
<div class="container">
    <form class="form-signin" id="loginFrom">
        <div class="form-signin-heading text-center">
            <!-- <h1 class="sign-title">登 录</h1>-->
            <img src="${pageContext.request.contextPath}/static/images/login-logo.png" alt=""/> </div>
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="用户名" autofocus name="username" onkeydown=KeyDown()>
            <input type="password" class="form-control" placeholder="密码" name="userpass" onkeydown=KeyDown()>
            <button class="btn btn-lg btn-login btn-block" type="button" onclick="userLogin()"> 登陆<!-- <i class="fa fa-check"></i>  --></button>
        </div>
    </form>
</div>
<!-- Placed js at the end of the document so the pages load faster -->
<c:import url="master/public/footer.jsp" />
</body>
<script type="text/javascript">
    function userLogin() {
        var formData = $("#loginFrom").serialize();
        $.post('${pageContext.request.contextPath}/dologin/', formData , function(data){
            if(data.code != 0){
                alert(data.message);
            }else{
                window.location.href="${pageContext.request.contextPath}/manage/index";
            }
        },"json");
    }
    //监听回车键
    function KeyDown()
    {
        if (event.keyCode == 13)
        {
            event.returnValue=false;
            event.cancel = true;
            userLogin();
        }
    }
</script>
</html>
