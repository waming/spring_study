<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header-section">
    <!--toggle button start-->
    <a class="toggle-btn"><i class="fa fa-bars"></i></a>
    <!--toggle button end-->
    <!--notification menu start -->
    <div class="menu-right">
        <ul class="notification-menu">
            <li>
                <a href="#" class="btn btn-default dropdown-toggle">
                    <img src="${pageContext.request.contextPath}images/photos/user-avatar.png" alt="" />
                    ${username}
                    <!-- <span class="caret"></span> -->
                </a>
            </li>

        </ul>
    </div>
    <!--notification menu end -->
</div>