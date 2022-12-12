package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConversionController {
    @GetMapping("/homes")
    public String home(){
        return "index";
    }
    @PostMapping("/conversion")
    public ModelAndView conversion(HttpServletRequest request){
       Long num= Long.valueOf(request.getParameter("num"));
        Long type= Long.valueOf(request.getParameter("type"));
        Long result=num*type;
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("num",num);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
