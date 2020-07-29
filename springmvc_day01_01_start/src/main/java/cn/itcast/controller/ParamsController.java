package cn.itcast.controller;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:Administrator
 * @date:2020/7/29
 * @description:
 */
@Controller
@RequestMapping("/param")
public class ParamsController {

    /*@RequestMapping("/testParams")
    public String testParams(String username){
        System.out.println("testParams"+username);
        return "success";
    }*/

    @RequestMapping("/saveAccount")
    public String testSaveAccount(Account account){
        System.out.println("saveAccount方法执行了");
        System.out.println(account);
        return "success";
    }
}
