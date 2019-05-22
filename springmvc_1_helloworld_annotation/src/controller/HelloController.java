package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("/an")//加上这个没出来，不知原因出在哪里
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("message","Hello SpringMVC Annotation!");
        return mav;
    }

}
