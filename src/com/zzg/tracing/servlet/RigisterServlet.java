package com.zzg.tracing.servlet;

import com.zzg.tracing.service.RigisterService;
import com.zzg.tracing.utils.ResPonseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注册接口
 */

@WebServlet(name = "RigisterServlet", urlPatterns = {"/rigister"})
public class RigisterServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rigister_by_phone = request.getParameter("rigister_by_phone");

        String result = "";
        if ("".equals(username) || "".equals(password) || username == null
                || password == null || rigister_by_phone == null || rigister_by_phone == null) {
            result = ResPonseUtils.responseJsonE("参数有误");
        } else {
            RigisterService service = new RigisterService();
            String msg = service.rigister(username, password,rigister_by_phone);
            if (msg.equals("ok")) {
                result = ResPonseUtils.responseJsonS("");
            } else {
                result = ResPonseUtils.responseJsonE(msg);
            }

        }

        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();
    }
}
