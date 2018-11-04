package com.zzg.tracing_manage.servlet;

import com.zzg.tracing.utils.ResPonseUtils;
import com.zzg.tracing.utils.TextUtils;
import com.zzg.tracing_manage.entity.UserModel;
import com.zzg.tracing_manage.service.UserMService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserListServlet", urlPatterns = {"/userlist"})
public class UserListServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "";
        String muser = request.getParameter("muser");

        if (!TextUtils.isEmpty(muser)) {
            UserMService service = new UserMService();

            boolean b = service.checkAdmin(muser);
            if (b) {
                List<UserModel> userList = service.getUserList();

                result = ResPonseUtils.responseJsonS(userList);
            } else {
                result = ResPonseUtils.responseJsonE("管理用户不存在！");
            }
        } else {
            result = ResPonseUtils.responseJsonE("参数错误");
        }

        PrintWriter writer = response.getWriter();

        writer.write(result);

        writer.close();

    }
}
