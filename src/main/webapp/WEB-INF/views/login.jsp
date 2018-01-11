<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <c:import url="master/public/static.jsp" />
    <title>后台登录</title>
    <meta name="keywords" content="H-ui.admin v2.3,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v2.3，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form id="login" class="form form-horizontal" method="post">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input name="username" type="text" placeholder="账户" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input name="userpass" type="password" placeholder="密码" class="input-text size-L">
                </div>
            </div>
            <!--       <div class="row cl">
                    <div class="formControls col-xs-8 col-xs-offset-3">
                      <input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
                      <img src="images/VerifyCode.aspx.png"> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>
                  </div> -->
            <!--       <div class="row cl">
                    <div class="formControls col-xs-8 col-xs-offset-3">
                      <label for="online">
                        <input type="checkbox" name="online" id="online" value="">
                        使我保持登录状态</label>
                    </div>
                  </div> -->
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input id="btn_login" name="" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="footer">Copyright 易沙网络</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.js"></script>
<script>
    $(function () {
        $("#btn_login").click(function(){
            var str = '';
            var formData = $("#login").serialize();
            $.post('${pageContext.request.contextPath}/dologin/',formData , function(data){
                if(data.code != 0){
                    alert(data.message);
                }else{
                    window.location.href="${pageContext.request.contextPath}/user/index";
                }
            },"json");
        });
    });
</script>
</body>
</html>