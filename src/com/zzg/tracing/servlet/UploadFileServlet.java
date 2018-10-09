package com.zzg.tracing.servlet;

import com.zzg.tracing.constant.Constans;
import com.zzg.tracing.utils.FileUtils;
import com.zzg.tracing.utils.ResPonseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        String result = "";


        List<String> mlist = FileUtils.saveFile(request);

        if (mlist != null) {
            result = ResPonseUtils.responseJsonS(mlist);
        } else {
            result = ResPonseUtils.responseJsonE("文件上传失败！");
        }

        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();
    }


}
