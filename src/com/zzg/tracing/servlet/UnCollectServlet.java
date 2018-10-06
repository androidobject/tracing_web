package com.zzg.tracing.servlet;

import com.zzg.tracing.service.CollectService;
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
 * 取消收藏信息
 */

@WebServlet(name = "UnCollectServlet", urlPatterns = {"/uncollect_lost"})
public class UnCollectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lost_info_id = request.getParameter("lost_info_id");
        String collect_user_id = request.getParameter("collect_user_id");

        String result = "";

        if (TextUtils.isEmpty(lost_info_id) || TextUtils.isEmpty(collect_user_id)) {
            result = ResPonseUtils.responseJsonE("参数错误！");
        } else {

            CollectService service = new CollectService();


            try {
                int lost_id = Integer.parseInt(lost_info_id);
                int user_id = Integer.parseInt(collect_user_id);
                boolean b = service.unCollect(lost_id, user_id);
                if (b) {
                    result = ResPonseUtils.responseJsonS("success");
                } else {
                    result = ResPonseUtils.responseJsonE("服务器异常");
                }
            } catch (NumberFormatException e) {
                result = ResPonseUtils.responseJsonE("参数错误！");
            } catch (RuntimeException e) {
                result = ResPonseUtils.responseJsonE(e.getMessage());
            }

        }

        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();

    }
}
