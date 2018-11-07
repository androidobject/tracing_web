package com.zzg.tracing.servlet.web;

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
 * 查询所有的丢失儿童
 */

@WebServlet(name = "SelectAllLostsServlet", urlPatterns = {"/selectAllLosts"})
public class SelectAllLostsServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String result = "";

        LostPeopleService service = new LostPeopleService();

        List<LostPeopleEntity> lostPeopleEntities = service.selectAllLosts();

        result = ResPonseUtils.responseJsonS(lostPeopleEntities);

        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.close();

    }

}
