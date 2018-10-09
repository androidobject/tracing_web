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


</head>
<body>
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">
            <form method="post" action="index.html">
                <h2 class="no-margins">寻亲网管理后台登录</h2>
                <input type="text" class="form-control uname" placeholder="用户名"/>
                <input type="password" class="form-control pword m-b" placeholder="密码"/>
                <button class="btn btn-success btn-block">登录</button>
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
