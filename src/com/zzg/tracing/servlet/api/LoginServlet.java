package com.zzg.tracing.servlet.api;

import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.service.LoginService;
import com.zzg.tracing.utils.ResPonseUtils;
import com.zzg.tracing.utils.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录接口
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = "";
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            result = ResPonseUtils.responseJsonE("参数有误");
        } else {
            LoginService service = new LoginService();
            String loginMsg = service.login(username, password);
            if (loginMsg.equals("ok")) {
                UserEntity entity = service.searchUser(username);
                result = ResPonseUtils.responseJsonS(entity);

            } else {
                result = ResPonseUtils.responseJsonE(loginMsg);
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();
    }
}
