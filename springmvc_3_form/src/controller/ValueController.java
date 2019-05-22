package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ValueController {

    /**
     * 方法一：使用 Servlet 原生 API 来实现
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
//    @RequestMapping(value = "/value-test2")
    public ModelAndView handleRequest1(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletRequest.setAttribute("message","数据返回成功！");
        return new ModelAndView("value-test2.jsp");
    }

    /**
     * 方法二：使用 Spring MVC 所提供的 ModelAndView 对象
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
//    @RequestMapping(value = "/value-test2")
    public ModelAndView handleRequest2(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView modelAndView = new ModelAndView("value-test2.jsp");
        modelAndView.addObject("message","数据返回成功2！");
        return modelAndView;
    }

    /**
     * 方法三：使用 Model 对象
     * @param model
     * @return
     */
//    @RequestMapping(value = "/value")
    public String handleRequest3(Model model){
        model.addAttribute("message","数据返回成功3！");
        return "value-test2";
    }

    /**
     * 方法四：使用 @ModelAttribute 注解：
     * @param model
     */
    @ModelAttribute
    public void model(Model model) {
        model.addAttribute("message", "注解成功4");
    }
    @RequestMapping("/value")
    public String handleRequest() {
        return "value-test2";
    }


}
