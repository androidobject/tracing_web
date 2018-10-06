package com.zzg.tracing.servlet;

import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.entity.PageEntity;
import com.zzg.tracing.service.IssuedService;
import com.zzg.tracing.service.UserService;
import com.zzg.tracing.utils.ResPonseUtils;
import com.zzg.tracing.utils.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SelectLostInfoServlet", urlPatterns = {"/select_lost_info"})
public class SelectLostInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("user_id");
        String area = request.getParameter("area");
        String page = request.getParameter("page");

        String result = "";
        if (TextUtils.isEmpty(user_id) || TextUtils.isEmpty(area) || TextUtils.isEmpty(page)) {
            result = ResPonseUtils.responseJsonE("参数有误");
        } else {
            //检查用户是否存在

            UserService userService = new UserService();
            boolean b = userService.checkUID(user_id);

            if (b) {
                IssuedService service = new IssuedService();
                PageEntity pageEntity = null;
                try {
                    pageEntity = service.selectLostList(area, page);

                    if (pageEntity != null && pageEntity.getMlist() != null) {
                        result = ResPonseUtils.responseJsonS(pageEntity);
                    } else {
                        result = ResPonseUtils.responseJsonS("该地区暂无发布丢失儿童信息！");
                    }
                } catch (Exception e) {
                    result = ResPonseUtils.responseJsonE("超出总页数！");
                }


            } else {
                result = ResPonseUtils.responseJsonE("该账号异常、或已被冻结、请联系管理员！");
            }


        }

        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();


    }


}
