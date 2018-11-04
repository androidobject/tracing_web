function pageClick(k) {
    $(k).parent().find("div").removeClass("active");
    $(k).addClass("active");
    $("#flTitle").text($(k).text());

    var type = $(k).text();
    if (type == '儿童管理') {

        document.getElementById("content").innerText = '儿童管理';
    } else if (type == '用户管理') {

        document.getElementById("content").innerHTML ='+ <jsp:include page="/m_login.jsp">+';
    } else if (type == '文章管理') {

    } else if (type == '发布管理') {

    } else if (type == '信息管理') {

    }
    // document.getElementById("content").innerText = type;


}
