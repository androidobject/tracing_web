package com.zzg.tracing.servlet.api;

import com.zzg.tracing.entity.LostInfoEntity;
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
 * 我的发布信息查询
 */
@WebServlet(name = "MyIssuedServlet", urlPatterns = {"/myissued"})
public class MyIssuedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");

        String result = "";

        if (TextUtils.isEmpty(user_id)) {
            result = ResPonseUtils.responseJsonE("参数错误！");
        } else {
            IssuedService service = new IssuedService();
            int uid = Integer.parseInt(user_id);
            List<LostInfoEntity> lostInfoEntities = service.selectInfoByUid(uid);
            if(lostInfoEntities!=null){
                result=ResPonseUtils.responseJsonS(lostInfoEntities);
            }else{
                result=ResPonseUtils.responseJsonS("暂无发布的数据");
            }


        }
        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();


    }


}
