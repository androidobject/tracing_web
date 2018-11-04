<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/27/027
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>寻亲记官网</title>
    <link rel="icon" href="img/favicon.png" mce_href="img/favicon.png" type="image/x-icon">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>

    <script>

        function getCompostion() {

            var data = {user_id: "3", area: "全国", page: "1"};
            $.ajax({
                type: "POST",
                url: "/select_lost_info",
                data: data,
                async: true,
                cache: false,
                dataType: 'text',
                error: error,
                success: sucess,
            });

            //请求错误
            function error() {
                alert("请求错误！")

            }

            function sucess(res) {

                var jsData = JSON.parse(res);
                if (jsData.status == 1) {
                    //请求成功
                    var mlist = jsData.data.mlist;
                    var totalPagen = jsData.data.totalPage;
                    console.log(totalPagen);
                    var html = '';
                    html += '<table border="1" width="100%" height="50%" margin="0">';
                    for (var i in mlist) {
                        if (i == 0) {
                            //第一个单行
                            html += '  <tr>' + '<td colspan=3>' +
                                '丢失人：' + mlist[i].lost_name + '&nbsp; 最后一次见面时间：' + mlist[i].last_see_time + '<br>' +
                                '性别：' + mlist[i].lost_sex + '<br>' +
                                '年龄：' + mlist[i].lost_age + '<br>' +
                                '发布时间：' + mlist[i].create_time + '<br>' +
                                '联系地址：' + mlist[i].contact_address + '<br>' +
                                '联系人：' + mlist[i].contact_name + '<br>' +
                                '丢失地区：' + mlist[i].lost_area + '<br>' +
                                '查看次数：' + mlist[i].look_time + '  ' +
                                '评论次数：' + mlist[i].commit_time + '   ' +
                                '收藏次数：' + mlist[i].collect_time + '   ' + '<br>' +
                                '</li></td></tr>'
                        } else {
                            if (i % 3 == 1) {
                                console.log(i);
                                html += '<tr>'
                            }
                            html += '<td>' +
                                '丢失人：' + mlist[i].lost_name + '&nbsp;最后一次见面时间：' + mlist[i].last_see_time + '<br>' +
                                '性别：' + mlist[i].lost_sex + '<br>' +
                                '年龄：' + mlist[i].lost_age + '<br>' +
                                '发布时间：' + mlist[i].create_time + '<br>' +
                                '联系地址：' + mlist[i].contact_address + '<br>' +
                                '联系人：' + mlist[i].contact_name + '<br>' +
                                '丢失地区：' + mlist[i].lost_area + '<br>' +
                                '查看次数：' + mlist[i].look_time + '  ' +
                                '评论次数：' + mlist[i].commit_time + '   ' +
                                '收藏次数：' + mlist[i].collect_time + '   ' + '<br>' +
                                '</li></td>'

                            if (i % 3 == 0) {
                                html += '</tr>'
                            }


                        }

                    }
                    html += '</table>';

                    document.getElementById("composition").innerHTML = html;
                } else {
                    alert("服务器异常！")
                }

            }

        }
    </script>

</head>
<body onload="getCompostion()" bgcolor="#a9a9a9">
<H1 align="center">寻亲记官网</H1>
<a href="manage/m_login.jsp">管理员登录</a>
<div id="composition"></div>


</body>

<footer class="myfooter">
    <div class="copyright" position:relative>
        <p><img src="/img/favicon.png"/>Copyright 2018&copy; 北京寻亲记个人开发小组</p>
    </div>
</footer>


</html>
