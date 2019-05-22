package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","Hello SpringMVC page safe!");
        return mav;
    }
}
