package com.zzg.tracing.servlet.api;

import com.alibaba.fastjson.JSON;
import com.zzg.tracing.entity.EssayEntity;
import com.zzg.tracing.entity.LostInfoEntity;
import com.zzg.tracing.service.EssayService;
import com.zzg.tracing.service.IssuedService;
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
 * 发布失踪信息
 */

@WebServlet(name = "IssuedServlet", urlPatterns = {"/issued"})
public class IssuedServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");
        LostInfoEntity lostInfoEntity = null;

        try {
            lostInfoEntity = JSON.parseObject(data, LostInfoEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = "";
        if (TextUtils.isEmpty(data) || lostInfoEntity == null || TextUtils.isEmpty(lostInfoEntity.getSend_id())) {
            result = ResPonseUtils.responseJsonE("参数有误");
        } else {

            IssuedService service = new IssuedService();
            boolean b = service.saveLostInfo(lostInfoEntity);
            if (b) {
                result= ResPonseUtils.responseJsonS("sucess");
            } else {
                result = ResPonseUtils.responseJsonE("服务器异常");
            }

        }

        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();
    }
}
