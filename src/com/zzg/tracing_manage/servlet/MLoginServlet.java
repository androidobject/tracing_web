package com.zzg.tracing_manage.servlet;

import com.mysql.cj.Session;
import com.zzg.tracing_manage.service.LoginMService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MLoginServlet", urlPatterns = {"/mLogin.dao"})
public class MLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String pword = request.getParameter("pword");

        LoginMService service = new LoginMService();
        String result = service.loginM(uname, pword);

        System.out.println("result===" + result);
//        if (request.equals("登录成功")) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", uname);
//        }
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.close();


    }

}
