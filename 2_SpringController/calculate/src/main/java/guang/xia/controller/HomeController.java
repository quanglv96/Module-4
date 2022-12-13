package guang.xia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "index";
    }
    @PostMapping("/result")
    public ModelAndView calculate(@RequestParam("calculation") String action, @RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("num2",num2);
        switch (action) {
            case "addition":
                modelAndView.addObject("result",(num1+num2));
                break;
            case "subtraction":
                modelAndView.addObject("result",(num1-num2));
                break;
            case "multiplication":
                modelAndView.addObject("result",(num1*num2));
                break;
            case "division":
                if(num2!=0){
                    modelAndView.addObject("result",(num1/num2));
                }else {
                    modelAndView.addObject("result","number 2 non-zero");
                }
                break;
        }
        return modelAndView;
    }
}
