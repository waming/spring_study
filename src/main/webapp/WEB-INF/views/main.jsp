<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
</head>
<body>
当前用户:${username}
<c:if test="${username!=null}">
    <a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>
${message}
</body>
</html>
