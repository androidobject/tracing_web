<%@ page import="com.zzg.tracing.utils.TextUtils" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/22/022
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>寻亲网管理后台</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/css/page.css"/>
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/m_index.js"></script>
</head>
<body>

<%
    String user = (String) session.getAttribute("user");
//    if (TextUtils.isEmpty(user)) {
//        response.sendRedirect("m_login.jsp");
//    }
%>

<div class="left">
    <div class="bigTitle">寻亲网管理后台</div>
    <div class="lines">
        <div onclick="pageClick(this)" id="first_one" class="active"><img src="/img/icon-1.png"/>儿童管理</div>
        <div onclick="pageClick(this)"><img src="/img/icon-2.png"/>用户管理</div>
        <div onclick="pageClick(this)"><img src="/img/icon-3.png"/>文章管理</div>
        <div onclick="pageClick(this)"><img src="/img/icon-4.png"/>发布管理</div>
        <div onclick="pageClick(this)"><img src="/img/icon-5.png"/>信息管理</div>
    </div>
</div>
<div class="top">
    <div class="leftTiyle" id="flTitle">业务人员管理</div>
    <div class="thisUser" id="curent_uesr">当前用户：<%=user%>
    </div>
</div>
<div class="content" id="content">

</div>

</body>
</html>
