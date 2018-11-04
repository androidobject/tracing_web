getUserList();

function getUserList() {

    var data = {muser: "1", page: 1};
    $.ajax({
        type: "POST",
        url: "/userlist",
        data: data,
        async: true,
        cache: false,
        dataType: 'text',
        error: error,
        success: sucess,
    });

    //请求错误
    function error() {
        alert("请求错误！");
    }

    function sucess(res) {
        var jsData = JSON.parse(res);
        if (jsData.status == 1) {
            //请求成功
            var mlist = jsData.data;

            var html = '';
            html += '<table border="1" width="100%" margin="0">' +
                '<tr>' +
                '<th>ID</th>' +
                '<th>用户名</th>' +
                '<th>密码</th>' +
                '<th>微信</th>' +
                '<th>注册时间</th>' +
                '<th>最后登录时间</th>' +
                '<th>操作</th>' +
                '</tr>';
            for (var i in mlist) {
                html += '<tr>' +
                    '<td>' + mlist[i].id + '</td>'
               + '<td>' + mlist[i].user_name + '</td>'
                +'<td>' + mlist[i].password + '</td>'
                +'<td>' + mlist[i].weixin + '</td>'
                +'<td>' + mlist[i].create_time + '</td>'
                +'<td>' + mlist[i].last_login_time + '</td>'
                +'<td><input type="button" value="删除"> <input type="button" value="禁用"></td>'
                +'</tr>'

            }

            html += '</table>';
            document.getElementById("user_list").innerHTML = html;
        } else {
            alert("服务器异常！")
        }

    }


}
