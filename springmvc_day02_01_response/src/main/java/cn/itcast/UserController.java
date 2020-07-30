package cn.itcast;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
