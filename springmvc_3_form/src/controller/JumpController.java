package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class JumpController {

    /**
     * 跳转一：请求转发：request.getRequestDispatcher
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/dispatcher")
    public void requestDispatcher(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF/page/index.jsp").forward(httpServletRequest, httpServletResponse);
    }

    /**
     * 跳转二：重定向：response.sendRedirect
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws IOException
     */
    @RequestMapping(value = "/redirect")
    public void sendRedirect(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("form_test.jsp");
    }

    /**
     * 跳转三：重定向：ModelAndView("redirect:/form_test.jsp")
     * @return
     */
    @RequestMapping(value = "/jump2")
    public ModelAndView sendRedirect2() {
        ModelAndView modelAndView = new ModelAndView("redirect:/form_test.jsp");
        return modelAndView;
    }

    /**
     * 跳转四：重定向
     * @return
     */
    @RequestMapping(value = "/jump3")
    public String sendRedirect3() {
        return "redirect: ./form_test.jsp";
    }
}
