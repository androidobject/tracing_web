package com.zzg.tracing.utils;

import com.zzg.tracing.constant.Constans;
import com.zzg.tracing.entity.FileEntity;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB


    public static List<FileEntity> saveFile(HttpServletRequest request, String user_id, String type, String lost_people_id) throws Exception {
        List<FileEntity> mlist = new ArrayList<>();

        String path = Constans.getPath();

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        //处理乱码
        upload.setHeaderEncoding("UTF-8");

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录

        // 如果目录不存在则创建
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // 解析请求的内容提取文件数据
        List<FileItem> formItems = upload.parseRequest(request);
        if (formItems != null && formItems.size() > 0) {
            // 迭代表单数据
            for (FileItem item : formItems) {
                // 处理不在表单中的字段
                if (!item.isFormField()) {
                    FileEntity entity = new FileEntity();
                    long timeMillis = System.currentTimeMillis();
                    String fileName = timeMillis + new File(item.getName()).getName();
                    String filePath = path + File.separator + fileName;
                    File storeFile = new File(filePath);
                    // 在控制台输出文件的上传路径
                    System.out.println(filePath);
                    // 保存文件到硬盘
                    item.write(storeFile);
                    entity.setFile_type(type);
                    entity.setFile_url(Constans.realPath("file/" + fileName));
                    entity.setFile_abs_url("file/" + fileName);
                    entity.setLost_people_id(Integer.parseInt(lost_people_id));
                    entity.setUser_id(Integer.parseInt(user_id));
                    mlist.add(entity);
                    System.out.println("文件上传成功！");
                }
            }
        }

        return mlist;
    }

}