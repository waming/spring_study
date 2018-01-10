<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 屏蔽tomcat 自带的 EL表达式 -->
<%@ page isELIgnored="false" %>
<html>
<body>
<h1>Hello World!</h1>
<h2>${username}</h2>

<br>
<h2><c:out value="${message}" /></h2>

</body>
</html>
