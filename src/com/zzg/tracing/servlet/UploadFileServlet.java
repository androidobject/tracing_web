package com.zzg.tracing.servlet;

import com.zzg.tracing.constant.Constans;
import com.zzg.tracing.entity.FileEntity;
import com.zzg.tracing.service.FileService;
import com.zzg.tracing.utils.FileUtils;
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
 * 文件上传接口
 */
@WebServlet(name = "UploadFileServlet", urlPatterns = {"/upload"})
public class UploadFileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String result = "";

        List<FileEntity> mlist = null;

        String user_id = request.getParameter("user_id");
        String type = request.getParameter("type");


//        if (!TextUtils.isEmpty(user_id) && !TextUtils.isEmpty(type)) {
        try {
            mlist = FileUtils.saveFile(request);
            if (mlist.size() > 0) {
                FileService service = new FileService();

                boolean b = service.saveFileToSql(mlist);
                if (b) {

                    if (mlist != null) {
                        result = ResPonseUtils.responseJsonS(mlist);
                    } else {
                        result = ResPonseUtils.responseJsonE("文件上传失败！");
                    }

                } else {
                    result = ResPonseUtils.responseJsonE("服务器异常！");
                }
            } else {
                result = ResPonseUtils.responseJsonE("未发现文件！");
            }

        } catch (Exception e) {
            result = ResPonseUtils.responseJsonE(e.getMessage());
        }

//        } else {
//            result = ResPonseUtils.responseJsonE("参数错误！");
//        }
        PrintWriter writer = response.getWriter();
        writer.print(result);
        writer.close();
    }


}
