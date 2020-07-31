package cn.itcast.controller;

import cn.itcast.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author:Administrator
 * @date:2020/7/30
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了....");
        //模拟从数据库中查询数据
        User user = new User();
        user.setUsername("梅梅");
        user.setPassword("123");
        user.setAge(10);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 请求转发一次
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了....");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath()+"WEB-INF/pages/xxx.jsp");
        //直接进行响应
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("hello");
        return;
    }

    @RequestMapping(value = "/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了....");
        //请求转发
//        return "forward:WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了....");
        System.out.println(user);
        user.setAge(1000);
        user.setPassword("1114444");
        return user;
    }

    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1执行了");
        //使用fileupload组件完成文件上传
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(realPath);
        if(!file.exists()){
            //创建该文件夹
            boolean mkdirs = file.mkdirs();
            System.out.println("mkdirs："+mkdirs);
            System.out.println(realPath);
        }
        //解析requests对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            //进行判断,当前item是否是上传文件项
            if(fileItem.isFormField()){
                //说明是一个普通表单项
            }else {
                //说明上传文件项
                //获取上传文件的名称
                String name = fileItem.getName();
                String replace = UUID.randomUUID().toString().replace(".", "");
                name = replace+"_"+name;
                //完成文件上传
                fileItem.write(new File(realPath,name));
                //删除临时文件
                fileItem.delete();
            }
        }
        System.out.println("文件上传");
        return "success";
    }

    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("fileUpload2执行了");
        //使用fileupload组件完成文件上传
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(realPath);
        if(!file.exists()){
            //创建该文件夹
            boolean mkdirs = file.mkdirs();
            System.out.println("mkdirs："+mkdirs);
            System.out.println(realPath);
        }
        //说明上传文件项
        //获取上传文件的名称
        String name = upload.getOriginalFilename();

        String replace = UUID.randomUUID().toString().replace(".", "");
        name = replace + "_" + name;
        //完成文件上传
        upload.transferTo(new File(realPath, name));
        System.out.println("文件上传");
        return "success";
    }

    /**
     * 跨服务器上传
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("fileUpload3执行了");
        //定义上传的文件服务器的路径
        String path = "http://localhost:9090/uploads/";


        //说明上传文件项
        //获取上传文件的名称
        String name = upload.getOriginalFilename();

        String replace = UUID.randomUUID().toString().replace(".", "");
        name = replace + "_" + name;
        //完成文件上传 跨服务器上传

        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource resource = client.resource(path + name);
        //上传文件
        resource.put(upload.getBytes());

        System.out.println("文件上传");
        return "success";
    }
}
