package com.zzg.tracing_web.servlet;

import com.zzg.tracing.entity.PageEntity;
import com.zzg.tracing.service.IssuedService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WLostInfoServlet",urlPatterns = {"/w_lostinfo"})
public class WLostInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IssuedService service = new IssuedService();
        PageEntity pageEntity = service.selectLostList("北京", "1");

//商品集合准备好
        //将数据存储到request域转发给product_list.js进行显示
        request.setAttribute("pageEntity", pageEntity);
        ServletContext servletContext = getServletContext();
        System.out.println("servletContext=="+servletContext);
        request.getRequestDispatcher(getServletContext()+"/index.jsp").forward(request, response);

        response.getWriter().write("444444444444444444444444444444");

    }

}
