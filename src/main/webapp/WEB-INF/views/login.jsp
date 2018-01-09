<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名:<input type="text" name="username" /><br>
    密码:<input type="text" name="userpass" /><br>
    <input type="submit" value="登录" />
</form>
</body>
</html>
