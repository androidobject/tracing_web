function pageonLoad() {
    $('div#content').load("m_child.jsp");
}

function pageClick(k) {
    $(k).parent().find("div").removeClass("active");
    $(k).addClass("active");
    $("#flTitle").text($(k).text());

    var type = $(k).text();
    if (type == '儿童管理') {
        $('div#content').load("m_child.jsp");
        // $('div#content').innerHTML= '<object type="text/html" data="m_child.jsp" width="100%" height="100%"></object>';
    } else if (type == '用户管理') {
        $('div#content').load("m_user.jsp");
        // $('div#content').innerHTML= '<object type="text/html" data="m_user.jsp" width="100%" height="100%"></object>';
    } else if (type == '文章管理') {
        $('div#content').load("m_essay.jsp");
    } else if (type == '发布管理') {
        $('div#content').load("m_send.jsp");
    } else if (type == '信息管理') {
        $('div#content').load("m_infolist.jsp");
    }
}
