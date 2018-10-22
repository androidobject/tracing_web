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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

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
                    for (var i in mlist) {
                        html += '<li>' + '<p class="m0">' + 'NO.' + (0+i) + '</p>' +
                            '丢失人：' + mlist[i].lost_name + '&nbsp;' + mlist[i].last_see_time + '<br>' +
                            '联系地址：' + mlist[i].contact_address + '</li>';
                    }
                    document.getElementById("composition").innerHTML = html;
                } else {
                    alert("服务器异常！")
                }

            }

        }
    </script>


</head>
<body onload="getCompostion()" bgcolor="#deb887">
<H1 align="center">寻亲记官网</H1>


<div id="composition"> 123</div>

</body>
</html>
