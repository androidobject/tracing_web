package com.zzg.tracing.servlet.api;

import com.zzg.tracing.entity.CollectEntity;
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
 * 收藏丢失信息
 */
@WebServlet(name = "CollectServlet", urlPatterns = {"/collect_lost"})
public class CollectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lost_info_id = request.getParameter("lost_info_id");
        String collect_by_phone = request.getParameter("collect_by_phone");
        String collect_user_id = request.getParameter("collect_user_id");
        String result = "";

        if (TextUtils.isEmpty(lost_info_id) || TextUtils.isEmpty(collect_by_phone) || TextUtils.isEmpty(collect_user_id)) {
            result = ResPonseUtils.responseJsonE("参数错误！");
        } else {

            CollectService service = new CollectService();
            CollectEntity entity = new CollectEntity();
            try {
                entity.setLost_info_id(Integer.parseInt(lost_info_id));
                entity.setCollect_by_phone(collect_by_phone);
                entity.setCollect_user_id(Integer.parseInt(collect_user_id));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                boolean collect = service.collect(entity);

                if (collect) {
                    result = ResPonseUtils.responseJsonS("收藏成功！");
                } else {
                    result = ResPonseUtils.responseJsonE("服务器异常！");
                }

            } catch (RuntimeException e) {
                String message = e.getMessage();
                result = ResPonseUtils.responseJsonE(message);
            }

        }
        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();


    }


}
