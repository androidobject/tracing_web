<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/9/009
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寻亲网管理后台登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <%--引用css样式--%>
    <link href="/css/style.css" type="text/css" rel="stylesheet">
    <link href="/css/login.css" type="text/css" rel="stylesheet">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">

        function check() {

            var unameU = document.getElementById("uname").value.trim();
            var unameP = document.getElementById("pword").value.trim();

            if (unameU == null || unameU == "") {
                alert("请输入用户名！");
                return false;
            } else if (unameP == null || unameP == "") {
                alert("请输入密码！");
                return false;
            }

            //ajax 验证登录
            var data = {uname: unameU, pword: unameP};

            $.ajax({
                type: "POST",
                url: "/mLogin.dao",
                data: data,
                async: true,
                cache: false,
                dataType: 'text',
                success: function (msg) {
                    if ("登录成功" == msg) {
                        window.location.href = "/manage/m_index.jsp";
                    } else {
                        alert(msg);
                    }
                }

            });

        }

    </script>


</head>
<body>
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">
            <form method="post" action="" id="login_form">
                <h2 class="no-margins">寻亲网管理后台登录</h2>
                <input type="text" id="uname" name="uname" class="form-control" placeholder="用户名" maxlength="20"/>
                <input type="password" id="pword" name="pword" class="form-control m-b" placeholder="密码"
                       maxlength="20"/>
                <button type="button" class="btn" onclick="return check()">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 寻亲网开发团队 copyright © 2018-2038
        </div>
    </div>
</div>

</body>
</html>
