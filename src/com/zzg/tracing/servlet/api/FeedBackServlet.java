package com.zzg.tracing.servlet.api;

import com.zzg.tracing.entity.FeedBackEntity;
import com.zzg.tracing.entity.UserEntity;
import com.zzg.tracing.service.FeedBackService;
import com.zzg.tracing.service.LoginService;
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
 * 意见反馈接口
 */

@WebServlet(name = "FeedBackServlet", urlPatterns = {"/feedback"})
public class FeedBackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        String user_id = request.getParameter("user_id");
        String contact = request.getParameter("contact");
        String feedback_by_phone = request.getParameter("feedback_by_phone");


        String result = "";
        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(user_id)  || TextUtils.isEmpty(feedback_by_phone)) {
            result = ResPonseUtils.responseJsonE("参数有误");
        } else {
            FeedBackService service = new FeedBackService();
            FeedBackEntity entity = new FeedBackEntity();
            entity.setContent(content);
            entity.setUser_id(user_id);
            entity.setContact(contact);
            entity.setFeedback_by_phone(feedback_by_phone);

            String msg = service.feedback(entity);

            if (msg.equals("ok")) {
                result = ResPonseUtils.responseJsonS("sucess");
            } else {
                result = ResPonseUtils.responseJsonE(msg);
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println(result);
        writer.close();


    }


}
