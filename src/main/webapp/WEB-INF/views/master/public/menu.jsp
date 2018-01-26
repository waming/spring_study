<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- left side start-->
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="${pageContext.request.contextPath}/manage">
            <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="">
        </a>
    </div>

    <div class="logo-icon text-center">
        <a href="${pageContext.request.contextPath}/manage"><img src="${pageContext.request.contextPath}/static/images/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->


    <div class="left-side-inner">

        <!-- visible to small devices only -->

        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="${pageContext.request.contextPath}/manage"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <li><a href="${pageContext.request.contextPath}/manage/user/index"><i class="fa fa-meh-o"></i> <span>用户管理</span></a></li>
            <li><a href="${pageContext.request.contextPath}/manage/logout"><i class="fa fa-sign-in"></i> <span>退出</span></a></li>
        </ul>
        <!--sidebar nav end-->

    </div>
</div>
<!-- left side end-->