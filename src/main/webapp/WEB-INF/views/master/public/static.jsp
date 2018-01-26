<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/style-responsive.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/static/js/html5shiv.js"></script>
<script src="${pageContext.request.contextPath}/static/js/respond.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
        //select 判断选定
        $('select[data]').each(function(){
            var val = $(this).attr('data');
            $(this).val(val);
        });
    })
</script>