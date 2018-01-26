<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 屏蔽tomcat 自带的 EL表达式 -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="public/static.jsp" />
    <title>首页管理</title>
    <!--dashboard calendar-->
    <link href="${pageContext.request.contextPath}/static/css/clndr.css" rel="stylesheet">
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <c:import url="public/menu.jsp" />
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <c:import url="public/header.jsp" />
        <!-- header section end-->

        <!--body wrapper start-->
        <div class="wrapper">首页管理</div>
        <!--body wrapper end-->
    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<c:import url="public/footer.jsp" />
</body>
</html>