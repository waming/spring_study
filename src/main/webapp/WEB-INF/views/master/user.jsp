<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2018/1/26
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 屏蔽tomcat 自带的 EL表达式 -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="public/static.jsp" />
    <title>会员管理</title>
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
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            会员管理
                            <span class="tools pull-right">
                    <button class="btn btn-default" onclick="location.href='/user/add'">添加会员</button>
                 </span>
                        </header>
                        <div class="panel-body">
                            <div class="adv-table">
                                <table  class="display table table-bordered table-striped" id="dynamic-table">
                                    <thead>
                                    <tr>
                                        <th>用户名称</th>
                                        <th>单位名称</th>
                                        <th>手机</th>
                                        <th>加入时间</th>
                                        <th>企业状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items= "${users}" var="vo">
                                    <tr class="gradeA">
                                        <td>${vo.username}</td>
                                        <td>${vo.company_name}</td>
                                        <td>${vo.telephone}</td>
                                        <td>${vo.create_time}</td>
                                        <td><c:choose><c:when test="${vo.check_status == 1}">已审核</c:when><c:otherwise>未审核</c:otherwise></c:choose></td>
                                        <td data_id="">
                                            <button class="btn btn-primary  btn-sm" id="offUser">停用</button>
                                            <button class="btn btn-success  btn-sm" id="onUser">启用</button>
                                            <a href="/user/edit?id=" class="btn btn-default btn-sm">编辑</a>
                                            <a href="#pwdModal" data-toggle="modal" class="btn btn-warning  btn-sm" data-userid="">改密</a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer>
            牛能危废管理系统
        </footer>
        <!--footer section end-->

        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="pwdModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">修改密码</h4>
                    </div>
                    <div class="modal-body">
                        <form id="pwdForm">
                            <input type="hidden" name="u_id" id="userid">
                            <input class="form-control col-lg-3" id="password" name="password" type="text"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-success" id="savePwd">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- modal -->
    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<c:import url="public/footer.jsp" />
<script type="text/javascript">
    $(function() {
        $('#pwdModal').on('show.bs.modal',
            function(e) {
                var btn = $(e.relatedTarget);
                var userid = btn.data("userid");
                $("#userid").val(userid);
            });

        $("#savePwd").click(function() {
            var formData = $("#pwdForm").serialize();
            $.post('/user/resetPwd',formData,function(data) {
                if(data.code != 0){
                    alert(data.message);
                }else{
                    $("#password").val('');
                    $("#pwdModal").modal('hide');
                }
            },'json')
        });


        //停用
        $('button#offUser').click(function(){
            if (!confirm("确定要停用该会员吗？")) {
                return false;
            }
            var id = $(this).parent().attr('data_id');
            $.post('/user/offUser', {id:id}, function(data){
                if (data.code == 0) {
                    location.reload();
                } else {
                    alert(data.message);
                }
            }, 'json');
        })



        //启用
        $('button#onUser').click(function(){
            if (!confirm("确定要启用该会员吗？")) {
                return false;
            }
            var id = $(this).parent().attr('data_id');
            $.post('/user/onUser', {id:id}, function(data){
                if (data.code == 0) {
                    location.reload();
                } else {
                    alert(data.message);
                }
            }, 'json');
        })
    });
</script>
</body>
</html>

