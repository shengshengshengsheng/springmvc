package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:控制器类
 *
 * @author xuqiangsheng
 * @date 2020/7/29 8:13
 */
@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springMvc");
        return "success";
    }
    @RequestMapping(path = "/requestMapping")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
