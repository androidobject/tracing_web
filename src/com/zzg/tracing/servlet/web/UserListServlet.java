package com.zzg.tracing.servlet.web;

import com.zzg.tracing.entity.UserEntity;
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

@WebServlet(name = "UserListServlet", urlPatterns = {"/userlist"})
public class UserListServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "";
        String muser = request.getParameter("muser");

        if (!TextUtils.isEmpty(muser)) {
            UserService service = new UserService();

            boolean b = service.checkAdmin(muser);
            if (b) {
                List<UserEntity> userList = service.getUserList();

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
