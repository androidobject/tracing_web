package com.zzg.tracing.servlet;

import com.zzg.tracing.entity.CityEntity;
import com.zzg.tracing.service.CityService;
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
 * 获取城市列表
 */
@WebServlet(name = "CityListServlet", urlPatterns = {"/citylist"})
public class CityListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String result = "";

        if (TextUtils.isEmpty(user_id)) {
            result = ResPonseUtils.responseJsonE("参数错误");
        } else {
            CityService service = new CityService();
            List<CityEntity> cityList = service.getCityList();
            result = ResPonseUtils.responseJsonS(cityList);
        }

        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();

    }

}
