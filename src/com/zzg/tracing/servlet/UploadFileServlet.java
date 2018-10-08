package com.zzg.tracing.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 文件上传接口
 */
@WebServlet(name = "UploadFileServlet", urlPatterns = {"/upload"})
public class UploadFileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO ----

//        SmartUp


        PrintWriter writer = response.getWriter();
        writer.print("");
        writer.close();
    }


}
