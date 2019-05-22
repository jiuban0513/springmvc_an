package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload")
    public void upload(@RequestParam(value = "picture")MultipartFile multipartFile){
        System.out.println(multipartFile.getOriginalFilename());
    }

    @RequestMapping("/up")
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }

    @RequestMapping(value = "/upload2")
    public void upload(HttpServletRequest req, HttpServletResponse resp){
        // 验证请求是否满足要求（post 请求 / enctype 是否以multipart打头
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        // 如果不满足要求就立即结束对该请求的处理
        if (!isMultipart) {
            return;
        }
        try {
            // FileItem 是表单中的每一个元素的封装
            // 创建一个 FileItem 的工厂类
            FileItemFactory factory = new DiskFileItemFactory();
            // 创建一个文件上传处理器（装饰设计模式）
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem fileItem : items) {
                // 判断空间是否是普通控件
                if (fileItem.isFormField()) {
                    // 普通控件
                } else {
                    // 上传控件
                    // 将上传的文件保存到服务器
                    fileItem.write(new File("C:/", "testImg.jpg"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
