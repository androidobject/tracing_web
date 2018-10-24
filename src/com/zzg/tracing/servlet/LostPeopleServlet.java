package com.zzg.tracing.servlet;

import com.alibaba.fastjson.JSON;
import com.zzg.tracing.entity.LostInfoEntity;
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

/*
丢失儿童信息
 */
@WebServlet(name = "LostPeopleServlet", urlPatterns = {"/addLostPeople"})
public class LostPeopleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String outPt = "";

        String data = request.getParameter("data");

        if (!TextUtils.isEmpty(data)) {
            LostPeopleEntity lostInfoEntity = JSON.parseObject(data, LostPeopleEntity.class);

            LostPeopleService service = new LostPeopleService();
            String result = service.addLostPeople(lostInfoEntity);

            if ("添加信息成功".equals(result)) {
                outPt = ResPonseUtils.responseJsonS(result);
            } else {
                outPt = ResPonseUtils.responseJsonE(result);
            }

        } else {
            outPt = ResPonseUtils.responseJsonE("参数错误！");
        }

        PrintWriter writer = response.getWriter();
        writer.write(outPt);
        writer.close();


    }


}
