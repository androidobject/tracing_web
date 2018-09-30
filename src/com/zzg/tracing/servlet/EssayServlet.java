package com.zzg.tracing.servlet;

import com.zzg.tracing.entity.EssayEntity;
import com.zzg.tracing.service.EssayService;

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

/**
 * 获取文章列表
 */
@WebServlet(name = "EssayServlet", urlPatterns = {"/essay"})
public class EssayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");

        String result = "";
        if (TextUtils.isEmpty(user_id)) {
            result = ResPonseUtils.responseJsonE("参数有误");
        } else {
            EssayService service = new EssayService();
            List<EssayEntity> essayList = service.getEssayList(20);
            if (essayList != null) {
                result = ResPonseUtils.responseJsonS(essayList);
            } else {
                result = ResPonseUtils.responseJsonS("暂无相关文章推荐！");
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();


    }


}
