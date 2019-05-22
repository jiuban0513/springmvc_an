package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RequestController {


    /**
     * 方式一：使用 Servlet 原生的 API 实现
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
//    @RequestMapping(value = "/param")
    public String handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        return "form_test";
    }


    /**
     * 方式二：使用同名匹配规则
     * 缺点： 这样又会和前台产生很强的耦合，这是我们不希望的
     * 解决： 使用 @RequestParam("前台参数名") 来注入：
     * @param username
     * @param password
     * @return
     */
//    @RequestMapping(value = "/param")
    public String handleRequest2(String username , String password){
        System.out.println(username);
        System.out.println(password);
        return "form_test";
    }


    /**
     * 方式三：使用 @RequestParam("前台参数名") 来注入;value - 前台参数名；required - 是否必传参数；defaultvalue - 默认值；
     * @param username
     * @param password
     * @return
     */
//    @RequestMapping(value = "/param")
    public String handleRequest3(@RequestParam(value = "username",required = true) String username ,
                                       @RequestParam(value = "password",required = false) String password){
        System.out.println(username);
        System.out.println(password);
        return "form_test";
    }

    /**
     * 方式四：使用模型传参
     * @param user
     * @return
     */
    @RequestMapping(value = "/param")
    public String handleRequest4(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "form_test";
    }
}
