package com.zzg.tracing.servlet.api;

import com.zzg.tracing.entity.LostPeopleEntity;
import com.zzg.tracing.service.LostPeopleService;
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
 * 查询丢失人列表
 */
@WebServlet(name = "SelectLostsByIdServlet", urlPatterns = {"/SelectLostsById"})
public class SelectLostsByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String result = "";

        if (!TextUtils.isEmpty(user_id)) {
            LostPeopleService service = new LostPeopleService();

            int uid = Integer.parseInt(user_id);
            List<LostPeopleEntity> lostPeopleEntities = service.selectLostsById(uid);

            result = ResPonseUtils.responseJsonS(lostPeopleEntities);
        } else {
            result = ResPonseUtils.responseJsonE("参数错误");
        }

        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.close();


    }

}
