package com.zzg.tracing.servlet;

import com.zzg.tracing.entity.LostInfoEntity;
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
import java.util.List;

/**
 * 我的收藏列表
 */

@WebServlet(name = "CollectListServlet", urlPatterns = {"/collect_list"})
public class CollectListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("user_id");

        String result = "";

        if (TextUtils.isEmpty(user_id)) {
            result = ResPonseUtils.responseJsonE("参数错误！");
        } else {

            CollectService service = new CollectService();

            int uid = Integer.parseInt(user_id);

            List<LostInfoEntity> collectList = service.getCollectList(uid);


            if (collectList != null) {
                result = ResPonseUtils.responseJsonS(collectList);
            } else {
                result = ResPonseUtils.responseJsonE("服务器异常！！");
            }
        }

        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();
    }


}
